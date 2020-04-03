package Users;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class Login {
    public static boolean verifyLogin(String id) {
        boolean found = false;
        String tempId = "";
        String prescription= "";

        try {
            Scanner scan = new Scanner(new File("src/Users/patients.txt"));
            scan.useDelimiter("[,\n]");

            while(scan.hasNext() && !found) {
                tempId = scan.next();
                prescription = scan.next();

                if(tempId.equals(id)) {
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
