package klook;

import java.util.Scanner;
public class Main {
    public static String solution(String longString, String alphabet) {
        //代码写这里
        if (longString.contains(alphabet)){
            return alphabet;
        }
        String fromHead = fromHead(longString, alphabet);
        String fromTail = fromTail(longString, alphabet);
        //System.out.println("fromHead: "+fromHead);
        //System.out.println("fromTail: "+fromTail);
        return fromHead.length()>fromTail.length()?fromTail:fromHead;
    }

    public static String fromHead(String longString, String alphabet){
        // 处理头部
        int start = 1;
        outer:while (start<longString.length()){
            String sub = longString.substring(start, longString.length());
            for (int i=0;i<alphabet.length();i++){
                if (!sub.contains(alphabet.substring(i, i+1))){
                    start--;
                    break outer;
                }
            }
            start++;
        }
        String res = longString.substring(start, longString.length());
        // 处理尾部
        int end = res.length()-2;
        outer:while (end>=0){
            String sub = res.substring(0, end+1);
            for (int i=0;i<alphabet.length();i++){
                if (!sub.contains(alphabet.substring(i, i+1))){
                    end++;
                    break outer;
                }
            }
            end--;
        }

        return res.substring(0, end+1);
    }

    public static String fromTail(String longString, String alphabet){
        // 处理尾部
        int end = longString.length()-2;
        outer:while (end>=0){
            String sub = longString.substring(0, end+1);
            for (int i=0;i<alphabet.length();i++){
                if (!sub.contains(alphabet.substring(i, i+1))){
                    end++;
                    break outer;
                }
            }
            end--;
        }
        String res = longString.substring(0, end+1);
        // 处理头部
        int start = 1;
        outer:while (start<res.length()){
            String sub = res.substring(start, res.length());
            for (int i=0;i<alphabet.length();i++){
                if (!sub.contains(alphabet.substring(i, i+1))){
                    start--;
                    break outer;
                }
            }
            start++;
        }
        return res.substring(start);
    }

    public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String longString = in.next();
            String alphabet = in.next();
            System.out.println(solution(longString, alphabet));
        
    }
}