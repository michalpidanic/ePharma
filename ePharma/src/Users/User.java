package Users;
import java.io.*;
import java.util.HashMap;

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
}