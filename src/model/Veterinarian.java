package model;

public class Veterinarian extends Person {

    private int experienceYears;

    public Veterinarian(String name, String phoneNumber, int experienceYears) {
        super(name, phoneNumber);
        setExperienceYears(experienceYears);
    }

    public void setExperienceYears(int experienceYears) {
        if (experienceYears < 0) {
            throw new IllegalArgumentException("Experience cannot be negative");
        }
        this.experienceYears = experienceYears;
    }

    @Override
    public String getRole() {
        return "Veterinarian";
    }

    @Override
    public String work() {
        return "Veterinarian treats animals";
    }

    @Override
    public String toString() {
        return "Veterinarian{name='" + name + "', experience=" + experienceYears + "}";
    }
}
