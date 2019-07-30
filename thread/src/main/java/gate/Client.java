package gate;

/**
 * @author javie
 * @date 2019/7/30 16:34
 */
public class Client {
    public static void main(String[] args) {
        Gate gate = new Gate();
        User user1 = new User("bb","beijing",gate);
        User user2 = new User("ss","shanghai",gate);
        User user3 = new User("gg","guangzhou",gate);
        user1.start();
        user2.start();
        user3.start();
    }
}
