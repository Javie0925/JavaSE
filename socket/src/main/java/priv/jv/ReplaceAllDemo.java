package priv.jv;

/**
 * @author javie
 * @date 2019/6/30 23:14
 */
public class ReplaceAllDemo {

    public static void main(String[] args) {

        String regex = "\\[em_([0-9]*)\\]";
        String dst = "<img src='/face/$1.gif' border='0' />";

        String str = "[em_22][em_41][em_40][em_73][em_43]";

        String result = str.replaceAll(regex, dst);
        System.out.println(str);
        System.out.println(result);
    }
}
