package model.users;

import model.pharmacy.Order;

public interface Payment {
    public int payOrder(Order order);
}
