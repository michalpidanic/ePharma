package model.users;

import model.pharmacy.Order;

/**
 * Class for pharmacy employee
 */
public class Pharmacist extends User implements Payment {
    private String username;
    private String password;

    /**
     * Constructor
     * @param name Username
     * @param password Password
     * @param id Id
     */
    public Pharmacist(String name, String password, String id) {
        super(id);
        this.username = name;
        this.password = password;
    }

    /**
     * Method for paying order, doesn't matter if prescription is needed
     * @param order Order we want to pay
     * @return Returns 1 when successful, 0 when order has price 0
     */
    @Override
    public int payOrder(Order order) {
        if(order.getTotalPrice() > 0) {
            order.cancelOrder();
            return 1;
        }
        return 0;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
