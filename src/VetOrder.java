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


    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Veterinarian getVeterinarian() {
        return veterinarian;
    }

    public void setVeterinarian(Veterinarian veterinarian) {
        this.veterinarian = veterinarian;
    }

    public Vaccination getVaccination() {
        return vaccination;
    }

    public void setVaccination(Vaccination vaccination) {
        this.vaccination = vaccination;
    }

    public List<Treatment> getTreatments() {
        return treatments;
    }

    public void setTreatments(List<Treatment> treatments) {
        this.treatments = treatments;
    }

    // 🔹 вычисление общей стоимости
    public double getTotalPrice() {
        double total = 0;
        for (Treatment treatment : treatments) {
            total += treatment.getPrice();
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
