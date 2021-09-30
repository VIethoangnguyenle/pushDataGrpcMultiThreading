package com.hoang.multiThreadring.apdater;

import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.protobuf.util.JsonFormat;
import com.hoang.Example;

import java.io.IOException;

public class StudentAdapter extends TypeAdapter<Example.Student> {
    @Override
    public void write(JsonWriter out, Example.Student value) throws IOException {
        out.jsonValue(JsonFormat.printer().omittingInsignificantWhitespace().print(value));
    }

    @Override
    public Example.Student read(JsonReader in) throws IOException {
        Example.Student.Builder builder = Example.Student.newBuilder();
        JsonFormat.parser().merge(JsonParser.parseReader(in).toString(), builder);
        return builder.build();
    }
}
