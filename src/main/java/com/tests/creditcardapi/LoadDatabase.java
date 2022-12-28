package com.tests.creditcardapi;


import com.tests.creditcardapi.CreditAccountRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bhaskar
 */
public class LoadDatabase {
    
  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
    CommandLineRunner initDatabase(CreditAccountRepo repository) {
    return args -> {
      log.info("Preloading " + repository.save(new CreditAccount("Naga","34", 199)));
      log.info("Preloading " + repository.save(new CreditAccount("Bandaru", "42", 100)));
    };
  }
}
