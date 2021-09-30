package com.hoang.multiThreadring.publisher;

import com.hoang.Example;
import com.hoang.multiThreadring.publisher.provider.PushDataProvider;
import com.hoang.multiThreadring.publisher.repository.SourceConfigRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PushGatewayImpl implements PushGateway{

    @Value("${source.config}")
    private String config;

    @Autowired
    PushDataService pushDataService;

    @Override
    public void pushStudentData(PushDataProvider provider, Example.Student student) {
        if (isAllow(provider)) {
            pushDataService.pushStudent(Example.IndexStudent.newBuilder().addStudent(student).build());
        }
    }

    @Override
    public void pushAnimalData(PushDataProvider provider, Example.Animal animal) {
        if (isAllow(provider)) {
            pushDataService.pushAnimal(Example.IndexAnimal.newBuilder().addAnimal(animal).build());
        }
    }

    boolean isAllow(PushDataProvider provider) {
        return provider.toString().equals(config);
    }
}
