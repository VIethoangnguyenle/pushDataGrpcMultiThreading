package com.hoang.multiThreadring.publisher;

import com.google.protobuf.Empty;
import com.hoang.Example;
import com.hoang.PushDataGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PushDataService {
    PushDataGrpc.PushDataStub asyncStub;
    ManagedChannel channel;
    StreamObserver<Example.IndexAnimal> indexAnimalStreamObserver;
    StreamObserver<Example.IndexStudent> indexStudentStreamObserver;

    @Value("${grpc.host}")
    String host;

    @Value("${grpc.port}")
    Integer port;

    public void pushStudent(Example.IndexStudent indexStudent) {
//        log.info("send student {}" , indexStudent);
        getIndexStudentStreamObserver().onNext(indexStudent);
    }

    public void pushAnimal(Example.IndexAnimal indexAnimal) {
//        log.info("send animal {}", indexAnimal);
        getIndexAnimalStreamObserver().onNext(indexAnimal);
    }

    public PushDataGrpc.PushDataStub getAsyncStub() {
        if (asyncStub == null) {
            asyncStub = PushDataGrpc.newStub(createChanel());
        }
        return asyncStub;
    }

    private ManagedChannel createChanel() {
        if (channel == null || channel.isShutdown()) {
            channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().keepAliveWithoutCalls(true).build();
        }
        return channel;
    }

    private StreamObserver<Example.IndexStudent> getIndexStudentStreamObserver() {
        if (indexStudentStreamObserver == null) {
            indexStudentStreamObserver = getAsyncStub().withWaitForReady().pushStudent(new StreamObserver<Empty>() {
                @Override
                public void onNext(Empty value) {

                }

                @Override
                public void onError(Throwable t) {

                }

                @Override
                public void onCompleted() {

                }
            });
        }
        return indexStudentStreamObserver;
    }

    private StreamObserver<Example.IndexAnimal> getIndexAnimalStreamObserver() {
        if (indexAnimalStreamObserver == null) {
            indexAnimalStreamObserver = getAsyncStub().withWaitForReady().pushAnimal(new StreamObserver<Empty>() {
                @Override
                public void onNext(Empty value) {

                }

                @Override
                public void onError(Throwable t) {

                }

                @Override
                public void onCompleted() {

                }
            });
        };
        return indexAnimalStreamObserver;
    }
}
