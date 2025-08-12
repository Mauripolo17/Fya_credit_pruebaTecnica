package com.fya.credit.fya_credit.exceptions;


public class CreditNotFoundException extends ResourceNotFoundException {
  public CreditNotFoundException(String message) {
    super(message);
  }
}