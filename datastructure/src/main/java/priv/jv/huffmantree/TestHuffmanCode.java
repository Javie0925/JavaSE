package priv.jv.huffmantree;

import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * @author javie
 * @date 2019/7/6 22:36
 */
public class TestHuffmanCode {

    // 编码表
    private Map<Byte, String> codesMap;

    @Test
    public void fun(){
        /*String str = "can you can a can as a can canner can a can.";
        byte[] bytes = str.getBytes();
        System.out.println(bytes.length);
        System.out.println(Arrays.toString(bytes));
        // 压缩
        byte[] zip = huffmanZip(bytes);
        System.out.println(Arrays.toString(zip));
        System.out.println(zip.length);
        // 获取编码表
        Map<Byte, String> codesMap = getCodesMap(createHuffmanTree(createNodes(bytes)));
        // 解压
        // System.out.println(Integer.toBinaryString(0));
        byte[] unZip = unZip(zip,codesMap);
        System.out.println(Arrays.toString(unZip));
        System.out.println(new String(unZip));*/

         //测试文件压缩
        //zipFile("F:\\资料\\临时文件\\axiuluo.jpg", "C:\\Users\\lenovo\\Desktop\\111.jpg");
        // 测试解压文件
        unZipFile("C:\\Users\\lenovo\\Desktop\\111.jpg","C:\\Users\\lenovo\\Desktop\\111-1.jpg");
    }

