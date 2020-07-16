package huawei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @author javie
 * @date 2019/9/22 0:04
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nextLine = sc.nextLine();
        int rows = Integer.parseInt(nextLine);
        HashMap<String, String> map = new HashMap<>();
        List<String> unknown = new ArrayList<>();
        for (int i=0;i<rows-1;i++){
            String eq = sc.nextLine();
            // 去除空格
            eq = eq.replaceAll(" ", "");
            String[] eqs = eq.split("=");
            String left = eqs[0];
            String right = eqs[1];
            if (left.matches("[a-zA-Z]+") && right.matches("\\d")){
                map.put(left, right);
            }else if (right.matches("[a-zA-Z]+") && left.matches("\\d")){
                map.put(right, left);
            }else {
                unknown.add(eq );
            }
        }
    }

}
