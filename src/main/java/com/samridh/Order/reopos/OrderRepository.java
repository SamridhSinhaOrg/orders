package com.samridh.Order.reopos;

import com.samridh.Order.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository  extends MongoRepository<Order, Integer> {
}
