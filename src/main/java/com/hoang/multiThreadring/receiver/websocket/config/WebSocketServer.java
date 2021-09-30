package com.hoang.multiThreadring.receiver.websocket.config;

import io.netty.channel.group.ChannelGroup;

import java.util.List;
import java.util.Map;

public interface WebSocketServer {
    void broadcast(String data);
    ChannelGroup getChannelGroup();
    Map<String, ChannelGroup> getChannelGroupMap();
}
