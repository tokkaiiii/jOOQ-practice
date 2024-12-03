package com.example.jooqtest.config

import org.springframework.boot.autoconfigure.jooq.DefaultConfigurationCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class JooqConfig {

    @Bean
    fun jooqDefaultConfigurationCustomizer(): DefaultConfigurationCustomizer =
        DefaultConfigurationCustomizer { customizer -> customizer.settings().withRenderSchema(false)}

}