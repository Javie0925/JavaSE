package klook;

import java.util.Scanner;
public class Main1 {

    public static String solution(String line) {
        //代码写这里

        return line.replaceFirst("6", "9");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String firstLine = in.next();
        System.out.println(solution(firstLine));
    }
}