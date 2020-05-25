package model.users;

import model.pharmacy.Order;

/**
 * Class of customer, which is created when valid insurance number is typed in login field
 */
public class Customer extends User implements Payment{
    private boolean hasPrescription;

    /**
     * Constructor
     * @param insuranceNumber Insurance number of customer
     */
    public Customer(String insuranceNumber) {
        super(insuranceNumber);
        this.hasPrescription = false;
    }

    /**
     * Method for paying the order, if customer has prescription or prescription is not needed
     * @param order Order we want to pay
     * @return Return 1 when succesful, 2 when customer don't have prescription and prescription is needed, 0 when order has price 0
     */
    @Override
    public int payOrder(Order order) {
        if(order.getTotalPrice() > 0) {
            if (order.isPrescriptionNeeded()) {
                if (this.hasPrescription) {
                    order.cancelOrder();
                    return 1;
                } else {
                    return 2;
                }
            } else {
                order.cancelOrder();
                return 1;
            }
        }
        return 0;
    }

    public void setHasPrescription(boolean hasPrescription) {
        this.hasPrescription = hasPrescription;
    }
}
