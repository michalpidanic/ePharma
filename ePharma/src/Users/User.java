package Users;
import Pharmacy.Pharmacy;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.UnknownServiceException;
import java.util.Scanner;

public class User {
    private String username;
    private String password;
    private boolean loginStatus;


    public User (String name, String password) throws FileNotFoundException, UnsupportedEncodingException {
        this.username = name;
        this.password = password;
        this.loginStatus = false;

//        writer.append(this.username + "\n");
//        writer.append(this.password + "\n");
//        writer.close();
    }

    public static void login (String username, String password) {
        boolean found = false;
        String tempName = "";
        String tempPass = "";

        try {
            Scanner scan = new Scanner(new File("src/Users/users.txt"));
            scan.useDelimiter("[,\n]");

            while(scan.hasNext() && !found) {
                tempName = scan.next();
                tempPass = scan.next();

                if(tempName.equals(username) && tempPass.equals(password)) {
                    Pharmacy.findUser(username).setLoginStatus(true);
                    found = true;
                }
            }

            scan.close();
            System.out.println(found);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean isLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//    public void autoLogout () {
//
//    }
//
//    public String search () {
//
//    }
}
