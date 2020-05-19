package model.users;

import model.pharmacy.Order;

public class User {
    private String userId;
    private boolean loginStatus;


    public User (String id) {
        this.userId = id;
        this.loginStatus = false;
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

    public void payOrder(Order order) {
    }
}
