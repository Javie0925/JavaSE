package two_phase_termination;

import java.io.IOException;

/**
 * @author javie
 * @date 2019/7/31 23:15
 */
public class AppServerClient {

    public static void main(String[] args) throws InterruptedException, IOException {
        AppServer appServer = new AppServer(13345);
        appServer.start();

        Thread.sleep(45_000);

        appServer.shutdown();
    }
}
