package com.samridh.Order.controller;


import com.samridh.Order.dtos.OrderDTO;
import com.samridh.Order.dtos.OrderDTORequest;
import com.samridh.Order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/saveOrder")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO saveOrderDetails(@RequestBody OrderDTORequest orderDetails) {
        return orderService.saveOrderDetails(orderDetails);
    }
}
