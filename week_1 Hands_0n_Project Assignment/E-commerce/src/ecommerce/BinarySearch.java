package ecommerce;

import java.util.Arrays;
import java.util.Comparator;

public class BinarySearch {

    public static void sortById(Product[] products) {
        Arrays.sort(products, Comparator.comparingInt(Product::getProductId));
    }

    public static Product searchById(Product[] products, int id) {
        int low = 0, high = products.length - 1;
        int comparisons = 0;

        while (low <= high) {
            comparisons++;
            int mid = (low + high) / 2;
            int midId = products[mid].getProductId();

            if (midId == id) {
                System.out.println("Binary Search Comparisons (ID): " + comparisons);
                return products[mid];
            } else if (midId < id) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("Binary Search Comparisons (ID): " + comparisons);
        return null;
    }

    public static void sortByName(Product[] products) {
        Arrays.sort(products, Comparator.comparing(Product::getProductName));
    }

    public static Product searchByName(Product[] products, String name) {
        int low = 0, high = products.length - 1;
        int comparisons = 0;

        while (low <= high) {
            comparisons++;
            int mid = (low + high) / 2;
            int compare = products[mid].getProductName().compareToIgnoreCase(name);

            if (compare == 0) {
                System.out.println("Binary Search Comparisons (Name): " + comparisons);
                return products[mid];
            } else if (compare < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("Binary Search Comparisons (Name): " + comparisons);
        return null;
    }

    public static void sortByCategory(Product[] products) {
        Arrays.sort(products, Comparator.comparing(Product::getCategory));
    }

    public static void searchByCategory(Product[] products, String category) {
        // Binary search to find **one** matching element
        int low = 0, high = products.length - 1;
        int comparisons = 0;
        boolean found = false;

        while (low <= high) {
            comparisons++;
            int mid = (low + high) / 2;
            int compare = products[mid].getCategory().compareToIgnoreCase(category);

            if (compare == 0) {
                // Found one match, now expand around it
                found = true;
                System.out.println(products[mid]);

                // Check previous entries
                int i = mid - 1;
                while (i >= 0 && products[i].getCategory().equalsIgnoreCase(category)) {
                    System.out.println(products[i]);
                    i--;
                }

                // Check next entries
                int j = mid + 1;
                while (j < products.length && products[j].getCategory().equalsIgnoreCase(category)) {
                    System.out.println(products[j]);
                    j++;
                }

                break;
            } else if (compare < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (!found) {
            System.out.println("No products found in this category.");
        }

        System.out.println("Binary Search Comparisons (Category): " + comparisons);
    }
}
