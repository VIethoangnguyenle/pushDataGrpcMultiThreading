package com.hoang.multiThreadring.receiver;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.protobuf.Empty;
import com.hoang.Example;
import com.hoang.PushDataGrpc;
import com.hoang.multiThreadring.receiver.websocket.client.ReceiveDataService;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GRpcService
@Slf4j
public class PushDataServerImpl extends PushDataGrpc.PushDataImplBase {

    @Autowired
    ReceiveDataService receiveDataService;

    private final Gson gson = new GsonBuilder().create();

    @Override
    public StreamObserver<Example.IndexStudent> pushStudent(StreamObserver<Empty> responseObserver) {
        return new StreamObserver<Example.IndexStudent>() {
            @Override
            public void onNext(Example.IndexStudent value) {
                value.getStudentList().forEach(item -> {
//                    log.info("receive {}", item);
                    receiveDataService.onStudentMessage(MessageParser.getGson().toJson(item));
                });
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
                log.info("Completed");
            }
        };
    }

    @Override
    public StreamObserver<Example.IndexAnimal> pushAnimal(StreamObserver<Empty> responseObserver) {
        return new StreamObserver<Example.IndexAnimal>() {
            @Override
            public void onNext(Example.IndexAnimal value) {
                value.getAnimalList().forEach(item -> {
                    receiveDataService.onAnimalMessage(MessageParser.getGson().toJson(item));
                });
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {

            }
        };
    }
}
