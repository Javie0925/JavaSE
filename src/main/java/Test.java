import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args)  {

        Test2[] arr = new Test2[2];
        arr[0] = new Test2("javie",23);
        arr[1] = new Test2("cathy",21);
        Test2[] clone = arr.clone();
        arr[0].setAge(25);
        System.out.println(clone[0]);
        System.out.println(clone[1]);
        System.out.println(Inner.name);
    }

    static class Inner{
        public static String name = "123";
    }
    public void test(int b) {
        int a = 10;
        // a=20;
        new Thread(){
            public void run() {
                System.out.println(a);
                System.out.println(b);
            };
        }.start();
    }
}
class Test2{
    private String name = "javie";

    private int age = 23;

    public Test2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Test2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

interface Inter{
    String name = "jv";
}

abstract class Father {

    private String name;

    public Father(){
        System.out.println("父类无参构造");
    }
    private Father(int i){
        System.out.println("private Father");
    }
}

abstract class Child extends Object{


    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1 );
        list.add(2 );
        list.add(3);
        List<Integer> integers = Collections.unmodifiableList(list);
        System.out.println();
    }
}