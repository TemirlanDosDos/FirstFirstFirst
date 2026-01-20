package model;

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
