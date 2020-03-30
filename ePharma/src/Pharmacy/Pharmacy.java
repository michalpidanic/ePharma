package Pharmacy;
import Users.*;
import javafx.beans.binding.When;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class Pharmacy {


    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        users.add(new User("admin1", "admin1"));
        users.add(new User("admin2", "admin2"));
        users.add(new User("admin3", "admin3"));
        users.add(new User("admin4", "admin4"));
        users.add(new User("admin5", "admin5"));


        findUser("admin1").setLoginStatus(User.login("admin1", "admin1"));

        if(findUser("admin1").isLoginStatus()) {
            System.out.println("Login succesful!");
        } else {
            System.out.println("Login not succesful!");
        }


    }

    public static ArrayList<User> users = new ArrayList<>();

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
