import java.util.ArrayList;
import java.util.List;

public class VetOrder {
    private Owner owner;
    private Pet pet;
    private Veterinarian veterinarian;
    private Vaccination vaccination;
    private List<Treatment> treatments = new ArrayList<>();

    public VetOrder(Owner owner, Pet pet, Veterinarian veterinarian, Vaccination vaccination) {
        this.owner = owner;
        this.pet = pet;
        this.veterinarian = veterinarian;
        this.vaccination = vaccination;
    }

    public List<Treatment> getTreatments() {
        return treatments;
    }

    public double getTotalPrice() {
        double total = 0;
        for (Treatment t : treatments) {
            total += t.getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        return "VetOrder{" +
                "\nOwner=" + owner +
                ",\nPet=" + pet +
                ",\nVeterinarian=" + veterinarian +
                ",\nVaccination=" + vaccination +
                ",\nTreatments=" + treatments +
                ",\nTotal price=" + getTotalPrice() +
                "\n}";
    }
}