    /**
     * 解压文件方法
     * @param path
     * @param dst
     */
    public void unZipFile(String path,String dst){
        File file = new File(path);
        try {
            // 读取压缩文件
            InputStream in = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(in);
            byte[] bytes = (byte[])ois.readObject();
            Map<Byte,String> codesMap = (Map<Byte,String>)ois.readObject();
            byte[] unZip = unZip(bytes, codesMap);
            // 生成新文件
            File dstFile = new File(dst);
            dstFile.createNewFile();
            OutputStream out = new FileOutputStream(dstFile);
            out.write(unZip);
            out.close();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 压缩文件方法
     * @param path
     * @param dst
     * @return
     */
    public byte[] zipFile(String path,String dst){

        // 根据文件路径创建输入流
        File file = new File(path);
        try {
            FileInputStream in = new FileInputStream(file);
            // 读取数据
            byte[] bytes = new byte[in.available()];
            System.out.println("bytes.length="+bytes.length);
            int read = in.read(bytes);
            System.out.println("read ="+read);
            // 压缩，得到压缩数据
            byte[] zip = huffmanZip(bytes);
            System.out.println("zip.length="+zip.length);
            // 将数据和编码表写入目标文件
            File dstFile = new File(dst);
            if (!dstFile.exists()){
                dstFile.createNewFile();
            }
            // 创建对象输出流
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(dstFile));
            out.writeObject(zip);
            out.writeObject(this.codesMap);
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }

    /**
     * 解压方法
     * @param zip
     * @return
     */
    private byte[] unZip(byte[] zip,Map<Byte,String> codesMap) {

        // 获取数据zip数组最后一个数字
        int last = zip[zip.length-1];
        // 把数据转为二进制字符串
        StringBuilder sb = new StringBuilder(); //用于存储字符串
        for (int i=0;i<zip.length-last-1;i++){
            String s = byteToBinaryString(zip[i]);
            sb.append(s);
        }
        // 处理剩余数据
        for (int i=zip.length-last-1;i<zip.length-1;i++){
            sb.append(zip[i]+"");
        }
        // 解码
        String zipStr = sb.toString();
        //System.out.println("unz()"+zipStr);
        //System.out.println("zipStr.length():"+zipStr.length());
        // 创建数组存储解码数据
        List<Byte> unZip = new ArrayList<>();
        int index = 0; // 标记数组位置
        // 调换codesMap里的键和值
        Map<String,Byte> newCodesMap = new HashMap<>();
        for (Map.Entry<Byte,String> entry:codesMap.entrySet()){
            newCodesMap.put(entry.getValue(), entry.getKey());
        }
        for (int i=0;i<zipStr.length();){
            for (int j=i+1;j<=zipStr.length();j++){
                if (newCodesMap.containsKey(zipStr.substring(i,j))){
                    // 获取key值存入unZip数组
                    unZip.add(newCodesMap.get(zipStr.substring(i,j)));
                    i=j;
                    break;
                }
            }
            //System.out.println(unZip);
        }
        Byte[] bs = new Byte[unZip.size()];
        unZip.toArray(bs);
        byte[] result = new byte[bs.length];
        for (int i=0;i<bs.length;i++){
            result[i] = bs[i].byteValue();
        }
        return result;

    }

    private String byteToBinaryString(byte b) {
        String str = Integer.toBinaryString(((int)b)|256);
        return str.substring(str.length()-8);
    }

    public byte[] huffmanZip(byte[] bytes){
        // 统计每一个byte出现的次数，并存入集合中
        List<Node> nodeList = createNodes(bytes);
        // 创建一颗赫夫曼树
        Node tree = createHuffmanTree(nodeList);
        // tree.inOrderTraversal();
        // 创建赫夫曼编码表
        Map<Byte, String> codesMap = getCodesMap(tree);
        this.codesMap = codesMap;
        /*System.out.println();
        for (Map.Entry<Byte,String> entry:codesMap.entrySet()){
            System.out.print("{"+(char)entry.getKey().byteValue()+":"+entry.getValue()+"}");
        }*/
        // 编码
        byte[] zip = zip(bytes, codesMap);
        return zip;
    }

    /**
     * 编码
     * @param arr
     * @param huffmanMap
     * @return
     */
    public byte[] zip(byte[] arr,Map<Byte,String> huffmanMap){
        StringBuilder sb = new StringBuilder();
        // 根据编码表进行编码
        for (byte b: arr){
            sb.append(huffmanMap.get(b));
        }
        // 将字符串转为数组
        String str = sb.toString(); // 设定数组长度,最后一位用来记录最后一组数据的长度
        //System.out.println("zip()"+str);
        int len = str.length()/8+str.length()%8+1;
        byte[] result = new byte[len];
        for (int i=0,j=0;i<str.length();j++){
            String substring;
            if (i+8<=str.length()){
                substring = str.substring(i, i + 8);
                byte b = (byte) Integer.parseInt(substring,2);
                result[j] = b;
                i+=8;
            }else { // 最后一个组
                substring = str.substring(i, i+1);
                byte b = (byte) Integer.parseInt(substring,2);
                result[j] = b;
                i++;
            }
        }
        // 结果数组最后一位记录长度
        result[result.length-1] = new Byte(str.length()%8+"").byteValue();
        return result;
    }
    /**
     * 创建结点集合方法
     * @param bytes
     * @return
     */
    public List<Node> createNodes(byte[] bytes){
        // 创建集合
        List<Node> nodeList = new ArrayList<Node>();
        // 创建map，统计次数
        Map<Byte,Integer> map = new HashMap<>();
        for (byte b :bytes){
            Integer count = map.get(b);
            if (count==null){
                map.put(b, 1);
            }else {
                map.put(b, map.get(b)+1);
            }
        }
        // 根据map创建结点
        for (Map.Entry<Byte,Integer> entry:map.entrySet()){
            nodeList.add(new Node(entry.getKey(),entry.getValue()));
        }
        // 返回
        return nodeList;
    }

    public Node createHuffmanTree(List<Node> nodeList){
        while (nodeList.size()>1){
            // 排序
            Collections.sort(nodeList);
            //System.out.println(nodeList);
            // 取出最小的两个组成新树
            Node newNode = new Node(nodeList.get(0).getWeight() + nodeList.get(1).getWeight());
            newNode.setLeftNode(nodeList.remove(0));
            newNode.setRightNode(nodeList.remove(0));
            // 存入新子树
            nodeList.add(newNode);
        }
        return nodeList.get(0);
    }

    // 用于临时存储路径
    private StringBuilder sb = new StringBuilder();
    // 用于存储赫夫曼编码
    private Map<Byte,String> huffmanMap = new HashMap<>();
    /**
     * 根据赫夫曼树获取赫夫曼编码表
     * @param tree
     * @return
     */
    public Map<Byte,String> getCodesMap(Node tree){

        if (tree==null)
            return null;
        getCodesMap(tree.getLeftNode(),"0",new StringBuilder());
        getCodesMap(tree.getRightNode(),"1",new StringBuilder());
        return huffmanMap;
    }

    private void getCodesMap(Node node, String s, StringBuilder sb) {
        if (node==null)
            return;
        sb.append(s);
        StringBuilder newSb = new StringBuilder(sb);
        if (node.getData()==null){ //不是叶子结点
            getCodesMap(node.getLeftNode(), "0", sb);
            getCodesMap(node.getRightNode(),"1",newSb);
        }else { // 是叶子结点
            huffmanMap.put(node.getData(), sb.toString());
        }
    }
}
