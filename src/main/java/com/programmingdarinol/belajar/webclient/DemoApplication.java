package com.programmingdarinol.belajar.webclient;

import com.programmingdarinol.belajar.webclient.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

  @Autowired
  UniversityService universityService;

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Bean
  ApplicationRunner applicationRunner(){
    return args -> {
      universityService.findByCountryName("Indonesia");
      universityService.getByCountryName("Indonesia");
    };
  }
}
