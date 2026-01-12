public class Veterinarian extends Person {
    private int experienceYears;

    public Veterinarian(String name, String phoneNumber, int experienceYears) {
        super(name, phoneNumber);
        this.experienceYears = experienceYears;
    }

    @Override
    public String getRole() {
        return "Veterinarian";
    }

    @Override
    public String toString() {
        return "Veterinarian{name='" + name + "', experience=" + experienceYears + "}";
    }

    @Override
    public String work() {
        return "Veterinarian treats animals";
    }

}
