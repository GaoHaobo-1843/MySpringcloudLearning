package com.gaohb.springcloud.streamhello.queues;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface GhbTopicIn {

    String TEST_INPUT = "ghbTestInput"; // 下面@Input绑定这个，所以@Onput绑定这个就建立起消息提供和消费的关系

    @Input(GhbTopicIn.TEST_INPUT)
    SubscribableChannel ghbTestInput();
}
