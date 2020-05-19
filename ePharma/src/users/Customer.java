package users;

import pharmacy.Order;

public class Customer extends User implements Payment{
    private boolean hasPrescription;

    public Customer(String insuranceNumber) {
        super(insuranceNumber);
        this.hasPrescription = false;
    }

    //TODO alerts instead of println
    @Override
    public void payOrder(Order order) {
        if(order.getTotalPrice() > 0) {
            if (order.isPrescriptionNeeded()) {
                if (this.hasPrescription) {
                    System.out.println("Zaplatené: " + order.getTotalPrice() + "€" );
                    order.cancelOrder();
                } else {
                    System.out.println("Objednávka vyžaduje lekársky predpis!");
                }
            } else {
                System.out.println("Zaplatené: " + order.getTotalPrice() + "€" );
                order.cancelOrder();
            }
        }
    }

    public boolean isHasPrescription() {
        return hasPrescription;
    }

    public void setHasPrescription(boolean hasPrescription) {
        this.hasPrescription = hasPrescription;
    }
}
