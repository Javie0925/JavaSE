package neteast;// 本题为考试多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int group = Integer.parseInt(sc.nextLine());

        for(int i = 0; i < group; i++){
            // 获取间隔和天数
            String str = sc.nextLine();
            String[] strs = str.split(" ");
            int k = Integer.parseInt(strs[0]);
            int dayCount = Integer.parseInt(strs[1]);
            // 获取具体日期
            String daysStr = sc.nextLine();
            if (k==0){
                System.out.println(30);
                continue;
            }
            if (dayCount==0){
                int result = 0;
                for (int j=1;j<=30;){
                    result++;
                    j = j+k+1;
                }
                System.out.println(result);
                continue;
            }
            String[] daysStrArr = daysStr.split(" ");
            int[] days = new int[dayCount];
            for (int z=0;z<dayCount;z++){
                days[z] = Integer.parseInt(daysStrArr[z]);
            }
            int result = days.length;
            int start = 1;
            // 处理头部
            while (days[0] >= (start+k+1)){
                result++;
                start += (k+1);
            }
            for (int j=0;j<days.length-1;j++){
                int current = days[j]+k+1;
                while ((current+k+1) <= days[j+1]){
                    current += (k+1);
                    result ++;
                }
            }
            // 处理尾部
            int tail = days[days.length-1];
            while ((tail+k+1)<=30){
                result ++;
                tail += (k+1);
            }
            System.out.println(result);
        } 
    }
}