package work_thread;

/**
 * @author javie
 * @date 2019/8/1 0:48
 */
public class Client {

    public static void main(String[] args) {
        final Channel channel = new Channel(5);
        channel.startWorker();
        new TransportThread("Javie",channel).start();
        new TransportThread("Cathy",channel).start();
        new TransportThread("Molie",channel).start();
        new TransportThread("Miley",channel).start();
    }
}
