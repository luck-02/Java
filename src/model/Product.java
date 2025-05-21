package model;

public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// javac -cp lib/junit-platform-console-standalone-1.10.0.jar -d bin src/model/*.java test/model/*.java
// java -jar lib/junit-platform-console-standalone-1.10.0.jar -cp bin -c model.ProductTest