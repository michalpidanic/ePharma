package Pharmacy;
import java.util.ArrayList;

public class Order {
    private int orderId;
    private ArrayList<String> items;
    private ArrayList<Double> prices;
    private ArrayList<Integer> quantity;
    private double totalPrice;
    private boolean prescriptionNeeded;

    public Order(int userId) {
        this.orderId = userId;
        this.items = new ArrayList<>();
        this.prices = new ArrayList<>();
        this.quantity = new ArrayList<>();
        this.totalPrice = 0;
        this.prescriptionNeeded = false;
    }

    public void addToOrder(String item, double price, int pieces, boolean prescription) {
        this.totalPrice += price * pieces;

        if(this.items.contains(item)) {
            this.quantity.set(this.items.indexOf(item), this.quantity.get(this.items.indexOf(item)) + pieces);
        } else {
            this.items.add(item);
            this.prices.add(price);
            this.quantity.add(pieces);
        }

        if(prescription) {
            this.prescriptionNeeded = true;
        }
    }

    public void cancelOrder() {
        this.items.clear();
        this.prices.clear();
        this.quantity.clear();
        this.totalPrice = 0;
        this.prescriptionNeeded = false;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public void setItems(ArrayList<String> items) {
        this.items = items;
    }

    public ArrayList<Double> getPrices() {
        return prices;
    }

    public void setPrices(ArrayList<Double> prices) {
        this.prices = prices;
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
