package Pharmacy;
import java.util.ArrayList;

public class Order {
    private String orderId;
    private ArrayList<String> items;
    private ArrayList<Double> prices;
    private ArrayList<Integer> quantity;
    private double totalPrice;
    private boolean prescriptionNeeded;

    public Order(String userId) {
        this.orderId = userId;
        this.items = new ArrayList<>();
        this.prices = new ArrayList<>();
        this.quantity = new ArrayList<>();
        this.totalPrice = 0;
        this.prescriptionNeeded = false;
    }

    public void addToOrder(Medicine item, int pieces) {
        this.totalPrice += item.getPrice() * pieces;

        if(this.items.contains(item.getName())) {
            this.quantity.set(this.items.indexOf(item.getName()), this.quantity.get(this.items.indexOf(item.getName())) + pieces);
        } else {
            this.items.add(item.getName());
            this.prices.add(item.getPrice());
            this.quantity.add(pieces);
        }

        if(item.isPrescription()) {
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
