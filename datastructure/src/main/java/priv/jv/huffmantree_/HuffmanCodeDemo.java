package priv.jv.huffmantree_;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HuffmanCodeDemo {
    public static void main(String[] args) throws Exception {
//TODO Auto -generated method stub
        String msg = "can you can a can as a can canner can a  can.";
        System.out.println(msg);
        byte[] bytes = msg.getBytes();
        System.out.println(bytes.length);
//进行赫夫曼编码
        byte[] zipCode = huffmanZip(bytes);
        System.out.println(Arrays.toString(zipCode));
        System.out.println(zipCode.length);
        System.out.println("--------------------------------");
//获取编码表
        Map<Byte, String> codeMap = getCodeMap(bytes);
        byte[] unZipBytes = unZip(zipCode, codeMap);
        System.out.println(new String(unZipBytes));
        System.out.println("---------------------------------");
        zipFile("F:\\面试\\2020实习生校招_信息技术岗_厦门大学_电子与通信工程_王家伟.zip", "C:\\Users\\lenovo\\Desktop\\111.txt1");
//unZipFile("2.zip", "3.bmp");
        System.out.println("---------------------------------");
    }

    /**
     * 解压缩文件
     * <p>
     * * @param src 源文件
     * * @param dst 目标文件
     * * @throws Exception
     */
    private static void unZipFile(String src, String dst) throws Exception {
//TODO Auto -generated method stub
        InputStream in = new FileInputStream(src);
        ObjectInputStream ois = new ObjectInputStream(in);
        OutputStream os = new FileOutputStream(dst);
//获取压缩码
        byte[] codes = (byte[]) ois.readObject();
//获取编码表
        Map<Byte, String> huffmanMap = (Map<Byte, String>) ois.readObject();
//关闭输入流
        in.close();
        ois.close();
//获取解压缩代码
        byte[] b = unZip(codes, huffmanMap);
        os.write(b);
        os.close();
    }

    /**
     * 压缩文件方法      * @param src 源文件      * @param dst 目标文件      * @throws Exception
     */
    private static void zipFile(String src, String dst) throws Exception {
        InputStream is = new FileInputStream(src);
        byte[] b = new byte[is.available()];
        is.read(b);
        is.close();
//获得编码表
        Map<Byte, String> huffmanMap = getCodeMap(b);
        byte[] b2 = zip(b, huffmanMap);
        OutputStream os = new FileOutputStream(dst);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(b2);
        oos.writeObject(huffmanMap);
        os.close();
        oos.close();
    }

    /**
     * * 解压缩方法      *      * @param zipCode      * @return
     */
    private static byte[] unZip(byte[] zipCode, Map<Byte, String> codeMap) {
//先把压缩码解压缩成二进制字符串
        StringBuilder binCode = new StringBuilder();
        int last = zipCode[zipCode.length - 1];
//处理前部
        for (int i = 0; i < zipCode.length - last - 1; i++) {
            binCode.append(byteToBitString(zipCode[i]));
        }
//处理last部分
        for (int i = zipCode.length - last - 1; i < zipCode.length - 1; i++) {
            binCode.append((char) zipCode[i]);
        }
        System.out.println(binCode);
//遍历编码表，进行解码 新建一个StringBuilder
        List<Byte> temp = new ArrayList<Byte>();
//定义源码长度
        int len = 0;
        if (binCode.length() % 8 == 0) {
            len = binCode.length();
        } else {
            len = binCode.length() + 1;
        }
        String binCodeStr = binCode.toString();
        System.out.println(temp.size());
        while (binCode.length() > 0) {
            for (Map.Entry<Byte, String> entry : codeMap.entrySet()) {
                if (binCode.toString().startsWith(entry.getValue())) {
                    temp.add(entry.getKey());
                    binCode.delete(0, entry.getValue().length());
                }
            }
            System.out.println(binCode.length());
        }
        System.out.println(temp.size());
//将List转为 byte[]
//int len = temp.size();
        byte[] b = new byte[len];
        int index = 0;
        for (Byte b1 : temp) {
            b[index++] = b1;
        }
        System.out.println(b.length);
        return b;
    }

    /**
     * 获取8位的二进制字符串      * @param b      * @return
     */
    private static String byteToBitString(byte b) {
        String s = null;
        int temp = b;
        temp |= 256;
        s = Integer.toBinaryString(temp);
        return s.substring(s.length() - 8);
    }

    /**
     * * @param bytes      * @return
     */
    private static byte[] huffmanZip(byte[] bytes) {
//创建赫夫曼树
        Node root = getHuffmanTree(bytes);
        System.out.println(root.left.value);
//创建一个赫夫曼【编码表】
//Map<Byte, String> map = getCodeMap(bytes);
        Map<Byte, String> map = getCodes(root);
//获取编码
        byte[] b = zip(bytes, map);
        System.out.println(b.length);
        return b;
    }

    /**
     * 获取编码表      * @param bytes      * @return
     */
    private static Map<Byte, String> getCodeMap(byte[] bytes) {
//创建赫夫曼树
        Node root = getHuffmanTree(bytes);
        Map<Byte, String> map = getCodes(root);
        return map;
    }

    /**
     * 压缩方法      * @param bytes      * @param map2      * @return
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> map2) {
//TODO Auto -generated method stub
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(map2.get(b));
        }
        System.out.println(sb.toString());
        int len = 0;
        if (sb.length() % 8 == 0) {
            len = sb.length() / 8;
        } else {
            len = sb.length() / 8 + sb.length() % 8 + 1;
        }
        byte[] bytes2 = new byte[len];
        for (int i = 0, n = 0; i < bytes2.length; i++, n = 8 * i) {
            if (n + 8 < sb.length()) {
                bytes2[i] = (byte) (Integer.parseInt(sb.substring(n, n + 8), 2));
            } else {
                for (; i < len - 1; i++) {
                    bytes2[i] = (byte) sb.charAt(n++);
                }
                bytes2[i] = (byte) (sb.length() % 8);
            }
        }
        return bytes2;
    }

    //    创建一个map用于存储编码
    public static Map<Byte, String> map = new HashMap<Byte, String>();

    /**
     * 获取编码表map      * @param node      * @return
     */
    private static Map<Byte, String> getCodes(Node node) {
//创建一个StringBuilder用于存储单个编码
        StringBuilder sb = new StringBuilder();
//获取左边的编码
        getCodes(node.left, "0", sb);
//获取右边的编码
        getCodes(node.right, "1", sb);
        return map;
    }

    private static void getCodes(Node node, String string, StringBuilder sb) {
//TODO Auto -generated method stub
        if (node == null) {
            return;
        }
        sb = new StringBuilder(sb);
        sb.append(string);
//处理左结点
        if (node.data == null) {
            getCodes(node.left, "0", sb);
            getCodes(node.right, "1", sb);
        } else {
            map.put(node.data, sb.toString());
        }
    }

    /**
     * 统计数字并排序      * @param bytes
     */
    private static Node getHuffmanTree(byte[] bytes) {
//创建集合用于存储结点
        List<Node> nodes = new ArrayList<>();
//创建map存储字符出现次数
        Map<Byte, Integer> counts = new HashMap<>();
//循环数组，将键值对存入map中
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (counts.get(b) == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }
//把每一个键值对转为一个Node对象, 存入集合中
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
//创建赫夫曼树
        Node root = getNode(nodes);
        return root;
    }

    /**
     * 创建赫夫曼树方法      * @param nodes      * @return
     */
    private static Node getNode(List<Node> nodes) {
        while (nodes.size() > 1) {
//    排序
            Collections.sort(nodes);
//    取出最小的两个结点创建树
            Node left = nodes.get(nodes.size() - 1);
            Node right = nodes.get(nodes.size() - 2);
            Node parent = new Node(null, left.value + right.value);
//    将两个子结点赋给parent的左右子结点
            parent.left = left;
            parent.right = right;
//    删除两个最小结点
            nodes.remove(left);
            nodes.remove(right);
//    将新的跟结点加入集合
            nodes.add(parent);
        }
        return nodes.get(0);
    }
}
