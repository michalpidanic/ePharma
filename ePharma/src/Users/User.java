package Users;
import Pharmacy.Order;

import java.io.*;
import java.util.HashMap;

//TODO addToOrder takeFromOrder
public class User {
    private String userId;
    private boolean loginStatus;


    public User (String id) {
        this.userId = id;
        this.loginStatus = false;
    }

    public void payOrder(Order order) {
        if(order.getTotalPrice() > 0) {
            System.out.println("Zaplatené: " + order.getTotalPrice() + "€" );
            order.cancelOrder();
        }
    }

    public boolean isLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
