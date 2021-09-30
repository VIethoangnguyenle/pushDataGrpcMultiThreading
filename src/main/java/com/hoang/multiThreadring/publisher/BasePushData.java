package com.hoang.multiThreadring.publisher;

import com.hoang.Example;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public abstract class BasePushData implements PushServiceProvider{

    @Autowired
    PushGateway pushGateway;

    protected void pushStudentData(Example.Student student) {
        pushGateway.pushStudentData(getProvider(), student);
    }

    protected void pushAnimalData(Example.Animal animal) {
        pushGateway.pushAnimalData(getProvider(), animal);
    }
}
