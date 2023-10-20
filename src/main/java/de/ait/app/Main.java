package de.ait.app;

import de.ait.dto.OrderDto;
import de.ait.repositories.OrdersRepository;
import de.ait.repositories.OrdersRepositoryListImpl;
import de.ait.repositories.OrdersRepositoryTextImpl;
import de.ait.services.OrdersService;
import de.ait.services.OrdersServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//    конфигурируем приложение - с какими Impl будем работать
        // OrdersRepository ordersTestRepository = new OrdersRepositoryListImpl();
        OrdersRepository ordersTextFileRepository =
                new OrdersRepositoryTextImpl("orders.txt");
        OrdersService ordersService =
                new OrdersServiceImpl(ordersTextFileRepository); // заменили текстовый на файловый

        while (true) {
            System.out.println("1. Получить все заказы");
            System.out.println("2. Показать след.заказ");
            System.out.println("3. Показать заказы сортированные по дате");
            System.out.println("4. Создать новый заказ");
            System.out.println("5. Выход");
            int command = scanner.nextInt(); // считываем команду
            scanner.nextLine(); // чтобы не было бага со сканером
//    вызываем соответствующие "процессы" в нашей программе
            switch (command) {
                case 1:
                    System.out.println("Выводим все заказы...");
                    System.out.println(ordersService.getAll());
                    break;
                case 2:
                    System.out.println("Выводим следующий заказ...");
                    System.out.println(ordersService.getNextOne());
                    break;
                case 3:
                    System.out.println("Сортировка заказов по дате");
//          здесь напишем код
                    break;
                case 4:
                    System.out.println("Создать новый заказ");
                    System.out.println("Введите имя...");
//          получить поля от user, объеденить в OrderDto/ передать в метод add
                    String nameStr = scanner.nextLine();
                    System.out.println("Введите регистрационный номер...");
                    String regNumberStr = scanner.nextLine();
                    System.out.println("Введите тип работ...");
                    String typeOfServiceStr = scanner.nextLine();
                    System.out.println("Введите желаемую дату...");
                    String dateStr = scanner.nextLine();
                    System.out.println("Введите желаемое время...");
                    String timeStr = scanner.nextLine();
                    OrderDto orderDto = new OrderDto(nameStr, regNumberStr, typeOfServiceStr, dateStr + "T" + timeStr);
                    ordersService.add(orderDto);
                    scanner.nextLine();
                    break;
                case 5:
                    System.out.println("Выходим из программы заказов");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Нет такой команды");
            }


        }
    }
}