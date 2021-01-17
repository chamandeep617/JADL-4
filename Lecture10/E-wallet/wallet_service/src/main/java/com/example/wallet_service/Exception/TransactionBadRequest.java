package com.example.wallet_service.Exception;

public class TransactionBadRequest extends RuntimeException {

    public TransactionBadRequest(){
        super("TransactionBadRequest");
    }
}