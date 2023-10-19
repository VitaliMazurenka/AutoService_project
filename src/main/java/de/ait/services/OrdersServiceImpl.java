package de.ait.services;

import de.ait.dto.OrderDto;
import de.ait.models.Order;
import de.ait.repositories.OrdersRepository;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

public class OrdersServiceImpl implements OrdersService {
  OrdersRepository ordersRepository;

  public OrdersServiceImpl(OrdersRepository ordersRepository) {
    this.ordersRepository = ordersRepository;
  }


  @Override
  public List<String> getAll() {
    List<Order> list = ordersRepository.findAll();
    return list.stream()
            .map(o->o.getName()+" "+ o.getRegNumber()).toList();
  }

  @Override

  public String getNextOne() {
    List<Order> list = ordersRepository.findAll();
    LocalDateTime now = LocalDateTime.now();
    Order nextOrder = list.stream()
            .filter(o->o.getTermin().isAfter(now))
            .min(Comparator.comparing(Order::getTermin)).orElseGet(()->null);

    return nextOrder != null ? nextOrder.toString() : null;
  }
  // принимает OrderDto
  public void add(OrderDto orderDto){


  }
}
