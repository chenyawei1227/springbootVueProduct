package com.example.springbootvueproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class SpringbootVueProductApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringbootVueProductApplication.class, args);
  }

}
