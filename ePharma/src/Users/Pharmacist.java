package Users;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Pharmacist extends User {
    private String username;
    private String password;

    public Pharmacist(String name, String password, int id) {
        super(name, password, id);
    }

    public static boolean verifyLogin (String username, String password) {
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

}
