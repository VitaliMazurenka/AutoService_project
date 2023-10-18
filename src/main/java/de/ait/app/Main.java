package de.ait.app;

import de.ait.repositories.OrdersRepository;
import de.ait.repositories.OrdersRepositoryListImpl;
import de.ait.services.OrdersService;
import de.ait.services.OrdersServiceImpl;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
//    конфигурируем приложение - с какими Impl будем работать
   OrdersRepository ordersTestRepository = new OrdersRepositoryListImpl();
   // OrdersRepository ordersTextFileRepository =
  //     new OrdersRepositoryTextFileImpl("orders.txt");
    OrdersService ordersService =
        new OrdersServiceImpl(ordersTestRepository); // заменили тестовый на файловый

    while (true) {
      System.out.println("1. Получить все заказы");
      System.out.println("2. Показать след.заказ");
      System.out.println("3. Сохранить нового пользователя");
      System.out.println("4. Вывести средний возраст всех пользователей");
      System.out.println("5. Вывести возраст самого высокого");
      System.out.println("6. Вывести имя и фамилию самого низкого пользователя");
      System.out.println("7. Выход");
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
          System.out.println("...");
//          здесь напишем код
          break;
        case 4:
          System.out.println("...");
//          здесь напишем код
          break;
        case 5:
          System.out.println("...");
//          здесь напишем код
          break;
        case 6:
          System.out.println("...");
//          здесь напишем код
          break;
        case 7:
          System.out.println("Выходим из программы заказов");
          System.exit(0);
          break;
        default:
          System.out.println("Нет такой команды");
      }


    }
  }
}