package model.pharmacy;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class contains list of all medicines that pharmacy sells
 */
public class Storage implements Serializable {
    private ArrayList<Medicine> items;
    private ArrayList<Integer> quantity;

    /**
     * Constructor creates list of items and its quantity
     */
    public Storage() {
        this.items = new ArrayList<>();
        this.quantity = new ArrayList<>();
    }

    /**
     * Method for adding new medicine to storage
     * @param item Item we want to add
     * @param pieces Quantity of item we want to add
     */
    public void addToStorage(Medicine item, int pieces) {
        Medicine medicine = findMedicine(item.getName());
        if(medicine != null) {
            this.quantity.set(this.items.indexOf(medicine), this.quantity.get(this.items.indexOf(medicine)) + pieces);
        } else {
            this.items.add(item);
            this.quantity.add(pieces);
        }
    }

    /**
     * Method for taking medicine from storage
     * @param item Item we want to take
     * @param pieces Quantity of item we want to take
     */
    public void takeFromStorage(Medicine item, int pieces) {
        if(this.items.contains(item)) {
            if(this.quantity.get(this.items.indexOf(item)) - pieces > 0) {
                this.quantity.set(this.items.indexOf(item), this.quantity.get(this.items.indexOf(item)) - pieces);
            } else if(this.quantity.get(this.items.indexOf(item)) - pieces == 0) {
                this.quantity.set(this.items.indexOf(item), 0);
            } else {
                //number of pieces not available
            }
        } else {
            //product not available
        }
    }

    /**
     * Method finds medicine by its name
     * @param name Name of medicine we looking for
     * @return Medicine if exists, else null
     */
    public Medicine findMedicine(String name) {
        for (Medicine medicine : this.getItems()) {
            if (medicine.getName().equals(name)) {
                return medicine;
            }
        }
        return null;
    }

    public ArrayList<Medicine> getItems() {
        return items;
    }

    public ArrayList<Integer> getQuantity() {
        return quantity;
    }
}
