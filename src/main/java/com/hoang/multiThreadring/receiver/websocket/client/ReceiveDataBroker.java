package com.hoang.multiThreadring.receiver.websocket.client;

public interface ReceiveDataBroker {
    void onStudentMessage(String data);
    void onAnimalMessage(String data);
}
