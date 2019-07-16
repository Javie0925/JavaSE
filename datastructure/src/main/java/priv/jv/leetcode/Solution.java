package priv.jv.leetcode;

import org.junit.Test;

public class Solution {
    public int mySqrt1(int x) {
        return (int)Math.sqrt(x);
    }


    @Test
    public void test1(){
        System.out.println(mySqrt(1000000));
    }

    // 二分查找
    public int mySqrt(int x) {
        int result = 0;
        int start = 0;
        int end = x;
        int mid = 0;
        while(start<end){
            if(start==end){
                return start;
            }
            mid = start + ((end-start)>>1);
            if(mid*mid>x){
                if((mid-1)*(mid-1)<=x){
                    result = mid-1;
                    break;
                }
                end = mid-1;
            }else if(mid*mid<x){
                if((mid+1)*(mid+1)>x){
                    result = mid;
                    break;
                }else if((mid+1)*(mid+1)==x){
                    result = mid+1;
                    break;
                }
                start = mid+1;
            }else{
                result = mid;
                break;
            }
        }
        return result;
        
    }
    

}