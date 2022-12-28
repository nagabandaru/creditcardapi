/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tests.creditcardapi;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorContextImpl;

/**
 *
 * @author bhaskar
 */
public class CreditCardNumberValidator implements 
        ConstraintValidator<CreditCardNumberConstrain, String> {

    @Override
    public void initialize(CreditCardNumberConstrain creditCardNumber) {
        
    }
    @Override
    public boolean isValid(String cardNo,
            ConstraintValidatorContext cxt) {
        boolean isValid = cardNo != null && cardNo.matches("[0-9]+")
          && (cardNo.length() > 1) && (cardNo.length() <= 19);
        if(!isValid){
            ((ConstraintValidatorContextImpl)cxt).addMessageParameter("cardNo", cardNo);
            
        }
        return isValid;
    }

}