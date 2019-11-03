package com.conichi.technicaltest;

import com.conichi.technicaltest.dao.Dao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//u.chavushoglu


@SpringBootApplication
public class TechnicalTestApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(TechnicalTestApplication.class, args)
               .getBean(Dao.class).fillTableWithData();
    }

}
