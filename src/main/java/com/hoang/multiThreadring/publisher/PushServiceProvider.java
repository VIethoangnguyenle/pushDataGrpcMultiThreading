package com.hoang.multiThreadring.publisher;

import com.hoang.multiThreadring.publisher.provider.PushDataProvider;

public interface PushServiceProvider {
    PushDataProvider getProvider();
}
