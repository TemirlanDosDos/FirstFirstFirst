
public class vaccination {
    private String vaccineName;
    private String disease;
    private int vaccinationYear;
    private int validUntilYear;

    public vaccination(String vaccineName, String disease, int vaccinationYear, int validUntilYear) {
        this.vaccineName = vaccineName;
        this.disease = disease;
        this.vaccinationYear = vaccinationYear;
        this.validUntilYear = validUntilYear;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public int getVaccinationYear() {
        return vaccinationYear;
    }

    public void setVaccinationYear(int vaccinationYear) {
        this.vaccinationYear = vaccinationYear;
    }

    public int getValidUntilYear() {
        return validUntilYear;
    }

    public void setValidUntilYear(int validUntilYear) {
        this.validUntilYear = validUntilYear;
    }

    @Override
    public String toString() {
        return "vaccination{" +
                "vaccineName='" + vaccineName + '\'' +
                ", disease='" + disease + '\'' +
                ", vaccinationYear=" + vaccinationYear +
                ", validUntilYear=" + validUntilYear +
                '}';
    }
}
