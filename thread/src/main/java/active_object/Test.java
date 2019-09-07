package active_object;

/**
 * @author javie
 * @date 2019/8/1 14:13
 */
public class Test {

    public static void main(String[] args) {

        ActiveObject activeObject = ActiveObjectFactory.createActiveObject();
        new MakerClientThread("Javie",activeObject).start();
        new MakerClientThread("Cathy",activeObject).start();

        new DisplayClientThread("Jack",activeObject).start();
    }
}
