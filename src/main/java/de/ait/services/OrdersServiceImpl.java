package de.ait.services;

import de.ait.dto.OrderDto;
import de.ait.models.Order;
import de.ait.repositories.OrdersRepository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public class OrdersServiceImpl implements OrdersService {
    OrdersRepository ordersRepository;

    public OrdersServiceImpl(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }


    @Override
    public List<String> getAll() {
        List<Order> list = ordersRepository.findAll();
        return list.stream()
                .map(o -> o.getName() + " " + o.getRegNumber()).toList();
    }

    @Override

    public String getNextOne() {
        List<Order> list = ordersRepository.findAll();
        LocalDateTime now = LocalDateTime.now();
        Order nextOrder = list.stream()
                .filter(o -> o.getTermin().isAfter(now))
                .min(Comparator.comparing(Order::getTermin)).orElseGet(() -> null);

        return nextOrder != null ? nextOrder.toString() : null;
    }

    // принимает OrderDto
    @Override
    public Order add(OrderDto orderDto) {
        Order order = new Order(
                UUID.randomUUID().toString(),
                orderDto.getName(),
                orderDto.getRegNumber(),
                orderDto.getNameOfService(),
                orderDto.getTermin().toString(),
                orderDto.isOrderStatus()
        );
        ordersRepository.saveOrder(order);
        return order;
    }

    @Override
    public List<Order> getOrders() {
        return ordersRepository.findAll();
    }

    @Override
    public List<Order> getSortedOrders() {
        return ordersRepository.findAll().stream()
                .sorted(Comparator.comparing(Order::getTermin)).toList();
    }

}

