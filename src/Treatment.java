public class Treatment {
    private String name;
    private double price;

    public Treatment(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + "($" + price + ")";
    }
}
