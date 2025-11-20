package br.com.workconnect.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NAME = "tipsQueue";
    public static final String EXCHANGE_NAME = "tipsExchange";
    public static final String ROUTING_KEY = "tips.routingKey";

    @Bean
    public Queue tipsQueue() {
        return new Queue(QUEUE_NAME, true);
    }

    @Bean
    public DirectExchange tipsExchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding bindingTipsQueue() {
        return BindingBuilder
                .bind(tipsQueue())
                .to(tipsExchange())
                .with(ROUTING_KEY);
    }
}
