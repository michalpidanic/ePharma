package Users;

import Pharmacy.Order;

import java.util.HashMap;

public class Pharmacist extends User implements Payment {
    private String username;
    private String password;

    public Pharmacist(String name, String password, String id) {
        super(id);
        this.username = name;
        this.password = password;
    }

    @Override
    public void payOrder(Order order) {
        if(order.getTotalPrice() > 0) {
            System.out.println("Zaplatené: " + order.getTotalPrice() + "€" );
            order.cancelOrder();
        }
    }

    //TODO make it as login service
    //@Override
    public static boolean verifyLogin(String username, String password, HashMap<String, String> employees) {
        if(employees.containsKey(username)) {
            return employees.get(username).equals(password);
        } else {
            return false;
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
