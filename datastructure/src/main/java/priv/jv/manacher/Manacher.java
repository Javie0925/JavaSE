package priv.jv.manacher;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author javie
 * @date 2019/7/23 20:44
 */
public class Manacher {

    @Test
    public void fun(){
        String s = "121";
        String manacher = manacher(s);
        System.out.println(manacher);
    }

    public String manacher(String s){

        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (int i=0;i<s.length();i++){
            sb.append(s.charAt(i)+"#");
        }
        String ss = sb.toString();
        System.out.println(ss);
        int id = 1;
        int mx = 2;
        int[] len = new int[ss.length()];
        len[0] = 1;
        len[1] = 2;
        for (int i=2;i<ss.length();i++){
            int j = 2*id-i;
            if (i<mx && len[j]<mx-i+1){
                len[i] = Math.min(mx-i,len[2*id-i]);
            }else if(i<mx && len[j]>=mx-i+1){
                len[i] = mx-i+1;
                id = i;
                while(mx+1<ss.length() && 2*id-mx-1>=0 && ss.charAt(mx+1)==ss.charAt(2*id-mx-1)){
                    len[i] += 1;
                    mx = mx+1;
                }
            }else if(i>=mx){
                len[i] = 1;
                id = i;
                mx = i;
                while (mx+1<ss.length() && 2*id-mx-1>=0 && ss.charAt(mx+1)==ss.charAt(2*id-mx-1)){
                    len[i] += 1;
                    mx = mx+1;
                }
            }
        }
        System.out.println(Arrays.toString(len));
        // len数组中的最大数下标
        int index = 0;
        int max = len[0];
        for (int i=1;i<len.length;i++){
            if (len[i]>max){
                max = len[i];
                index = i;
            }
        }

        return s.substring((index-(max-1))/2, (index-(max-1))/2+max-1);
    }
}
