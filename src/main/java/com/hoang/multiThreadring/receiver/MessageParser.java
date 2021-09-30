package com.hoang.multiThreadring.receiver;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hoang.Example;
import com.hoang.multiThreadring.apdater.AnimalAdapter;
import com.hoang.multiThreadring.apdater.StudentAdapter;

public class MessageParser {
    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(Example.Student.class, new StudentAdapter())
            .registerTypeAdapter(Example.Animal.class, new AnimalAdapter())
            .create();

    public static Gson getGson() {
        return gson;
    }
}
