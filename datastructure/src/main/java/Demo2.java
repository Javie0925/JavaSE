

import java.util.*;

/**
 * @author javie
 * @date 2019/7/17 2:14
 */
public class Demo2 {

    public static void main(String[] args) {
        Set<Object> set = new HashSet<>();

        Iterator<Object> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        Vector<Object> vector = new Vector<>();
        Vector<Object> newVector = new Vector<>();
        while (!vector.isEmpty()){
            Object remove = vector.remove(0);
            if (!vector.contains(remove)){
                newVector.add(remove);
            }
        }

    }

    /*static private char aChar;

    public int add(int a,int b){
        return 0;
    }

    public void add(int a,int b,int c){
        StringBuilder stringBuilder = new StringBuilder();
        new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        // "".matches()
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
    }*/

}
