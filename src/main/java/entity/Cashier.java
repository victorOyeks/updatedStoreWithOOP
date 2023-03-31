package entity;

import java.util.PriorityQueue;

public class Cashier extends StaffProp {
    private Integer strikeCount;
    private boolean fired = false;

    private PriorityQueue<Customer> fifoQueue;
    private PriorityQueue<Customer> itemQueue;

    public Cashier() {
        super();
        fifoQueue = new PriorityQueue<>();
        itemQueue = new PriorityQueue<>(new ItemComparator());
    }

    public void addCustomer(Customer customer) {
        fifoQueue.offer(customer);
        itemQueue.offer(customer);
    }

    public void serveNextCustomer() {
        Customer customer = fifoQueue.poll();
        if (customer != null) {
            System.out.println("Attending to customer " + customer.getId() + ". He is next on the queue.");
            customer.printReceipt();
        } else {
            System.out.println("No more customers in the FIFO queue.");
        }
    }

    public void serveCustomerWithMostItems() {
        Customer customer = itemQueue.poll();
        if (customer != null) {
            System.out.println("Attending to customer " + customer.getId() + " with the most items.");
            customer.printReceipt();
        } else {
            System.out.println("No more customers in the item queue.");
        }
    }

    public Cashier(String name,String position, int strikeCount) {
        super(name,position);
        this.strikeCount =strikeCount;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getPosition() {
        return super.getPosition();
    }

    public Integer getStrikeCount() {
        return strikeCount;
    }

    public void setStrikeCount(Integer strikeCount) {
        this.strikeCount = strikeCount;
    }

    public boolean isFired() {
        return fired;
    }

    public void setFired(boolean fired) {
        this.fired = fired;
    }

    private class ItemComparator implements java.util.Comparator<Customer> {
        @Override
        public int compare(Customer c1, Customer c2) {
            return c2.getNumItems() - c1.getNumItems();
        }

    }

}

