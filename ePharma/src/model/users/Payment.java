package model.users;

import model.pharmacy.Order;

/**
 * Interface for payment method, which differs based on paying user
 * Interface is implemented by Customer and Pharmacist (HeadPharmacist)
 */
public interface Payment {
    public int payOrder(Order order);
}
