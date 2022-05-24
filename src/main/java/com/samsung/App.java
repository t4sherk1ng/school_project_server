package com.samsung;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.SQLException;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);

        try {
            //Консоль для визуализации бд в браузере
            Console.main(args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
