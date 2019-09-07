package neteast;
// 本题为考试多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            String str = Integer.toBinaryString(num);
            for (int j = 0; i < str.length(); i++) {
                if ("0".equals(str.substring(j, j + 1))) {
                    str = str.replaceFirst("0", "");
                } else {
                    break;
                }
            }
            StringBuilder sb = new StringBuilder(str);
            if (str.equals(sb.reverse().toString())){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}