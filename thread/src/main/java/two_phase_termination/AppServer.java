package two_phase_termination;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author javie
 * @date 2019/7/31 22:47
 */
public class AppServer extends Thread {

    private final int port;

    private static final int DEFAULT_PORT = 12722;

    private volatile boolean start = true;

    private List<ClientHandler> clientHandlers = new ArrayList<>();

    private static ExecutorService executor = Executors.newFixedThreadPool(10);

    private ServerSocket serverSocket;

    public AppServer(){
        this(DEFAULT_PORT);
    }

    public AppServer(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(port);
            while (start){
                Socket client = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(client);
                executor.execute(clientHandler);
                this.clientHandlers.add(clientHandler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            this.dispose();
        }
    }

    private void dispose() {
        clientHandlers.stream().forEach(ClientHandler::stop);
        this.executor.shutdown();
    }


    public void shutdown() throws IOException {
        this.start = false;
        this.interrupt();
        this.serverSocket.close();
    }
}
