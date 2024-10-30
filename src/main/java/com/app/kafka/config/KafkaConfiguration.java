package com.app.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.LoggingProducerListener;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.kafka.support.converter.RecordMessageConverter;

@Configuration
@EnableConfigurationProperties(KafkaProperties.class)
public class KafkaConfiguration {
    private final KafkaProperties kafkaProperties;
    private final RecordMessageConverter messageConverter;

    public KafkaConfiguration(KafkaProperties kafkaProperties,
                              ObjectProvider<RecordMessageConverter> messageConverters) {
        this.kafkaProperties = kafkaProperties;
        this.messageConverter = messageConverters.getIfAvailable();
    }

    @Bean
    public KafkaTemplate<?, ?> testKafkaTemplate(
            ProducerFactory<Object, Object> testProducerFactory,
            ProducerListener<Object, Object> testProducerListener) {
        KafkaTemplate<Object, Object> kafkaTemplate = new KafkaTemplate<>(testProducerFactory);
        if (this.messageConverter != null) {
            kafkaTemplate.setMessageConverter(this.messageConverter);
        }
        kafkaTemplate.setProducerListener(testProducerListener);
        kafkaTemplate.setDefaultTopic(this.kafkaProperties.getTemplate().getDefaultTopic());
        return kafkaTemplate;
    }

    @Bean
    @ConditionalOnMissingBean(ProducerListener.class)
    public ProducerListener<Object, Object> testProducerListener() {
        return new LoggingProducerListener<>();
    }

    @Bean
    @ConditionalOnMissingBean(ProducerFactory.class)
    public ProducerFactory<?, ?> testProducerFactory() {
        DefaultKafkaProducerFactory<?, ?> factory =
                new DefaultKafkaProducerFactory<>(this.kafkaProperties.buildProducerProperties());
        String prefix = this.kafkaProperties.getProducer().getTransactionIdPrefix();
        if (prefix != null) {
            factory.setTransactionIdPrefix(prefix);
        }
        return factory;
    }

}
