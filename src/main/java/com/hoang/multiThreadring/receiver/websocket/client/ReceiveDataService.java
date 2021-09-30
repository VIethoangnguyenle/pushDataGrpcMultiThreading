package com.hoang.multiThreadring.receiver.websocket.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hoang.multiThreadring.receiver.websocket.config.NettyWebSocketServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Service
@Slf4j
public class ReceiveDataService implements ReceiveDataBroker{

    private final BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();

    @Autowired
    NettyWebSocketServer nettyWebSocketServer;

    @Bean
    public void initReceiveData() {
        new Thread(() -> {
            try {
                while (true) {
                    String data = blockingQueue.take();
                    nettyWebSocketServer.broadcast(data);
                }
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }
    @Override
    public void onStudentMessage(String data) {
        blockingQueue.add(data);
    }

    @Override
    public void onAnimalMessage(String data) {
        blockingQueue.add(data);
    }
}
