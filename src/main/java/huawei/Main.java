package huawei;

import java.util.Scanner;

/**
 * @author javie
 * @date 2019/9/21 21:41
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (sc.hasNextLine()){
            String line = sc.nextLine();
            if ("".equals(line))
                break;
            sb.append(line.replaceAll(" ", ""));
        }

        System.out.println(sb.toString());
    }
}
