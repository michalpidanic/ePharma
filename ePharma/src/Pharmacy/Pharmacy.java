package Pharmacy;
import Users.*;
import java.util.ArrayList;

public class Pharmacy {
    public static void main(String[] args) {
        int id = 0;

        users.add(new User("admin1", "admin1", ++id));
        users.add(new User("admin2", "admin2", ++id));
        users.add(new User("admin3", "admin3", ++id));
        users.add(new User("admin4", "admin4", ++id));
        users.add(new User("admin5", "admin5", ++id));

        findUser("admin1").setLoginStatus(User.login("admin1", "admin1"));

        if(findUser("admin1").isLoginStatus()) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login not successful!");
        }
    }


    static ArrayList<User> users = new ArrayList<>();

    public static User findUser(String name) {
        int i = 0;
        while(true) {
            if(users.get(i).getUsername().equals(name)) {
                return users.get(i);
            }
            i++;
        }
    }
}
