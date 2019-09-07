package test;

/**
 * @author javie
 * @date 2019/8/1 23:46
 */
public class Singleton {

    private static Singleton instance = new Singleton();

    public static int x = 0;

    public static int y;

    public Singleton() {
        x++;
        y++;
    }

    public static Singleton getInstance(){
        return instance;
    }
}

class MainClass{

    public static void main(String[] args) {
        // Singleton instance = Singleton.getInstance();
        System.out.println("x:"+Singleton.x);
        System.out.println("y:"+Singleton.y);
    }
}