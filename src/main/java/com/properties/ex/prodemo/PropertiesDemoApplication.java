package com.properties.ex.prodemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;

import com.properties.ex.prodemo.utils.PropertiesUtils;


@SpringBootApplication
public class PropertiesDemoApplication {

    @Value("${file.upload.size.limit}")
    private long size;

    @Value("${remote.connection.url}")
    private String rmConUrl;

    @Value("${remote.connection.port}")
    private int rmConPort;

    @Value("${remote.connection.username}")
    private String rmConUser;

    @Value("${remote.connection.password}")
    private String rmConPwd;

    @Value("${remote.https.enabled}")
    private String rmHttpEnb;

    @Value("${env.name}")
    private String envName;

    @Value("${remote.connection.auth}")
    private String rmConAuth;

    public static void main(String[] args) {
        PropertiesUtils.initProperties();
        ConfigurableApplicationContext context = SpringApplication.run(PropertiesDemoApplication.class, args);
        PropertiesDemoApplication mainApplication = context.getBean(PropertiesDemoApplication.class);
        printEnvironmentsProperties(mainApplication);
    }

    private static void printEnvironmentsProperties(PropertiesDemoApplication MainApplication) {
        StringBuilder stringBuilder = new StringBuilder("================ Files ===========\n");

        stringBuilder.append("env.name").append(" : ").append(MainApplication.envName).append("\n")
                .append("file.upload.size.limit").append(" : ").append(MainApplication.size).append("\n")
                .append("remote.connection.url").append(" : ").append(MainApplication.rmConUrl).append("\n")
                .append("remote.connection.port").append(" : ").append(MainApplication.rmConPort).append("\n")
                .append("remote.connection.username").append(" : ").append(MainApplication.size).append("\n")
                .append("remote.connection.password").append(" : ").append(MainApplication.rmConPwd).append("\n")
                .append("remote.connection.auth").append(" : ").append(MainApplication.rmConAuth).append("\n")
                .append("remote.https.enabled").append(" : ").append(MainApplication.rmHttpEnb).append("\n");
        System.out.println(stringBuilder.toString());
    }
}

