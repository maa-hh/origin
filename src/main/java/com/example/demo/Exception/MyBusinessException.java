package com.example.demo.Exception;

import lombok.Data;

@Data
public class MyBusinessException extends  RuntimeException{
    private int code;
    public MyBusinessException(int code,String massage){
        super(massage);
        this.code=code;
    }
    public MyBusinessException(){

    }
    public MyBusinessException(int code,String massage,Throwable t){
        super(massage,t);
        this.code=code;
    }
}
