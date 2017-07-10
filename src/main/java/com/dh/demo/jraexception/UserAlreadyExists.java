package com.dh.demo.jraexception;

/**
 * Created by Juan Zapata on 7/9/2017.
 */
public class UserAlreadyExists extends Exception {
    public UserAlreadyExists(String message){
        super(message);
    }
}
