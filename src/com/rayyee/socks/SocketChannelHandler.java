package com.rayyee.socks;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.socks.SocksRequest;

/**
 * Created by Ray Yee on 2014/5/28.
 * All rights reserved.
 */
public class SocketChannelHandler extends SimpleChannelInboundHandler<SocksRequest>
{
    public String name = "com.rayyee.socks.SocketChannelHandler";

    @Override
    protected void messageReceived( ChannelHandlerContext ctx, SocksRequest msg ) throws Exception
    {

    }
}
