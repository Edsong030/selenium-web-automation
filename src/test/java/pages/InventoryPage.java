// InventoryPage.java

package pages;

import java.util.List;
import java.util.ArrayList;

public class InventoryPage {
    private List<String> products;
    private List<String> cart;

    public InventoryPage() {
        products = new ArrayList<>();
        cart = new ArrayList<>();
        initializeProducts();
    }

    private void initializeProducts() {
        products.add("Product 1");
        products.add("Product 2");
        products.add("Product 3");
    }

    public List<String> getProducts() {
        return products;
    }

    public void addToCart(String product) {
        if (products.contains(product)) {
            cart.add(product);
        }
    }

    public List<String> getCart() {
        return cart;
    }

    public void removeFromCart(String product) {
        cart.remove(product);
    }
}