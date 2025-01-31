package com.echo.catchtable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CatchTableApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatchTableApplication.class, args);
    }

}
