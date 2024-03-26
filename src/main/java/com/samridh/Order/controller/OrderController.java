package com.samridh.Order.controller;


import com.samridh.Order.dtos.OrderDTO;
import com.samridh.Order.dtos.OrderDTORequest;
import com.samridh.Order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;


    @PostMapping("/saveOrder")
    public ResponseEntity<OrderDTO> saveOrderDetails(@RequestBody OrderDTORequest orderDetails) {
        OrderDTO orderDTO = orderService.saveOrderDetails(orderDetails);
        return ResponseEntity.ok(orderDTO);
    }
}
