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
    private boolean checkLuhn(String cardNo){
        int digits = cardNo.length();

        int sum = 0;
        boolean isSecond = false;
        for (int i = digits - 1; i >= 0; i--)
        {

            int d = cardNo.charAt(i) - '0';

            if (isSecond == true)
                d = d * 2;
            sum += d / 10;
            sum += d % 10;

            isSecond = !isSecond;
        }
        return (sum % 10 == 0);
    }
    @Override
    public boolean isValid(String cardNo,
            ConstraintValidatorContext cxt) {
        boolean isValid = cardNo != null && cardNo.matches("[0-9]+")
          && (cardNo.length() > 1) && (cardNo.length() <= 19) && checkLuhn(cardNo);
        if(!isValid){
            ((ConstraintValidatorContextImpl)cxt).addMessageParameter("cardNo", cardNo);
            
        }
        return isValid;
    }

}