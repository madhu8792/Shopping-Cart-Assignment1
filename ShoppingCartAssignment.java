package Shopping;

import java.util.ArrayList;
import java.util.List;

class Product {
    private String name;
    private double unitPrice;
    private double gst;
    private int quantity;

    public Product(String name, double unitPrice, double gst, int quantity) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.gst = gst;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getGST() {
        return gst;
    }

    public int getQuantity() {
        return quantity;
    }
}

public class shoppingCart {
    public static void main(String[] args) {
        List<Product> basket = new ArrayList<>();

        // Add products to the basket
        basket.add(new Product("Leather wallet", 1100, 18, 1));
        basket.add(new Product("Umbrella", 900, 12, 4));
        basket.add(new Product("Cigarette", 200, 28, 3));
        basket.add(new Product("Honey", 100, 0, 2));

        // Identify the product with the maximum GST amount
        Product maxGstProduct = findProductWithMaxGST(basket);
        System.out.println("Product with maximum GST amount: " + maxGstProduct.getName());

        // Calculate the total amount to be paid to the shopkeeper
        double totalPayment = calculateTotalPayment(basket);
        System.out.println("Total amount to be paid to the shopkeeper: " + totalPayment + " Rupees");
    }

    private static Product findProductWithMaxGST(List<Product> basket) {
        Product maxGstProduct = null;
        double maxGstAmount = 0;

        for (Product product : basket) {
            double gstAmount = (product.getUnitPrice() * product.getGST()) / 100;
            if (gstAmount > maxGstAmount) {
                maxGstProduct = product;
                maxGstAmount = gstAmount;
            }
        }

        return maxGstProduct;
    }

    private static double calculateTotalPayment(List<Product> basket) {
        double totalPayment = 0;

        for (Product product : basket) {
            double unitPrice = product.getUnitPrice();
            int quantity = product.getQuantity();
            double totalAmount = unitPrice * quantity;

            if (unitPrice >= 500) {
                totalAmount *= 0.95; // Apply 5% discount
            }

            totalPayment += totalAmount;
        }

        return totalPayment;
    }
}

