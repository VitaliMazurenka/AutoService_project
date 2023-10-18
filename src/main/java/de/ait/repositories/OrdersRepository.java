package de.ait.repositories;

import de.ait.models.Order;

import java.util.List;

public interface OrdersRepository {
  public List<Order> findAll();
}
