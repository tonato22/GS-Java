package br.com.workconnect;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class WorkConnectApplication {
    public static void main(String[] args) {
        SpringApplication.run(WorkConnectApplication.class, args);
    }
}
