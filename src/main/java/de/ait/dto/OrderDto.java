package de.ait.dto;

import java.time.LocalDateTime;

public class OrderDto {

    private String name;
    private String regNumber;
    private String nameOfService;
    private LocalDateTime termin;
    private boolean orderStatus;

    public OrderDto( String name, String regNumber, String nameOfService, String termin) {

        this.name = name;
        this.regNumber = regNumber;
        this.nameOfService = nameOfService;
        this.termin = LocalDateTime.parse(termin);

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
                ", name='" + name + '\'' +
                ", regNumber='" + regNumber + '\'' +
                ", nameOfService='" + nameOfService + '\'' +
                ", termin=" + termin +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
