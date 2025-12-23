public class Veterinarian {
    private String name;
    private String phoneNumber;
    private int experienceYears;

    public Veterinarian(String name, String phoneNumber, int experienceYears) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.experienceYears = experienceYears;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    @Override
    public String toString() {
        return "Veterinarian{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", experienceYears=" + experienceYears +
                '}';
    }
}
