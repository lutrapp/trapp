package com.vc.trapp.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    @Bean
    public Queue orderPlaced() {
        return new Queue("order-placed-queue");
    }

    @Bean
    public Queue awaitingPayment() {
        return new Queue("awaiting-payment-queue");
    }
}
