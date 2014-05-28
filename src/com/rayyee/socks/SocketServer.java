package com.rayyee.socks;

import com.rayyee.Log;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;


/**
 * Created by Ray Yee on 2014/5/28.
 * All rights reserved.
 */
final public class SocketServer
{
    final private int _prot;

    public SocketServer( int prot )
    {
        _prot = prot;
    }

    public void run() throws Exception
    {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try
        {
            ServerBootstrap b = new ServerBootstrap();
            b.group( bossGroup, workerGroup )
                    .channel( NioServerSocketChannel.class )
                    .childHandler( new SocketServerInitializer() );
            b.bind( _prot ).sync().channel().closeFuture().sync();
        } finally
        {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}

final class SocketServerInitializer extends ChannelInitializer<SocketChannel>
{
    private final SocketChannelHandler handler = new SocketChannelHandler();

    @Override
    protected void initChannel( SocketChannel ch ) throws Exception
    {
        Log.Info( "init channel." );
        ChannelPipeline cp = ch.pipeline();
        cp.addLast( handler.name, handler );
    }
}
