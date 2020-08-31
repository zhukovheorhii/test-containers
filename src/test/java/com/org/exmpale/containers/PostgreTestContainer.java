package com.org.exmpale.containers;

import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
public class PostgreTestContainer extends PostgreSQLContainer<PostgreTestContainer> {

    private static volatile PostgreTestContainer INSTANCE;

    public static synchronized PostgreTestContainer getInstance() {
        if (INSTANCE == null) {
            return new PostgreTestContainer();
        }
        return INSTANCE;
    }

    private PostgreTestContainer() {
        super("postgres:12.2");
        this.withDatabaseName("rater");
        this.withUsername("mcadmin");
        this.withPassword("mcadmin");
        this.addFixedExposedPort(50035, 5432);
        this.start();
    }
}
