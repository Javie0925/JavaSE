import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author javie
 * @date 2019/9/16 17:14
 */
public class Migu {

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Date date = format.parse("2018/12/31");
        long time = date.getTime();
        new Date();
        while (sc.hasNext()){
            String line = sc.nextLine();
            String[] split = line.split(" ");
            String y = split[0];
            String m = split[1];
            String d = split[2];
            String all = y+"/"+m+"/"+d;
            Date parse = format.parse(all);
            long current = parse.getTime()- time;
            System.out.println(current/(24*60*60*1000));
        }
    }
}
