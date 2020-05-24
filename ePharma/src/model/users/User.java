package model.users;

import model.pharmacy.Order;

import java.io.Serializable;

public class User  implements Serializable {
    private String userId;
    private boolean loginStatus;


    public User (String id) {
        this.userId = id;
        this.loginStatus = false;
    }

    public int payOrder(Order order) {
        return 0;
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
