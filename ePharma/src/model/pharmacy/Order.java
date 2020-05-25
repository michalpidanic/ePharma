package model.pharmacy;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class which holds information about order, such as products, quantity of products, price of order etc.
 */
public class Order implements Serializable {
    private String orderId;
    private ArrayList<Medicine> items;
    private ArrayList<Integer> quantity;
    private double totalPrice;
    private boolean prescriptionNeeded;

    /**
     * Constructor
     * @param userId Id of owner of order
     */
    public Order(String userId) {
        this.orderId = userId;
        this.items = new ArrayList<>();
        this.quantity = new ArrayList<>();
        this.totalPrice = 0;
        this.prescriptionNeeded = false;
    }

    /**
     * Method which adds product to order
     * @param item Item we want to add to order
     * @param pieces Quantity of item we want to add
     * @param storage Storage of pharmacy, from where we will take the items
     */
    public void addToOrder(Medicine item, int pieces, Storage storage) {
        this.totalPrice += item.getPrice() * pieces;

        if(this.items.contains(item)) {
            this.quantity.set(this.items.indexOf(item), this.quantity.get(this.items.indexOf(item)) + pieces);
        } else {
            this.items.add(item);
            this.quantity.add(pieces);
        }

        if(item.isPrescription()) {
            this.prescriptionNeeded = true;
        }

        storage.takeFromStorage(item, pieces);
    }

    /**
     * Method takes item from order and returns it back to storage
     * @param item Item we want to delete from order (only one piece)
     * @param storage Pharmacy storage, where we return product
     */
    public void takeFromOrder(Medicine item, Storage storage) {
        this.totalPrice -= item.getPrice();

        if(this.quantity.get(this.items.indexOf(item)) - 1 > 0) {
            this.quantity.set(this.items.indexOf(item), this.quantity.get(this.items.indexOf(item)) - 1);
        } else if(this.quantity.get(this.items.indexOf(item)) - 1 == 0) {
            this.quantity.remove(this.items.indexOf(item));
            this.items.remove(item);

            if(item.isPrescription()) {
                this.prescriptionNeeded = false;
                for(Medicine i : this.items) {
                    if(i.isPrescription()) {
                        this.prescriptionNeeded = true;
                        break;
                    }
                }
            }
        }

        storage.addToStorage(item, 1);
    }

    /**
     * Method for deleting order after payment
     */
    public void cancelOrder() {
        this.items.clear();
        this.quantity.clear();
        this.totalPrice = 0;
        this.prescriptionNeeded = false;
    }

    /**
     * Method for canceling order with returning all items back to storage
     * @param storage Storage where we put items
     */
    public void cancelOrder(Storage storage) {
        this.items.forEach(i -> storage.addToStorage(i, this.quantity.get(this.items.indexOf(i))));
        this.items.clear();
        this.quantity.clear();
        this.totalPrice = 0;
        this.prescriptionNeeded = false;
    }

    public ArrayList<Medicine> getItems() {
        return items;
    }

    public ArrayList<Integer> getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public boolean isPrescriptionNeeded() {
        return prescriptionNeeded;
    }
}
