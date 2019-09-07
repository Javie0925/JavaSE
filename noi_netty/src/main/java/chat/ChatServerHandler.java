package chat;

import io.netty.channel.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author javie
 * @date 2019/9/4 14:23
 */
public class ChatServerHandler extends SimpleChannelInboundHandler {

    public static List<Channel> channels = new ArrayList<>();


    /**
     * 通道就绪
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // 获取当前通道
        Channel inChannel = ctx.channel();
        // 加入通道列表
        channels.add(inChannel);
        System.out.println("[Server]: "+inChannel.remoteAddress().toString().substring(1)+" 上线了");
    }

    /**
     * 通道未就绪,通道关闭
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        // 获取当前通道
        Channel inChannel = ctx.channel();
        // 从列表中移除通道
        channels.remove(inChannel);
        System.out.println("[Server]: "+inChannel.remoteAddress().toString().substring(1)+" 下线了");
    }


    /**
     * 读取数据
     * @param context
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext context, Object msg) throws Exception {
        // 获取当前通道
        Channel channel = context.channel();
        // 广播信息
        System.out.println("["+channel.remoteAddress().toString().substring(1)+"]: " +msg+"\r\n");
        channels.forEach(c->{
            c.writeAndFlush("["+channel.remoteAddress().toString().substring(1)+"]: " +msg+"\r\n");
        });
    }
}

