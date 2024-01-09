package mx.edu.greengates.vendingmachine;

public class Item {
    public int id;
    public String name;
    public double price;
    public int quantity;

    public Item(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String toString() {
        return "Item: " + id + " " + name + " " + price + " " + quantity;
    }
}
