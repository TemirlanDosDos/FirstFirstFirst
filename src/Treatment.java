public class Treatment {
    private String name;
    private double price;
    private int expiryDate;

    public Treatment(String name, double price, int expiryDate) {
        this.name = name;
        this.price = price;
        this.expiryDate = expiryDate;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return "Treatment{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", expiryDate=" + expiryDate +
                '}';
    }
}
