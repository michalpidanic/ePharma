package model.pharmacy;
import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable {
    private String orderId;
    private ArrayList<Medicine> items;
    private ArrayList<Integer> quantity;
    private double totalPrice;
    private boolean prescriptionNeeded;

    public Order(String userId) {
        this.orderId = userId;
        this.items = new ArrayList<>();
        this.quantity = new ArrayList<>();
        this.totalPrice = 0;
        this.prescriptionNeeded = false;
    }

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

    public void cancelOrder() {
        this.items.clear();
        this.quantity.clear();
        this.totalPrice = 0;
        this.prescriptionNeeded = false;
    }

    public void cancelOrder(Storage storage) {
        for(Medicine i : this.items) {
            storage.addToStorage(i, this.quantity.get(this.items.indexOf(i)));
        }
        this.items.clear();
        this.quantity.clear();
        this.totalPrice = 0;
        this.prescriptionNeeded = false;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isPrescriptionNeeded() {
        return prescriptionNeeded;
    }

    public void setPrescriptionNeeded(boolean prescriptionNeeded) {
        this.prescriptionNeeded = prescriptionNeeded;
    }
}
