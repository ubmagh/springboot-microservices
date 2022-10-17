package me.ubmagh.ap1.exceptions;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(String customerId){
        super(customerId);
    }
}
