package chat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author javie
 * @date 2019/9/4 14:23
 */
public class ChatClientHandler extends SimpleChannelInboundHandler<String>{

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("注册");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println("------["+channel.localAddress().toString().substring(1)
                +"] 成功连接服务器：["+channel.remoteAddress().toString()+"]------");
        System.out.println("请开始对话：");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        System.out.print(s);
    }
}
