/**
 * @author javie
 * @date 2019/9/11 15:25
 */
public class Demo0911 {

    private String name = "javie";

    private static int age = 23;

    public void start(){
        new InnerClass().start();
    }

    public void hello(){

        String address = "xmu";

        new Thread(){
            @Override
            public void run() {
                System.out.println(name);
                System.out.println(address);
            }
        }.start();
    }

    private class InnerClass{
        private String male = "male";

        public String  get(){
            return name;
        }

        public void start() {
            hello();
        }
    }
}
class Main1{
    public static void main(String[] args) {
        Demo0911 demo = new Demo0911();
        demo.start();

    }
}
