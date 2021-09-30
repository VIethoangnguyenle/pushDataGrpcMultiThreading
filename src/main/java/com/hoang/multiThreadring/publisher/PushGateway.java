package com.hoang.multiThreadring.publisher;

import com.hoang.Example;
import com.hoang.multiThreadring.publisher.provider.PushDataProvider;

public interface PushGateway {
    void pushStudentData(PushDataProvider provider, Example.Student indexStudent);
    void pushAnimalData(PushDataProvider provider, Example.Animal indexAnimal);
}
