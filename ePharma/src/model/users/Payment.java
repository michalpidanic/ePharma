package model.users;

import model.pharmacy.Order;

public interface Payment {
    public void payOrder(Order order);
}
