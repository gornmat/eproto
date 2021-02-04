package com.demo.eproto.exception;

public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException() {
        super("Account Not Found");
    }

}
