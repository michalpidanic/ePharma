package Users;

import Pharmacy.Order;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Customer extends User {
    private boolean hasPrescription;

    public Customer(String insuranceNumber) {
        super(insuranceNumber);
        this.hasPrescription = false;
    }

    //TODO make it as login service
    //@Override
    public boolean verifyLogin(String id) {
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

    @Override
    public void payOrder(Order order) {
        if(order.getTotalPrice() > 0) {
            if (order.isPrescriptionNeeded()) {
                if (this.isHasPrescription()) {
                    System.out.println("Zaplatené: " + order.getTotalPrice() + "€" );
                    order.cancelOrder();
                } else {
                    System.out.println("Objednávka vyžaduje lekársky predpis!");
                }
            } else {
                System.out.println("Zaplatené: " + order.getTotalPrice() + "€" );
                order.cancelOrder();
            }
        }
    }

    public boolean isHasPrescription() {
        return hasPrescription;
    }

    public void setHasPrescription(boolean hasPrescription) {
        this.hasPrescription = hasPrescription;
    }
}
