package com.auctionall.userservices.application.stub;


import com.auctionall.userservices.application.domain.User;
import com.auctionall.userservices.application.out.UserNotFound;
import com.auctionall.userservices.application.out.Users;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class InMemoryUsers implements Users {
    private final Map<UUID, User> entities = new HashMap<>();

//    @Override
//    public Order findOrderById(UUID orderId) {
//        var order = entities.get(orderId);
//        if (order == null) {
//            throw new OrderNotFound();
//        }
//        return order;
//    }
//
//    @Override
//    public Order save(Order order) {
//        entities.put(order.getId(), order);
//        return order;
//    }
//
//    @Override
//    public void deleteById(UUID orderId) {
//        entities.remove(orderId);
//    }

    @Override
    public User findUserById(UUID userId) throws UserNotFound {
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }
}
