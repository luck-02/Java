package model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        items.add(product);
    }

    public double getTotalPrice() {
        return items.stream().mapToDouble(Product::getPrice).sum();
    }

    public int getItemCount() {
        return items.size();
    }

    public void clearCart() {
        items.clear();
    }
}

// javac -cp lib/junit-platform-console-standalone-1.10.0.jar -d bin src/model/*.java test/model/*.java
// java -jar lib/junit-platform-console-standalone-1.10.0.jar -cp bin -c model.ShoppingCartTest