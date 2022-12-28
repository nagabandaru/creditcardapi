/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tests.creditcardapi;

import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author bhaskar
 */
interface CreditAccountRepo extends JpaRepository<CreditAccount, Long> {

}