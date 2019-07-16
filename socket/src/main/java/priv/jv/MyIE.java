package priv.jv;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author javie
 * @date 2019/6/26 20:45
 */
public class MyIE {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("www.baidu.com",80);
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            out.println("GET / HTTP/1.1");
            out.println("Accept: text/html, application/xhtml+xml, image/jxr, */*");
            out.println("Accept-Language: zh-Hans-CN,zh-Hans;q=0.8,en-US;q=0.5,en;q=0.3");
            out.println("User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko");
            out.println("Accept-Encoding: gzip, deflate");
            out.println("Host: www.baidu.com");
            out.println("Connection: Keep-Alive");
            out.println();
            out.println();

            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = null;
            while((line = bufferedReader.readLine())!=null){
                System.out.println(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
/*
GET / HTTP/1.1
Host: localhost:30000
Connection: keep-alive
Cache-Control: max-age=0
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.108 Safari/537.36
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,;q=0.8,application/signed-exchange;v=b3
Accept-Encoding: gzip, deflate, br
Accept-Language: en,zh-CN;q=0.9,zh;q=0.8

 */