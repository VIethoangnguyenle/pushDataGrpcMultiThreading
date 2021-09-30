package com.hoang.multiThreadring.apdater;

import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.protobuf.util.JsonFormat;
import com.hoang.Example;

import java.io.IOException;

public class AnimalAdapter extends TypeAdapter<Example.Animal> {
    @Override
    public void write(JsonWriter out, Example.Animal value) throws IOException {
        out.jsonValue(JsonFormat.printer().omittingInsignificantWhitespace().print(value));
    }

    @Override
    public Example.Animal read(JsonReader in) throws IOException {
        Example.Animal.Builder builder = Example.Animal.newBuilder();
        JsonFormat.parser().merge(JsonParser.parseReader(in).toString(), builder);
        return builder.build();
    }
}
