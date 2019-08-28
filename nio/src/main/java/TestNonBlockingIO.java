import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Date;
import java.util.Iterator;

/**
 * @author javie
 * @date 2019/8/27 11:01
 */
public class TestNonBlockingIO {

    /**
     * 客户端
     */
    @Test
    public void client() throws Exception {
        // 获取通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9999));
        // 切换成非阻塞模式
        socketChannel.configureBlocking(false);
        // 分配缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // 发送数据
        buffer.put(new Date().toString().getBytes());
        buffer.flip();
        socketChannel.write(buffer);
        socketChannel.close();

    }

    /**
     * 服务端
     */
    @Test
    public void server() throws IOException {
        // 1.获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 2.切换非阻塞式
        serverSocketChannel.configureBlocking(false);
        // 3.绑定端口
        serverSocketChannel.bind(new InetSocketAddress(9999));
        // 4.获取选择器
        Selector selector = Selector.open();
        // 5.将通道注册到选择器上,并且指定监听事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        // 6.轮询式的获取选择器上已经准备就绪的事件
        while (selector.select() > 0 ){
            // 7. 获取当前选择器中所有注册的选择键（已经就绪的监听事件）
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            // 迭代获取
            while (iterator.hasNext()){
                // 8.获取准备就绪的事件
                SelectionKey next = iterator.next();
                // 9.判断具体是什么事件准备就绪
                if (next.isAcceptable()){
                    // 10.若准备就绪，获取客户端连接
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    // 11.切换非阻塞模式
                    socketChannel.configureBlocking(false);
                    //  12.将该通道注册到选择器
                    socketChannel.register(selector, SelectionKey.OP_READ);
                }else if (next.isReadable()){ // 读就绪
                    // 13.获取当前选择器上读就绪状态
                    SocketChannel channel = (SocketChannel) next.channel();
                    // 14.读取数据
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int len = 0;
                    while ((len = channel.read(buffer))>0){
                        buffer.flip();
                        System.out.println(new String(buffer.array(),0,len));
                        buffer.clear();
                    }

                }
                // 15.取消选择键
                iterator.remove();

            }

        }
    }
}
