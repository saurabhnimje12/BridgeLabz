package org.ProblemStatements;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

class Sale {
    private int id;
    private int quantity;
    private double price;

    public Sale(int id, int quantity, double price) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}

public class ProductSalesAnalysis {
    public static void main(String[] args) {
        ArrayList<Sale> salesList = new ArrayList<Sale>();
        salesList.add(new Sale(101, 15, 55000));
        salesList.add(new Sale(102, 14, 53000));
        salesList.add(new Sale(103, 17, 65000));
        salesList.add(new Sale(104, 8, 58000));
        salesList.add(new Sale(105, 34, 35000));
        salesList.add(new Sale(106, 44, 34000));
        salesList.add(new Sale(107, 64, 76000));
        salesList.add(new Sale(108, 2, 12000));
        salesList.add(new Sale(109, 7, 84000));
        salesList.add(new Sale(110, 5, 47000));

//        1. Filter: Select sales where the quantity sold is greater than 10.
        salesList.stream()
                .filter(product -> product.getQuantity() > 10)
                .forEach(System.out::println);
        System.out.println("==========================================");

//        2. Transform: Create a new list of ProductSales objects containing productId and the total revenue (quantity * price) for each product.
        Map<Integer, Double> collect = salesList.stream().collect(Collectors.groupingBy(Sale::getId, Collectors.summingDouble(sale -> sale.getQuantity() * sale.getPrice())));
        collect.forEach((productId, revenue) -> System.out.println("Product ID : " + productId + " , " + "Revenue : " + revenue));
        System.out.println("==========================================");

//        3. Sort: Sort the products by total revenue in descending order.
        salesList.stream().sorted(Comparator.comparing(Sale::getPrice).reversed()).forEach(System.out::println);
        System.out.println("==========================================");


//        4. Top N: Retrieve the top 5 products by total revenue.
        salesList.stream().sorted(Comparator.comparing(Sale::getPrice).reversed()).limit(5).forEach(System.out::println);

    }
}
