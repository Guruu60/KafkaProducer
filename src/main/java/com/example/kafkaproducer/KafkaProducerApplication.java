package com.example.kafkaproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaProducerApplication implements CommandLineRunner {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApplication.class, args);
    }

    // The CommandLineRunner interface in Spring Boot provides a way to run
    // specific code when the application context is fully initialized.
    // In this case, the 'run' method is overridden to send messages to Kafka
    // after the application starts.

    public void run(String... args) throws InterruptedException {
        String topic = "topic1";

        for (int i =50; i<=51; i++){
            String message = "Message"+i;
            kafkaTemplate.send(topic, message);
            Thread.sleep(5000);
            System.out.println("Message send: "+message);
        }
    }

}
