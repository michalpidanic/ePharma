package Users;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

//TODO opytat sa preco to picuje ked dam implements
public class Customer extends User {
    private boolean hasPrescription;

    public Customer(String insuranceNumber) {
        super(insuranceNumber);
        this.hasPrescription = false;
    }

    //TODO opytat sa na static
    //@Override
    public static boolean verifyLogin(String id) {
        boolean found = false;
        String tempId = "";
        String temp= "";

        try {
            Scanner scan = new Scanner(new File("src/Users/patients.txt"));
            scan.useDelimiter("[,\n]");

            while(scan.hasNext() && !found) {
                tempId = scan.next();
                temp = scan.next();

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

    public boolean isHasPrescription() {
        return hasPrescription;
    }

    public void setHasPrescription(boolean hasPrescription) {
        this.hasPrescription = hasPrescription;
    }
}
