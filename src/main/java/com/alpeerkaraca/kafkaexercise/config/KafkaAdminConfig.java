package com.alpeerkaraca.kafkaexercise.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaAdminConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    // Diğer config sınıflarındaki gibi aynı "ham" (raw) ayarları okuyoruz
    @Value("${spring.kafka.properties.security.protocol}")
    private String securityProtocol;

    @Value("${spring.kafka.ssl.trust-store-location}")
    private String certPath; // Buraya 'C:/kafka_ssl/kafka.truststore.jks' gelecek

    @Value("${spring.kafka.ssl.trust-store-password}")
    private String certPass;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);

        // SSL Ayarları
        configs.put("security.protocol", securityProtocol);
        configs.put("ssl.truststore.location", certPath);
        configs.put("ssl.truststore.password", certPass);

        return new KafkaAdmin(configs);
    }
}