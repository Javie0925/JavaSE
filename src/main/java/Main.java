import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
      
        while(sc.hasNext())
        {
            String nextLine = sc.nextLine();
            Pattern compile = Pattern.compile("\\d*");
            Matcher matcher = compile.matcher(nextLine);
            int i=1;
            int n = 0,m = 0,k = 0;
            while (matcher.find() && i<=3){
                if (i==1){
                    n = Integer.parseInt(matcher.group());
                }else if (i==2){
                    m = Integer.parseInt(matcher.group());
                }else {
                    k = Integer.parseInt(matcher.group());
                }
            }
            for (int x=1;x<=n;x++){
                for(int y=1;y<=m;y++){
                    if ((x+y)==k){
                        System.out.println(x*y);
                        break;
                    }
                }
            }
        }
     }
}