package com.test_6.Order.controller;

import com.test_6.Order.DTO.OrderDTO;
import com.test_6.Order.DTO.OrderEventDTO;
import com.test_6.Order.common.OrderResponse;
import com.test_6.Order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/getorders")
    public List<OrderDTO> getOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/order/{orderId}")
    public OrderDTO getOrderByOrderId(@PathVariable Integer id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/addorder")
    public OrderResponse saveOrder(@RequestBody OrderDTO orderDTO) {
//        OrderEventDTO orderEventDTO = new OrderEventDTO();
//        orderEventDTO.setMessage("Order is committed");
//        orderEventDTO.setStatus("pending");
//        //orderProducer.sendMessage(orderEventDTO);
//
        return orderService.saveOrder(orderDTO);
    }

    @PutMapping("/updateorder")
    public OrderDTO updateOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.updateOrder(orderDTO);
    }

    @DeleteMapping("/deleteorder/{id}")
    public String deleteOrder(@PathVariable Integer id) {
        return orderService.deleteOrder(id);
    }

}