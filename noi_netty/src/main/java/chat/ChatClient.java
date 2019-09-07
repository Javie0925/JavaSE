package chat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;

/**
 * @author javie
 * @date 2019/9/4 14:22
 */
public class ChatClient {

    private String host;
    private int port;

    public ChatClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start(){
        // 1.创建一个线程组
        NioEventLoopGroup group = new NioEventLoopGroup();
        // 2.创建客户端的启动助手，完成相关的配置
        try {
            Bootstrap bootstrap = new Bootstrap();
            // 3.配置线程组
            bootstrap
                    .group(group)
                    .channel(NioSocketChannel.class) // 4.设置客户端通道的实现类
                    .handler(new ChannelInitializer<SocketChannel>() { //5.创建一个通道初始化对象
                        @Override
                        protected void initChannel(SocketChannel sc) throws Exception {
                            // 6.往pipeline链中添加自定义handler
                            ChannelPipeline pipeline = sc.pipeline();
                            // 添加编码器
                            pipeline.addLast("decoder",new StringDecoder());
                            // 添加解码器
                            pipeline.addLast("encoder",new StringEncoder());
                            // 添加自定义handler位置在编/解码器之后
                            pipeline.addLast(new ChatClientHandler());

                        }
                    });
            // 至此客户端配置完成
            // 7.启动客户端去连接服务端(异步非阻塞),connect()是异步的，sync()是同步阻塞的
            ChannelFuture channelFuture = bootstrap.connect(host,port).sync();
            // 获取通道
            Channel channel = channelFuture.channel();
            // 打印信息

            Scanner scanner = new Scanner(System.in);
            while(scanner.hasNext()){
                String msg = scanner.nextLine();
                if("bye".equalsIgnoreCase(msg))
                    break;
                channel.writeAndFlush(msg);
            }
            // 8. 关闭连接(异步非阻塞)
            channelFuture.channel().closeFuture().sync();

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        new ChatClient("localhost",8080).start();
    }
}
