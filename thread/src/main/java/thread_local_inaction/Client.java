package thread_local_inaction;

import java.util.stream.IntStream;

/**
 * @author javie
 * @date 2019/7/31 15:28
 */
public class Client {

    public static void main(String[] args) {
        IntStream.range(1, 5).forEach(i->
            new Thread(new ExecutionTask()).start()
        );
    }
}
