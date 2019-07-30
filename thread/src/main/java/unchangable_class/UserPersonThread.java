package unchangable_class;

/**
 * @author javie
 * @date 2019/7/30 19:41
 */
public class UserPersonThread extends Thread {

    private Person person;

    public UserPersonThread(Person person){
        this.person = person;
    }

    @Override
    public void run() {
        while (true){
            System.out.println(Thread.currentThread().getName()+" print "+toString());
        }
    }
}
