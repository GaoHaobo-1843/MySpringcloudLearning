package com.gaohb.springcloud.streamhello.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class) // 用来指定一个或多个定义了@Input或@Output注解的接口，以此实现对消息通道（Channel）的绑定
public class SinkReceiver {

    private static Logger logger = LoggerFactory.getLogger(SinkReceiver.class);

    @StreamListener(Sink.INPUT) // 被修饰的方法注册为消息中间件上数据流的事件监听器，注解中的属性值对应了监听的消息通道名
    public void receive(Object payload) {
        logger.info("Received: " + payload); // 没有序列化，只输出对象的引用
    }
}
