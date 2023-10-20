package de.ait.services;

import de.ait.dto.OrderDto;
import de.ait.models.Order;
import de.ait.repositories.OrdersRepositoryListImpl;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class OrdersServiceImplTest {

    private OrdersServiceImpl ordersService;

    @BeforeEach
    void setUp() {
        ordersService = new OrdersServiceImpl(new OrdersRepositoryListImpl());
    }

    @org.junit.jupiter.api.Test
    void getAll() {
        List<String> actual = ordersService.getAll();
        List<String> expected = List.of(
                "Khamidov AA 5566",
                "Mazurenka AA 5567",
                "Pavlov AB 2266",
                "Reger AA 1122",
                "Klein GH 3366"

        );
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void getNextOne() {
        String actual = ordersService.getNextOne();
        String expected = "Order{id='04', name='Reger', regNumber='AA 1122', nameOfService='change oil', termin=2023-10-26T07:20, orderStatus=false}";
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void add() {
        Order order = ordersService.add(
                new OrderDto("Peter", "AA 1122", "change oil", "2023-10-26T07:20"));
        List<Order> actual = ordersService.getOrders();
        List<Order> expected = new ArrayList<>(List.of(
                new Order("01", "Khamidov", "AA 5566", "change oil", "2023-12-03T10:15:00", false),
                new Order("02", "Mazurenka", "AA 5567", "change tyres", "2023-12-15T10:10:00", false),
                new Order("03", "Pavlov", "AB 2266", "wash the car", "2023-11-03T10:30:00", false),
                new Order("04", "Reger", "AA 1122", "change oil", "2023-10-26T07:20:00", false),
                new Order("05", "Klein", "GH 3366", "change tyres", "2023-11-30T17:15:00", false),
                order
        ));
        assertEquals(expected, actual);
    }
}