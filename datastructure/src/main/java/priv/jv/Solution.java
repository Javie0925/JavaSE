package priv.jv;

public class Solution {
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            digits[i] = (digits[i]+1)%10;
            System.out.println(digits[i]);
            if(digits[i] != 0){ //没有进位，直接返回结果
                return digits;
            }
        }
        // 循环结束，修改数组
        int[] r = new int[digits.length+1];
        r[0] = 1;
        for(int i=1;i<r.length;i++){
            r[i] = 0;
        }
        return r;
    }
}