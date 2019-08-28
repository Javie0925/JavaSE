import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author javie
 * @date 2019/8/27 1:16
 */
public class TestBlockingNIO {

    @Test
    public void client() throws Exception {

        // 1.获取通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9999));

        // 2.分配制定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // 3.读取本地文件并发送到服务端
        String path = "D:\\JetBrains\\IdeaProjects\\javase\\nio\\src\\main\\resources\\axiuluo.jpg";
        FileChannel inChannel = FileChannel.open(Paths.get(path), StandardOpenOption.READ);
        while (inChannel.read(buffer)!=-1){
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
        }
        // 4.关闭通道
        inChannel.close();
        socketChannel.close();
    }

    @Test
    public void server() throws Exception {

        // 1.获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        // 2.绑定端口号
        serverSocketChannel.bind(new InetSocketAddress(9999));

        // 3.获取客户端连接的通道
        SocketChannel accept = serverSocketChannel.accept();

        // 4.接收客户端的数据保存到本地
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        String dstPath = "D:\\JetBrains\\IdeaProjects\\javase\\nio\\src\\main\\resources\\axiuluo2.jpg";
        FileChannel outChannel = FileChannel.open(Paths.get(dstPath), StandardOpenOption.WRITE, StandardOpenOption.CREATE_NEW);
        while (accept.read(buffer)!=-1){
            buffer.flip();
            outChannel.write(buffer);
            buffer.clear();
        }
        outChannel.close();
        accept.close();
        serverSocketChannel.close();

    }
}
