package io.zipcoder.kindquotes.model;


public class Quote {

    private String message;

    public Quote(String msg){
        this.message = msg;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
