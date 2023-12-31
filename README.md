# Auto-Service
- Проект создает заказы, сохраняет в файл и отображает их список.
- Запуск проекта осуществляется следующим образом: AutoService_project/src/main/java/de/app/Main.java
  В Main.java нужно запустить программу Run и выбрать необходимый пункт меню. Работа программы 
  осуществляется в виде диалога Пользователя и программы через Scanner.
- Запуск тестов осуществляется следующим образом: AutoService_project/src/test/java/de/ait/services
  /OrdersServiceImplTest.java

## Методы
- List<String> getAll() - получает список всех заказов в виде String (основная информация заказа);
```java
 @Override
    public List<String> getAll() {
        List<Order> list = ordersRepository.findAll();
        return list.stream()
                .map(o -> o.getName() + " " + o.getRegNumber()).toList();
    }
```
- List<Order> getOrders() - получает список всех заказов в виде Order(полная информация);
```java
 @Override
    public List<Order> getOrders() {
        return ordersRepository.findAll();
    }
```
- String getNextOne() - получает следующий заказ по дате;
  ```java
  @Override
  public String getNextOne() {
  List<Order> list = ordersRepository.findAll();
  LocalDateTime now = LocalDateTime.now();
  Order nextOrder = list.stream()
  .filter(o -> o.getTermin().isAfter(now))
  .min(Comparator.comparing(Order::getTermin)).orElseGet(() -> null);

        return nextOrder != null ? nextOrder.toString() : null;
  }
  ```
- public Order add(OrderDto orderDto) - добавляет новый заказ в список существующих в текстовый файл orders.txt;
```java
 @Override
    public Order add(OrderDto orderDto) {
        Order order = new Order(
                UUID.randomUUID().toString(),
                orderDto.getName(),
                orderDto.getRegNumber(),
                orderDto.getNameOfService(),
                orderDto.getTermin().toString(),
                orderDto.isOrderStatus()
        );
        ordersRepository.saveOrder(order);
        return order;
    }
```
