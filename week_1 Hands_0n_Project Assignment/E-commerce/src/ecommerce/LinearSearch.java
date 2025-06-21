package ecommerce;

public class LinearSearch {

    public static Product searchById(Product[] products, int id) {
        int comparisons = 0;
        for (Product p : products) {
            comparisons++;
            if (p.getProductId() == id) {
                System.out.println("Linear Search Comparisons (ID): " + comparisons);
                return p;
            }
        }
        System.out.println("Linear Search Comparisons (ID): " + comparisons);
        return null;
    }

    public static Product searchByName(Product[] products, String name) {
        int comparisons = 0;
        for (Product p : products) {
            comparisons++;
            if (p.getProductName().equalsIgnoreCase(name)) {
                System.out.println("Linear Search Comparisons (Name): " + comparisons);
                return p;
            }
        }
        System.out.println("Linear Search Comparisons (Name): " + comparisons);
        return null;
    }

    public static void searchByCategory(Product[] products, String category) {
        int comparisons = 0;
        boolean found = false;
        for (Product p : products) {
            comparisons++;
            if (p.getCategory().equalsIgnoreCase(category)) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No products found in this category.");
        }
        System.out.println("Linear Search Comparisons (Category): " + comparisons);
    }
}
