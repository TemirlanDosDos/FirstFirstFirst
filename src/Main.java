public class Main {
    public static void main(String[] args) {

        Owner owner = new Owner(1456453L, "Temirlan", "777777", "EXPO");
        Pet pet = new Pet("Ross", 3, "Dog", "Male", "Temperature");
        Veterinarian vet = new Veterinarian("Birzhan Rukhanov", "666666", 10);
        Vaccination vaccination = new Vaccination("Calicivirus", "Rabies", 2025, 2027);
        Treatment t1 = new Treatment("Paracetamol", 3000, 2028);
        Treatment t2 = new Treatment("Antibiotic", 4500, 2027);

        VetOrder vetOrder1 = new VetOrder(owner, pet, vet, vaccination);
        vetOrder1.getTreatments().add(t1);
        vetOrder1.getTreatments().add(t2);

        System.out.println(vetOrder1);
    }
}
