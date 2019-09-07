package test;

/**
 * @author javie
 * @date 2019/8/2 0:10
 */
public class TestClass {
    public static void main(String[] args) {
        MyObject myObject = new MyObject();
        MyObject myObject1 = new MyObject();
        MyObject myObject2 = new MyObject();
        MyObject myObject3 = new MyObject();
        MyObject myObject4 = new MyObject();

        System.out.println(myObject.getClass()==myObject1.getClass());
        System.out.println(myObject.getClass()==myObject2.getClass());
        System.out.println(myObject.getClass()==myObject3.getClass());
    }
}

class MyObject{


}
