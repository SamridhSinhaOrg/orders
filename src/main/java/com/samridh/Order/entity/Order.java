package com.samridh.Order.entity;

import com.samridh.Order.dtos.FoodItemsDTO;
import com.samridh.Order.dtos.RestaurantDTO;
import com.samridh.Order.dtos.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("order")
public class Order {

    private Integer orderId;
    private List<FoodItemsDTO> foodItemsList;
    private RestaurantDTO restaurant;
    private UserDTO userDTO;

}
