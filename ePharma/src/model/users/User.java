package model.users;

import model.pharmacy.Order;

import java.io.Serializable;

/**
 * Parent class of all three types of users with parameters, they all have in common
 */
public class User  implements Serializable {
    private String userId;
    private boolean loginStatus;

    /**
     * Constructor
     * @param id Users id
     */
    public User (String id) {
        this.userId = id;
        this.loginStatus = false;
    }

    /**
     * Method is never used, written just for syntax need
     * @param order Order we want to pay
     * @return Returns 0, but never used
     */
    public int payOrder(Order order) {
        return 0;
    }

    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    public String getUserId() {
        return userId;
    }
}
