package chat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @author javie
 * @date 2019/9/4 14:22
 */
public class ChatServer {

    private int port;

    public ChatServer(int port) {
        this.port = port;
    }

    public void start(){
        // 1.创建一个线程组接收客户端连接
        NioEventLoopGroup boss = new NioEventLoopGroup();
        // 2.创建一个线程组处理网络连接
        NioEventLoopGroup worker = new NioEventLoopGroup();

        try{
            // 3.创建启动助手
            ServerBootstrap bootstrap = new ServerBootstrap();

            bootstrap.group(boss,worker)    // 4.配置线程组
                    .channel(NioServerSocketChannel.class)  // 5. 使用NioServerSocketChannel作为服务端通道的实现
                    .option(ChannelOption.SO_BACKLOG, 128)  // 6.设置线程队列中等待连接的个数
                    .childOption(ChannelOption.SO_KEEPALIVE,true )  // 7.保持连接活动状态
                    .childHandler(new ChannelInitializer<SocketChannel>() { // 8.创建一个通道初始化对象
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            // 9.往通道中添加自定义handler
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            // 添加编码器
                            pipeline.addLast("encode", new StringEncoder());
                            // 添加解码器
                            pipeline.addLast("decoder",new StringDecoder());
                            // 添加自定义handler
                            pipeline.addLast(new ChatServerHandler());
                        }
                    }); //配置完毕
            // 10.启动服务器
            ChannelFuture future = bootstrap.bind(port).sync();
            System.out.println("------------server started-------------");
            // 11.关闭通道
            future.channel().closeFuture().sync();

        }catch (Exception e){

        }finally {
            // 12.关闭线程组
            if (boss!=null)
                boss.shutdownGracefully();
            if (worker!=null)
                worker.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        new ChatServer(8080).start();
    }
}
