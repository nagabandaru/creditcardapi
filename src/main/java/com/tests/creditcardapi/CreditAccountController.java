/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tests.creditcardapi;

import jakarta.validation.Valid;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author bhaskar
 */
@RestController
public class CreditAccountController {
 

  private final CreditAccountRepo repository;

  CreditAccountController(CreditAccountRepo repository) {
    this.repository = repository;
  }


  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/creditaccounts")
  List<CreditAccount> all() {
    return repository.findAll();
  }
  // end::get-aggregate-root[]

  @PostMapping("/creditaccounts")
  CreditAccount newCreditCard(@Valid @RequestBody CreditAccount newCreditCard) {
    return repository.save(newCreditCard);
  }
}