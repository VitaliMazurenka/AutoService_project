package de.ait.repositories;

import de.ait.models.Order;

import java.util.ArrayList;
import java.util.List;

public class OrdersRepositoryListImpl implements OrdersRepository {
  private List<Order> orders = new ArrayList<>(List.of(
     new Order("01", "Khamidov", "AA 5566", "change oil", "2023-12-03T10:15:00"),
     new Order("02", "Mazurenka", "AA 5567", "change tyres", "2023-12-15T10:10:00"),
     new Order("03", "Pavlov", "AB 2266", "wash the car", "2023-11-03T10:30:00"),
     new Order("04", "Reger", "AA 1122", "change oil", "2023-10-26T07:20:00"),
     new Order("05", "Klein", "GH 3366", "change tyres", "2023-11-30T17:15:00")

  ));
  @Override
  public List<Order> findAll() {
    return orders;
  }
}
