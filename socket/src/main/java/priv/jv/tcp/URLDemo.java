package priv.jv.tcp;


import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author javie
 * @date 2019/6/26 22:28
 */
public class URLDemo {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.baidu.com");
            URLConnection urlConnection = url.openConnection();
            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();
            byte[] bytes = new byte[1024*1024*10];
            int len = inputStream.read(bytes);
            System.out.println(new String(bytes,0,len));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
