package two_phase_termination;

import java.io.*;
import java.net.Socket;

/**
 * @author javie
 * @date 2019/7/31 22:54
 */
public class ClientHandler implements Runnable {

    private final Socket socket;

    private volatile boolean running = true;

    public ClientHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try (  // try(resource){}  jdk 1.7以后新增的功能
             InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream();
             BufferedReader  bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
             PrintWriter printWriter = new PrintWriter(outputStream)
        ) {
            while (running){
                String message = bufferedReader.readLine();
                if (message==null){
                    break;
                }
                System.out.println("Come from client -> "+message);
                printWriter.write("echo "+message+"\n");
                printWriter.flush();
            }
        } catch (IOException e) {
            this.running = false;
        }finally {
            this.stop();
        }
    }

    public void stop()  {
        if (!running){
            return;
        }
        this.running = false;
        try {
            this.socket.close();
        } catch (IOException e) {
            //
        }
    }
}
