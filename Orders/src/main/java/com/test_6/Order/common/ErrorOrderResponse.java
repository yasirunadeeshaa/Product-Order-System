package com.test_6.Order.common;


import lombok.Getter;

@Getter
public class ErrorOrderResponse implements OrderResponse {
    private final String errorMessage;

    public ErrorOrderResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }

//    public String errorMessagee() {
//        return "errorrrrrrrrrrrrrrrrrrrrrrrr";
//    }
//
//    public static class errorMessagee implements OrderResponse {
//    }
}