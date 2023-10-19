package de.ait.services;

import de.ait.dto.OrderDto;

import java.util.List;

public interface OrdersService {
  List<String> getAll();
  String getNextOne();

  public void add(OrderDto orderDto);

}
