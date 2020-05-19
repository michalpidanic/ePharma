package model.users;

import model.pharmacy.Order;

public class Pharmacist extends User implements Payment {
    private String username;
    private String password;

    public Pharmacist(String name, String password, String id) {
        super(id);
        this.username = name;
        this.password = password;
    }

    //TODO alerts instead of println
    @Override
    public void payOrder(Order order) {
        if(order.getTotalPrice() > 0) {
            System.out.println("Zaplatené: " + order.getTotalPrice() + "€" );
            order.cancelOrder();
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}