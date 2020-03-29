package Users;

public class User {
    protected String username;
    protected String password;
    protected boolean loginStatus;

    public User (String name, String password) {
        this.username = name;
        this.password = password;
        this.loginStatus = false;
    }

    public void login () {

    }

//    public void autoLogout () {
//
//    }
//
//    public String search () {
//
//    }
}
