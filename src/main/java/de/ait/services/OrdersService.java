package de.ait.services;

import java.util.List;

public interface OrdersService {
  List<String> getAll();
  String getNextOne();
}
