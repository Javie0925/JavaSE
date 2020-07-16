import java.util.Scanner;

/**
 * @author javie
 * @date 2019/9/8 14:25
 */
public class Function {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            String line = sc.nextLine();
            String s = line.replaceAll("\\w", "");
            System.out.println(s);
        }
    }
}
