package com.tests.creditcardapi;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import java.util.Objects;


@Entity
public class CreditAccount {

  private @Id @GeneratedValue Long id;
  private String name;
  
  @Column(unique = true)
  @CreditCardNumberConstrain(message = "Credit account number is invalid: ${cardNo}")
  private String cardNo;
  @NotNull
  private int amountLimit;
  @NotNull
  private int balance;

  CreditAccount() {}

  CreditAccount(String name, String cardNo, int limit) {

    this.name = name;
    this.cardNo = cardNo;
    this.amountLimit = limit;
    this.balance = 0;
  }

  public Long getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public int getAmountLimit() {
        return amountLimit;
    }

    public void setAmountLimit(int amountLimit) {
        this.amountLimit = amountLimit;
    }

  
  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

  
  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof CreditAccount))
      return false;
    CreditAccount employee = (CreditAccount) o;
    return Objects.equals(this.id, employee.id) && Objects.equals(this.name, employee.name);
//        && Objects.equals(this.role, employee.role);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.name);
  }

  @Override
  public String toString() {
    return  this.name ;
  }
}