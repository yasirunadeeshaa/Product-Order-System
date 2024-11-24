package com.test_6.Order.common;


import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.test_6.Order.DTO.OrderDTO;
import lombok.Getter;

@Getter
public class SuccessOrderResponse implements OrderResponse {
    @JsonUnwrapped
    private final OrderDTO order;

    public SuccessOrderResponse(OrderDTO order) {
        this.order = order;
    }
}