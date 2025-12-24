import java.util.ArrayList;
import java.util.List;

public class Appointment {
    private Owner owner;
    private Pet pet;
    private Veterinarian veterinarian;
    private Vaccination vaccination;
    private List<Treatment> treatments = new ArrayList<>();
    private boolean confirmed;

    public Appointment(Owner owner, Pet pet, Veterinarian veterinarian,
                       Vaccination vaccination, boolean confirmed) {
        this.owner = owner;
        this.pet = pet;
        this.veterinarian = veterinarian;
        this.vaccination = vaccination;
        this.confirmed = confirmed;
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

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "owner=" + owner +
                ", pet=" + pet +
                ", veterinarian=" + veterinarian +
                ", vaccination=" + vaccination +
                ", treatments=" + treatments +
                ", confirmed=" + confirmed +
                '}';
    }
}
