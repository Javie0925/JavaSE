import java.awt.*;
import java.io.*;

/**
 * @author javie
 * @date 2019/9/16 11:08
 */
public class TxtFetch {

    public static void main(String[] args) throws Exception {

        File file = new File("C:\\Users\\lenovo\\Desktop\\111.txt");
        InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(new File("C:\\Users\\lenovo\\Desktop\\222.txt")));
        char[] chars = new char[1024];
        int len = 0;
        while ((len = reader.read(chars))!=-1){
            for (int i=0;i<len;i++){
                if (chars[i]>=256){
                    writer.write(chars, i, 1);
                }
            }
            writer.flush();
        }
    }
}
