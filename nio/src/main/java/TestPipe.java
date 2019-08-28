import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * @author javie
 * @date 2019/8/27 12:41
 */
public class TestPipe {

    public static void main(String[] args) throws IOException {
        // 1.获取管道
        Pipe pipe = Pipe.open();

        // 2.将缓冲区中的数据写入管道
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        Pipe.SinkChannel sinkChannel = pipe.sink();
        buffer.put("hello world".getBytes());
        buffer.flip();
        sinkChannel.write(buffer);
        buffer.clear();

        // 3.读取缓冲区的数据
        Pipe.SourceChannel sourceChannel = pipe.source();
        sourceChannel.read(buffer);
        System.out.println(new String(buffer.array(),0,buffer.limit()));

        sinkChannel.close();
        sourceChannel.close();
    }
}
