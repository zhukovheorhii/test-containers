package com.org.exmpale;

import com.org.exmpale.containers.PostgreTestContainer;
import org.junit.jupiter.api.Test;
import spock.lang.Shared;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BaseTest {

    @Shared//used to do not terminate container from test to test
    final private PostgreTestContainer postgre = PostgreTestContainer.getInstance();

//    @Shared
//    private IgniteTestContainer ignite = IgniteTestContainer.getInstance();
//
//    @Shared
//    final private KafkaTestContainer kafka = KafkaTestContainer.getInstance();


    @Test
    void simpleTest() {
        assertTrue(postgre.isRunning(), "PostgreTestContainer is not started!");
    }
}
