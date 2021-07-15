package com.gaohb.springcloud.streamhello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@EnableBinding(value = {SinkApplicationTests.GhbTopicOut.class})
public class SinkApplicationTests {

    @Autowired
    private GhbTopicOut ghbOutChannel;

    @Test
    public void sinkSenderTester() {
        ghbOutChannel.ghbTest().send(MessageBuilder.withPayload("produce a message ：http://www.baidu.com").build());
    }

    public interface GhbTopicOut {

        String GHB_TOPIC = "ghb-topic"; // 通过这个值跟INPUT建立联系

        @Output(GhbTopicOut.GHB_TOPIC)
        MessageChannel ghbTest();

    }
}
