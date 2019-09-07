package aaa;

import java.util.*;

public class Main {


/*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
请问他最少能买几件产品？
******************************开始写代码******************************/
    static int result = 0;
    static int solution(int[] prices, int budget) {
        Arrays.sort(prices);

        if (solution_(prices, prices.length-1, 0, budget)){
            return result;
        }
        return -1;
    }
    static boolean solution_(int[] prices,int index,int sum,int budget){

        if (!(index < prices.length) || index<0){
            return false;
        }
        if (sum==budget){
            return true;
        }else if(sum>budget){
            return false;
        }
        int p = prices[index];
        int count = ((budget-sum)/p);
        sum += p*count;
        if (sum==budget){
            result += count;
            return true;
        }else{
            if (solution_(prices, index-1, sum, budget)){
                result += count;
                return true;
            }else{
                for (int i=1;i<=count;i++){
                    sum -= p;
                    if (solution_(prices, index-1, sum, budget)){
                        result += i;
                        return true;
                    }
                }
            }
        }
        return false;

    }
/******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _prices_size = 0;
        _prices_size = Integer.parseInt(in.nextLine().trim());
        int[] _prices = new int[_prices_size];
        int _prices_item;
        for(int _prices_i = 0; _prices_i < _prices_size; _prices_i++) {
            _prices_item = Integer.parseInt(in.nextLine().trim());
            _prices[_prices_i] = _prices_item;
        }

        int _budget;
        _budget = Integer.parseInt(in.nextLine().trim());

        res = solution(_prices, _budget);
        System.out.println(String.valueOf(res));

    }
}
