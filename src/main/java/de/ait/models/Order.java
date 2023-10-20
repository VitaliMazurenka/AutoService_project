package de.ait.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Order {
    private String id;
    private String name;
    private String regNumber;
    private String nameOfService;
    private LocalDateTime termin;
    private boolean orderStatus;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (orderStatus != order.orderStatus) return false;
        if (!Objects.equals(id, order.id)) return false;
        if (!Objects.equals(name, order.name)) return false;
        if (!Objects.equals(regNumber, order.regNumber)) return false;
        if (!Objects.equals(nameOfService, order.nameOfService))
            return false;
        return Objects.equals(termin, order.termin);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (regNumber != null ? regNumber.hashCode() : 0);
        result = 31 * result + (nameOfService != null ? nameOfService.hashCode() : 0);
        result = 31 * result + (termin != null ? termin.hashCode() : 0);
        result = 31 * result + (orderStatus ? 1 : 0);
        return result;
    }

    public Order(String id, String name, String regNumber, String nameOfService, String termin, boolean orderStatus) {
        this.id = id;
        this.name = name;
        this.regNumber = regNumber;
        this.nameOfService = nameOfService;
        this.termin = LocalDateTime.parse(termin);
        this.orderStatus = orderStatus;

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public String getNameOfService() {
        return nameOfService;
    }

    public LocalDateTime getTermin() {
        return termin;
    }

    public boolean isOrderStatus() {
        return orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", regNumber='" + regNumber + '\'' +
                ", nameOfService='" + nameOfService + '\'' +
                ", termin=" + termin +
                ", orderStatus=" + orderStatus +
                '}';
    }

}
