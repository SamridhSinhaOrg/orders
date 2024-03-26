package com.samridh.Order.service;


import com.samridh.Order.reopos.OrderRepository;
import com.samridh.Order.dtos.OrderDTO;
import com.samridh.Order.dtos.OrderDTORequest;
import com.samridh.Order.dtos.UserDTO;
import com.samridh.Order.entity.Order;
import com.samridh.Order.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    SequenceGenerator sequenceGenerator;

    @Autowired
    RestTemplate restTemplate;


    public OrderDTO saveOrderDetails(OrderDTORequest orderDetails) {
        int nextOrderId = sequenceGenerator.generateNextOrderId();
        UserDTO userDTO = fetchUserDetailsFromUserId(orderDetails.getUserId());
        Order orderToBeSaved = new Order(nextOrderId, orderDetails.getFoodItemsList(),
                orderDetails.getRestaurant(), userDTO);
        return OrderMapper.INSTANCE.mapOrderToOrderDTO(orderToBeSaved);
    }

    private UserDTO fetchUserDetailsFromUserId(Integer userId) {
        return restTemplate.getForObject("http://RESTAURANT-USER-SERVICE/user/fetchUserById/" + userId, UserDTO.class);
    }
}
