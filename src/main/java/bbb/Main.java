package bbb;
// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int group = Integer.parseInt(sc.nextLine());
        for (int i=0;i<group;i++){
            String s = sc.nextLine();
            String[] split = s.split(" ");
            int rows = Integer.parseInt(split[0]);
            for (int j=0;j<rows;j++){
                String s1 = sc.nextLine();
            }
            System.out.println("-1 -1 -1 -1");
        }
    }
}