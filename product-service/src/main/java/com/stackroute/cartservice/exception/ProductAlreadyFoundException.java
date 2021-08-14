package com.stackroute.cartservice.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT , reason = "Product Already there exception")
public class ProductAlreadyFoundException extends Exception{
}
