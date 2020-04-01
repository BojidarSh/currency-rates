package com.project.currencyrates.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Application configuration. Helps autowiring the services into test files.
 */
@Configuration
@ComponentScan("com.project.currencyrates.service")
public class AppConfig {
}