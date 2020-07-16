package singleton;

/**
 * @author javie
 * @date 2019/9/11 13:55
 */
public class Hunger {

    private static Hunger instance = new Hunger();

    private Hunger(){

    }

    public static Hunger getInstance(){
        return instance;
    }
}
