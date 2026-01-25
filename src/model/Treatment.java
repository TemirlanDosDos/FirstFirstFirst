package model;

public class Treatment {

    private String name;
    private double price;

    public Treatment(String name, double price) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Treatment name cannot be empty");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}
