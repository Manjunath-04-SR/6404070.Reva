package ecommerce;

import java.util.Scanner;

public class SearchTest {
    public static void main(String[] args) {
        Product[] products = {
            new Product(104, "Shoes", "Fashion"),
            new Product(102, "Laptop", "Electronics"),
            new Product(105, "Watch", "Accessories"),
            new Product(101, "Book", "Education"),
            new Product(103, "Phone", "Electronics"),
            new Product(106, "Jacket", "Fashion"),
            new Product(107, "Tablet", "Electronics")
        };

        Scanner sc = new Scanner(System.in);
        System.out.println("Search by:");
        System.out.println("1. Product ID");
        System.out.println("2. Product Name");
        System.out.println("3. Product Category");
        System.out.print("Enter choice (1-3): ");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter Product ID: ");
                int id = sc.nextInt();

                System.out.println("\nLinear Search by ID:");
                Product result1 = LinearSearch.searchById(products, id);
                System.out.println(result1 != null ? result1 : "Product not found.");

                BinarySearch.sortById(products);
                System.out.println("\nBinary Search by ID:");
                Product result2 = BinarySearch.searchById(products, id);
                System.out.println(result2 != null ? result2 : "Product not found.");
                break;

            case 2:
                System.out.print("Enter Product Name: ");
                String name = sc.nextLine();

                System.out.println("\nLinear Search by Name:");
                Product resultName = LinearSearch.searchByName(products, name);
                System.out.println(resultName != null ? resultName : "Product not found.");

                BinarySearch.sortByName(products);
                System.out.println("\nBinary Search by Name:");
                Product resultNameB = BinarySearch.searchByName(products, name);
                System.out.println(resultNameB != null ? resultNameB : "Product not found.");
                break;

            case 3:
                System.out.print("Enter Product Category: ");
                String category = sc.nextLine();

                System.out.println("\nLinear Search by Category:");
                LinearSearch.searchByCategory(products, category);

                BinarySearch.sortByCategory(products);
                System.out.println("\nBinary Search by Category:");
                BinarySearch.searchByCategory(products, category);
                break;

            default:
                System.out.println("Invalid choice.");
        }

        sc.close();
    }
}
