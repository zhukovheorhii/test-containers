package com.org.exmpale.containers;

import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.File;

@Testcontainers
public class KafkaTestContainer extends DockerComposeContainer<KafkaTestContainer> {

    private static volatile KafkaTestContainer INSTANCE;

    public static synchronized KafkaTestContainer getInstance() {
        if (INSTANCE == null) {
            return new KafkaTestContainer();
        }
        return INSTANCE;
    }

    //Start kafka using DOCKER-COMPOSE file
    private KafkaTestContainer() {
        super(new File("./src/test/resources/kafka-docker-compose.yml"));
        this.start();
    }
}
