package model;

public class Vaccination {

    private String vaccineName;
    private String disease;
    private int vaccinationYear;
    private int validUntilYear;

    public Vaccination(String vaccineName, String disease, int vaccinationYear, int validUntilYear) {
        this.vaccineName = vaccineName;
        this.disease = disease;
        this.vaccinationYear = vaccinationYear;
        this.validUntilYear = validUntilYear;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public String getDisease() {
        return disease;
    }

    public int getVaccinationYear() {
        return vaccinationYear;
    }

    public int getValidUntilYear() {
        return validUntilYear;
    }

    @Override
    public String toString() {
        return "Vaccination{" +
                "vaccineName='" + vaccineName + '\'' +
                ", disease='" + disease + '\'' +
                ", vaccinationYear=" + vaccinationYear +
                ", validUntilYear=" + validUntilYear +
                '}';
    }
}
