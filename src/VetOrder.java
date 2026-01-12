import java.util.ArrayList;

public class VetOrder {
    private Person person;
    private Pet pet;
    private ArrayList<Treatment> treatments = new ArrayList<>();

    public VetOrder(Person person, Pet pet) {
        this.person = person;
        this.pet = pet;
    }

    public void addTreatment(Treatment treatment) {
        treatments.add(treatment);
    }

    public double getTotalPrice() {
        double total = 0;
        for (Treatment t : treatments) {
            total += t.getPrice();
        }
        return total;
    }

    public void showPersonType() {
        if (person instanceof Owner) {
            System.out.println("Order owner is Owner");
        } else if (person instanceof Veterinarian) {
            System.out.println("Order handled by Veterinarian");
        }
    }

    @Override
    public String toString() {
        return person + "\n" + pet + "\nTreatments=" + treatments + "\nTotal=" + getTotalPrice();
    }
}
