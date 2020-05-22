package model.users;

import model.pharmacy.Order;

public class Customer extends User implements Payment{
    private boolean hasPrescription;

    public Customer(String insuranceNumber) {
        super(insuranceNumber);
        this.hasPrescription = false;
    }

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

    public boolean isHasPrescription() {
        return hasPrescription;
    }

    public void setHasPrescription(boolean hasPrescription) {
        this.hasPrescription = hasPrescription;
    }
}
