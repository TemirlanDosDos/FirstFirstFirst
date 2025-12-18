import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {

        ArrayList<owner> owner = new ArrayList<>();

        pet pet1 = new pet("Ross", 3, "dog", "male", "temperature");
        owner owner1 = new owner(1456453, "Temirlan", "777777", "EXPO");

        veterenarian vet = new veterenarian("Birzhan Rukhanov", "666666", 10);


        treatment treatment = new treatment("Paracetamol", 3000, 2028);
        vaccination vaccination = new vaccination("Calicivirus", "Rabies" , 2025 ,2027);


        appointment appointment = new appointment(pet1, vet, true);

        owner.add(owner1);

        System.out.println(owner1);
        System.out.println(vet);
        System.out.println(treatment);
        System.out.println(vaccination);
        System.out.println(appointment);
    }

}