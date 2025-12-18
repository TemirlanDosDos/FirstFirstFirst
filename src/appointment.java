
public class appointment {
    private pet pet;
    private veterenarian veterenarian;
    private boolean confirmed;

    public appointment(pet pet, veterenarian veterenarian, boolean confirmed) {
        this.pet = pet;
        this.veterenarian = veterenarian;
        this.confirmed = confirmed;
    }

    public pet getPet() {
        return pet;
    }

    public void setPet(pet pet) {
        this.pet = pet;
    }

    public veterenarian getVeterenarian() {
        return veterenarian;
    }

    public void setVeterenarian(veterenarian veterenarian) {
        this.veterenarian = veterenarian;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    @Override
    public String toString() {
        return "appointment{" +
                "pet=" + pet +
                ", veterenarian=" + veterenarian +
                ", confirmed=" + confirmed +
                '}';
    }
}
