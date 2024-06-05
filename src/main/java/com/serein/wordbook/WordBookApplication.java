package com.serein.wordbook;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.serein.wordbook.mapper")
public class WordBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(WordBookApplication.class, args);
    }

}
