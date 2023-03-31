import entity.Cashier;
import entity.Customer;
import entity.Product;

public class Main {
    public static void main(String[] args) {

        String filePath = "src/main/resources/ExcelSheet.xlsx";

        Product item1 = new Product(filePath,"Sheet1", 1,1,2,3);
        Product item2 = new Product(filePath,"Sheet1", 2,1,2,3);
        Product item3 = new Product(filePath,"Sheet1", 3,1,2,3);
        Product item4 = new Product(filePath,"Sheet1", 4,1,2,3);
        Product item5 = new Product(filePath,"Sheet1", 5,1,2,3);

        Customer customer1 = new Customer();
        Customer customer2 = new Customer();

        customer1.addItem(item1.readName());
        customer1.addItem(item4.readName());
        customer2.addItem(item1.readName());
        customer2.addItem(item2.readName());
        customer2.addItem(item3.readName());
        customer2.addItem(item1.readName());

//        customer2.printReceipt();

        Cashier cashier = new Cashier();

        cashier.addCustomer(customer1);
        cashier.addCustomer(customer2);

        cashier.serveCustomerWithMostItems();

        customer1.addMoney(3000);

        customer1.buyProduct(item5);

        customer2.printReceipt();
    }
}
