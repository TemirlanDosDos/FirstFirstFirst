import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Owner> owners = new ArrayList<>();
    private static ArrayList<Pet> pets = new ArrayList<>();
    private static ArrayList<Veterinarian> veterinarians = new ArrayList<>();
    private static ArrayList<VetOrder> vetOrders = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean running = true;

        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addOwner();
                case 2 -> viewOwners();
                case 3 -> addPet();
                case 4 -> viewPets();
                case 5 -> addVeterinarian();
                case 6 -> viewVeterinarians();
                case 7 -> addVetOrder();
                case 8 -> viewVetOrders();
                case 0 -> {
                    System.out.println("Goodbye 👋");
                    running = false;
                }
                default -> System.out.println("Invalid choice ❌");
            }

            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("""
                ==============================
                🐾 VET CLINIC SYSTEM
                ==============================
                1. Add Owner
                2. View Owners
                3. Add Pet
                4. View Pets
                5. Add Veterinarian
                6. View Veterinarians
                7. Create Vet Order
                8. View Vet Orders
                0. Exit
                ==============================
                Enter choice:
                """);
    }


    private static void addOwner() {
        System.out.print("Enter ID: ");
        long id = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();

        System.out.print("Enter address: ");
        String address = scanner.nextLine();

        owners.add(new Owner(id, name, phone, address));
        System.out.println("Owner added ✅");
    }

    private static void viewOwners() {
        if (owners.isEmpty()) {
            System.out.println("No owners found");
            return;
        }
        owners.forEach(System.out::println);
    }

    private static void addPet() {
        System.out.print("Nickname: ");
        String nick = scanner.nextLine();

        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Type: ");
        String type = scanner.nextLine();

        System.out.print("Sex: ");
        String sex = scanner.nextLine();

        System.out.print("Symptom: ");
        String symptom = scanner.nextLine();

        pets.add(new Pet(nick, age, type, sex, symptom));
        System.out.println("Pet added ✅");
    }

    private static void viewPets() {
        if (pets.isEmpty()) {
            System.out.println("No pets found");
            return;
        }
        pets.forEach(System.out::println);
    }

    private static void addVeterinarian() {
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        System.out.print("Experience years: ");
        int exp = scanner.nextInt();
        scanner.nextLine();

        veterinarians.add(new Veterinarian(name, phone, exp));
        System.out.println("Veterinarian added ✅");
    }

    private static void viewVeterinarians() {
        if (veterinarians.isEmpty()) {
            System.out.println("No vets found");
            return;
        }
        veterinarians.forEach(System.out::println);
    }

    private static void addVetOrder() {
        if (owners.isEmpty() || pets.isEmpty() || veterinarians.isEmpty()) {
            System.out.println("Not enough data to create order ❌");
            return;
        }

        VetOrder order = new VetOrder(
                owners.get(0),
                pets.get(0),
                veterinarians.get(0),
                null
        );

        vetOrders.add(order);
        System.out.println("Vet order created ✅");
    }

    private static void viewVetOrders() {
        if (vetOrders.isEmpty()) {
            System.out.println("No orders");
            return;
        }
        vetOrders.forEach(System.out::println);
    }
}
