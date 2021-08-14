package com.stackroute.cartservice.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT , reason = "Product Not Found Exception")
public class ProductNotFoundException extends Exception{
}
