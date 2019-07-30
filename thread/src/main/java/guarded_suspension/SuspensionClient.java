package guarded_suspension;

/**
 * @author javie
 * @date 2019/7/30 21:59
 */
public class SuspensionClient {

    public static void main(String[] args) throws InterruptedException {
        final RequestQuene quene = new RequestQuene();
        new ClientThread(quene,"Alex").start();
        ServerThread server = new ServerThread(quene);
        server.start();

        //server.join();
        Thread.sleep(10_000);

        server.close();

    }
}
