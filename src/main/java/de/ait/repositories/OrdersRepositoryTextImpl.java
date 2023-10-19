package de.ait.repositories;

import de.ait.models.Order;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrdersRepositoryTextImpl implements OrdersRepository {

    String fileName;

    public OrdersRepositoryTextImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Order> findAll() {
        List<Order> orders = new ArrayList<>();
        // try-with-resources
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = bufferedReader.readLine();
            while (line != null) {
                Order order = parseLine(line);
                orders.add(order);
                line = bufferedReader.readLine();
            }
            //
        } catch (IOException e) {
            System.out.println(" Произошла ошибка");

        }
        return orders;
    }

    @Override
    public void saveOrder(Order order) {
        // order-> в строчку текста( | ) -> BufferedWriter -> файл txt
        String line = convert(order);
        try(
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true));
                ) {
          bufferedWriter.write(line);
          bufferedWriter.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static String convert(Order order) {
        return order.getId() + "|" + order.getName() + "|"
                + order.getRegNumber() + "|" + order.getNameOfService() + "|" + order.getTermin() + "|" + order.isOrderStatus();
    }

    public static Order parseLine(String line) {
        String[] parsed = line.split("\\|");
        String id = parsed[0];
        String name = parsed[1];
        String regNumber = parsed[2];
        String nameOfService = parsed[3];
        String termin = parsed[4];
        boolean orderStatus = Boolean.parseBoolean(parsed[5]); // преобразование String в boolean

        return new Order(id, name, regNumber, nameOfService, termin, orderStatus);
    }
}
