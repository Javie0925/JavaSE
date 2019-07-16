package priv.jv.leetcode.ransom;

import org.junit.Test;

import java.util.Arrays;

public class RansomSolution {
    public boolean canConstruct1(String ransomNote, String magazine) {
        StringBuilder m = new StringBuilder(magazine);
        for(int i=0;i<ransomNote.length();i++){
            String temp = ransomNote.substring(i,i+1);
            int index = m.indexOf(temp);
            if(index>=0){
                m.delete(index,index+1);
            }else{
                return false;
            }
        }
        return true;
    }
    
    // 哈希查表法
    public boolean canConstruct(String ransomNote, String magazine) {
        // 建表
        byte[] counts = new byte[128];
        for(int i=0;i<magazine.length();i++){
            char c = magazine.charAt(i);
            counts[c] += 1;
        }
        System.out.println(Arrays.toString(counts));
        // 查询
        for(int i=0;i<ransomNote.length();i++){
            char c = ransomNote.charAt(i);
            counts[c] -= 1;
            if((int)counts[c]<0){
                return false;
            }
        }
        return true;
        
    }

    @Test
    public void fun(){
        boolean b = canConstruct("a", "b");
        System.out.println(b);
    }
}