package com.hoang.multiThreadring.receiver.websocket.config;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class NettyWebSocketServer implements WebSocketServer {

    ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    Map<String, ChannelGroup> channelGroupMap = new HashMap<>();

    @Autowired
    WebSocketServerHandler webSocketServerHandler;

    @Value("${grpc.socket.port}")
    Integer port;

    @Bean
    public void init() {
        EventLoopGroup mainGroup = new NioEventLoopGroup();
        EventLoopGroup subGroup = new NioEventLoopGroup();

        new Thread(() -> {
            try {
                ServerBootstrap server = new ServerBootstrap();
                server.group(mainGroup, subGroup)
                        .channel(NioServerSocketChannel.class)
                        .childHandler(new ChannelInitializer<SocketChannel>() {
                            @Override
                            protected void initChannel(SocketChannel ch) throws Exception {
                                ChannelPipeline pipeline = ch.pipeline();
                                pipeline.addLast(new HttpServerCodec())
                                        .addLast(new ChunkedWriteHandler())
                                        .addLast(new HttpObjectAggregator(1024 * 64))
                                        .addLast(new WebSocketServerProtocolHandler("/test"))
                                        .addLast(webSocketServerHandler);
                            }
                        });
                ChannelFuture future = server.bind(port).sync();
                future.channel().closeFuture().sync();
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                mainGroup.shutdownGracefully();
                subGroup.shutdownGracefully();
            }
        }).start();
    }
    @Override
    public void broadcast(String data) {
//        System.out.println(data);
        channelGroup.writeAndFlush(new TextWebSocketFrame(data));
    }

    @Override
    public ChannelGroup getChannelGroup() {
        return channelGroup;
    }

    @Override
    public Map<String, ChannelGroup> getChannelGroupMap() {
        return channelGroupMap;
    }
}
