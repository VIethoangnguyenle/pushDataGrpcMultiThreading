package com.hoang.multiThreadring.publisher.provider;

import com.hoang.Example;
import com.hoang.multiThreadring.publisher.BasePushData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;

@Service
@EnableScheduling
@Slf4j
public class BkProvider extends BasePushData{

    private final SecureRandom random = new SecureRandom();
    private final List<String> listStudent = Arrays.asList("Hoang", "Thuan", "Mai", "Yen", "Lam");
    private final List<String> listAnimal = Arrays.asList("Dog", "Cat", "Ant", "Cow", "Chicken");

    @Scheduled(fixedRate = 3, initialDelayString = "#{ T(java.util.concurrent.ThreadLocalRandom).current().nextInt(60) }")
    private void bkPushData () {
        if (random.nextInt(2) == 0) {
            pushStudentData(Example.Student.newBuilder().setName(listStudent.get(random.nextInt(5))).setAge(random.nextInt(30)).build());
        }
        else {
            pushAnimalData(Example.Animal.newBuilder().setName(listAnimal.get(random.nextInt(5))).setAge(random.nextInt(10)).build());
        }
    }

    @Override
    public PushDataProvider getProvider() {
        return PushDataProvider.BK;
    }
}
