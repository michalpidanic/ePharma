package model.pharmacy;
import java.util.ArrayList;

public class Storage {
    private ArrayList<Medicine> items;
    private ArrayList<Integer> quantity;

    public Storage() {
        this.items = new ArrayList<>();
        this.quantity = new ArrayList<>();
    }

    public void addToStorage(Medicine item, int pieces) {
        if(this.items.contains(item)) {
            this.quantity.set(this.items.indexOf(item), this.quantity.get(this.items.indexOf(item)) + pieces);
        } else {
            this.items.add(item);
            this.quantity.add(pieces);
        }
    }

    //TODO else conditions
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

    public ArrayList<Medicine> getItems() {
        return items;
    }

    public void setItems(ArrayList<Medicine> items) {
        this.items = items;
    }

    public ArrayList<Integer> getQuantity() {
        return quantity;
    }

    public void setQuantity(ArrayList<Integer> quantity) {
        this.quantity = quantity;
    }
}
