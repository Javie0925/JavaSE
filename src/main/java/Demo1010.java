import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author javie
 * @date 2019/10/12 16:08
 */
public class Demo1010 {

    public static void main(String[] args) {
        String str = "2135dfsad";
//        "".replaceFirst(, )

    }

    public static void main1(String[] args) {

        List<Integer> nums = new ArrayList<>();

        List<String> marks = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String eq = s.replaceAll(" ", "");
        // 找出数字和算符
        for (int start=0,end=start+1;start<eq.length();){

            if (end<=eq.length() && eq.substring(start, end).matches("\\d")) {

                while (end<eq.length() && eq.substring(end, end + 1).matches("\\d")) {
                    end++;
                }
                nums.add(Integer.parseInt(eq.substring(start, end)));
                start = end;
                end = start + 1;
            }else {
                marks.add(eq.substring(start,end));
                start++;
                end=start+1;
            }
        }
        System.out.println(nums.toString());
        System.out.println(marks.toString());
        // 先计算乘除
        for (int i=0;i<marks.size();){
            String m = marks.get(i);
            if (m.equals("*")){
                // 移除符号
                marks.remove(i);
                // 移除数字
                int a1 = nums.remove(i);
                int a2 = nums.remove(i);
                // 加入新数字
                nums.add(i,a1*a2 );
            }else if (m.equals("/")){
                marks.remove(i);
                int a1 = nums.remove(i);
                int a2 = nums.remove(i);
                nums.add(i,a1/a2);
            }else {
                i++;
            }
        }
        System.out.println(nums.toString());
        // 计算加减
        int result = nums.remove(0);
        for (int i=0;i<marks.size();){
            String m = marks.remove(0);
            if (m.equals("+")){
                result += nums.remove(0);
            }else {
                result -= nums.remove(0);
            }
        }

        System.out.println(result);
    }
}
