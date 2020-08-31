package com.org.exmpale.containers;

import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.MountableFile;

public class IgniteTestContainer extends GenericContainer<IgniteTestContainer> {
    private static volatile IgniteTestContainer INSTANCE;

    public static synchronized IgniteTestContainer getInstance() {
        if (INSTANCE == null) {
            return new IgniteTestContainer();
        }
        return INSTANCE;
    }

    IgniteTestContainer() {
        super("apacheignite/ignite:2.8.1");
        //TODO: don't miss to setup client xml setting
        addLibs();
        this.start();
    }


    private void addLibs() {
        final String libsPath = "/opt/ignite/apache-ignite/libs/";
        this.withCopyFileToContainer(MountableFile.forClasspathResource("ignite-libs/HikariCP-3.4.5.jar"), libsPath);
        this.withCopyFileToContainer(MountableFile.forClasspathResource("ignite-libs/log4j-1.2.17.jar"), libsPath);
        this.withCopyFileToContainer(MountableFile.forClasspathResource("ignite-libs/slf4j-api-1.7.7.jar"), libsPath);
        this.withCopyFileToContainer(MountableFile.forClasspathResource("ignite-libs/slf4j-log4j12-1.7.7.jar"), libsPath);
        this.withCopyFileToContainer(MountableFile.forClasspathResource("ignite-libs/postgresql-42.2.12.jar"), libsPath);
        this.withCopyFileToContainer(MountableFile.forClasspathResource("ignite-libs/control-center-agent-2.8.1.1.jar"), libsPath);
        this.withCopyFileToContainer(MountableFile.forClasspathResource("ignite-libs/spring-messaging-5.2.7.RELEASE.jar"), libsPath);
        this.withCopyFileToContainer(MountableFile.forClasspathResource("ignite-libs/javax.websocket-api-1.1.jar"), libsPath);
        this.withCopyFileToContainer(MountableFile.forClasspathResource("ignite-libs/spring-websocket-5.2.8.RELEASE.jar"), libsPath);
        this.withCopyFileToContainer(MountableFile.forClasspathResource("ignite-libs/jackson-core-2.11.0.jar"), libsPath);
        this.withCopyFileToContainer(MountableFile.forClasspathResource("ignite-libs/jackson-databind-2.11.1.jar"), libsPath);
        this.withCopyFileToContainer(MountableFile.forClasspathResource("ignite-libs/jackson-dataformat-smile-2.11.1.jar"), libsPath);
        this.withCopyFileToContainer(MountableFile.forClasspathResource("ignite-libs/jackson-annotations-2.11.1.jar"), libsPath);
    }
}
