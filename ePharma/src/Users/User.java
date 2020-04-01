package Users;
import java.io.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class User {
    private int userId;
    private boolean loginStatus;


    public User (int id) {
        this.userId = id;
        this.username = name;
        this.password = password;
        this.loginStatus = false;

        try(FileWriter fw = new FileWriter("src/Users/users.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.print(name + ",");
            out.print(password + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean login (String username, String password) {
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
                    found = true;
                }
            }
            scan.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return found;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

//    public static void autoLogout (User user) {
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        user.setLoginStatus(false);
//        System.out.println("You've been automatically logged out.");
//    }

//    public String search () {
//
//    }
}
