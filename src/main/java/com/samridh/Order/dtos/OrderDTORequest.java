package com.samridh.Order.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTORequest {
    private List<FoodItemsDTO> foodItemsList;
    private Integer userId;
    private RestaurantDTO restaurant;
}
