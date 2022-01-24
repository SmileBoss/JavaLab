package ru.itis.apigeneratorjavalabcom.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static ru.itis.apigeneratorjavalabcom.utils.RabbitQueue.REPLY_QUEUE_NAME;
import static ru.itis.apigeneratorjavalabcom.utils.RabbitQueue.STATEMENTS_TOPIC;

@Configuration
public class RabbitConfig {

    @Value("${rabbit.connection.port}")
    private int port;

    @Value("${rabbit.connection.host}")
    private String host;

    public static final String TOPIC_EXCHANGE_NAME = "pdf-exchange";

    @Bean
    public ConnectionFactory connectionFactory() {
        return new CachingConnectionFactory(host, port);
    }

    @Bean
    public Queue statementQueue() {
        return new Queue(STATEMENTS_TOPIC.getTopic(), false);
    }

    @Bean
    public Queue replyQueue() {
        return new Queue(REPLY_QUEUE_NAME.getTopic(), false);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(TOPIC_EXCHANGE_NAME);
    }

    @Bean
    public Binding grantBinding(Queue statementQueue, TopicExchange exchange) {
        return BindingBuilder.bind(statementQueue()).to(exchange).with(statementQueue().getName());
    }

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
