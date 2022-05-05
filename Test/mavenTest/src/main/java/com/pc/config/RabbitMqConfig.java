package com.pc.config;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author foreverqisui
 */
@Configuration
public class RabbitMqConfig {
    @Bean
    public Queue queue(){
        return new Queue("queue",true);
    }
}
