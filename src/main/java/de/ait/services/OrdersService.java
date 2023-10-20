package de.ait.services;

import de.ait.dto.OrderDto;
import de.ait.models.Order;

import java.util.List;

public interface OrdersService {
  List<String> getAll();
  String getNextOne();

  public Order add(OrderDto orderDto);

  List<Order> getOrders();

}
