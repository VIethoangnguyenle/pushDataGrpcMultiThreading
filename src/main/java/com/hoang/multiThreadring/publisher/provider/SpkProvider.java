package com.hoang.multiThreadring.publisher.provider;

import com.hoang.Example;
import com.hoang.multiThreadring.publisher.BasePushData;
import com.hoang.multiThreadring.publisher.PushServiceProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class SpkProvider extends BasePushData {

    SecureRandom random = new SecureRandom();
    private final List<String> listStudent = Arrays.asList("Thien", "Long", "Bat", "Bo", "Thuy");
    private final List<String> listAnimal = Arrays.asList("Duck", "Bitch", "Pig", "Bird", "Bear");

    @Override
    public PushDataProvider getProvider() {
        return PushDataProvider.SPKT;
    }

    @Bean
    public void initSPK() {
        new Thread(() -> {
            try {
                while (true) {
                    if (random.nextInt(2) == 0) {
//                        log.info("dfddddd");
                        pushAnimalData(Example.Animal.newBuilder().setName(listAnimal.get(random.nextInt(5))).setAge(random.nextInt(20)).build());
                    }
                    else {
                        pushStudentData(Example.Student.newBuilder().setName(listStudent.get(random.nextInt(5))).setAge(random.nextInt(50)).build());
                    }
                    Thread.sleep(10);
                }
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }

//    @Scheduled(fixedRate = 3, initialDelayString = "#{ T(java.util.concurrent.ThreadLocalRandom).current().nextInt(60) }")
//    private void bkPushData () {
//        if (random.nextInt(2) == 0) {
//            pushStudentData(Example.Student.newBuilder().setName(listStudent.get(random.nextInt(5))).setAge(random.nextInt(30)).build());
//        }
//        else {
//            pushAnimalData(Example.Animal.newBuilder().setName(listAnimal.get(random.nextInt(5))).setAge(random.nextInt(10)).build());
//        }
//    }
}
