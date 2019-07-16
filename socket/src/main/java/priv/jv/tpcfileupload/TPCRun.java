package priv.jv.tpcfileupload;

import java.io.*;
import java.net.Socket;

/**
 * @author javie
 * @date 2019/6/26 17:47
 */
public class TPCRun implements Runnable{

    private Socket socket;

    public TPCRun(Socket socket){
        this.socket = socket;
    }

    public void run() {
        String ip = socket.getInetAddress().getHostAddress();
        try {
            // 获取ip
            System.out.println(ip+" is connected.");
            // 获取输入流
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024*1024*10];
            // 获取数据保存地址
            File file = new File("C:\\Users\\lenovo\\Desktop",ip+System.currentTimeMillis()+".jpg");
            // 创建新文件
            file.createNewFile();
            OutputStream outputStream = new FileOutputStream(file);
            int len = 0;
            // 读取保存数据
            while (( len = inputStream.read(bytes))!=-1){
                outputStream.write(bytes, 0, len);
            }
            // 返回成功信息
            socket.getOutputStream().write("上传成功！".getBytes());
            socket.shutdownOutput();
            System.out.println(ip+":上传成功！");
            // 关闭资源
            outputStream.close();
            socket.close();
        }catch (Exception e){
            System.out.println(ip+":上传失败！");
            e.printStackTrace();
        }
    }
}
