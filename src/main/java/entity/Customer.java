package entity;

import java.util.ArrayList;
import java.util.List;

public class Customer implements Comparable<Customer> {

    private String name;
    private int wallet = 0;
    private int quantity;
    private static int nextId = 1;
    private int id;
    private List<String> items;

    public List<String> getItems() {
        return items;
    }

    public Customer(String name, int wallet, int quantity) {
        this.name = name;
        this.wallet = wallet;
        this.quantity = quantity;
    }

    public Customer() {
        this.id = nextId++;
        this.items = new ArrayList<>();
    }

    public void addItem(String item) {
        items.add(item);
    }

    public int getNumItems() {
        return items.size();
    }

    public int getId() {
        return id;
    }

    public void addMoney(int amount) {
        wallet += amount;
    }

    public void addQuantity(int amount) {
        quantity += amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    public void printReceipt() {
        System.out.println("entity.Customer " + id + " bought the following items:");
        for (String item : items) {
            System.out.println("- " + item);
        }
    }

    public void buyProduct(Product product) {
        if ((wallet - product.readPrice()) < 0) {
            System.out.println("Sorry, you don't have enough cash in your wallet.");
        } else if (product.readQuantity() - quantity < 0) {
            System.out.println("This is product is currently OUT OF STOCK");
        } else {
            System.out.println("Thank you for shopping with us. Do have a nice day.");
             System.out.println("Receipt: " + product.readName() + " costing " + product.readPrice() + " bought");
            }
    }

    @Override
    public int compareTo(Customer other) {
        return Integer.compare(this.id, other.id);
    }
}

