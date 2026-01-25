package menu;

import model.*;

import java.util.ArrayList;
import java.util.Scanner;
import database.VetAllDataDAO;


public class VetClinicMenu implements Menu {

    private static ArrayList<Person> people = new ArrayList<>();
    private static ArrayList<VetOrder> orders = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void displayMenu() {
        System.out.println("""
                1 Add Owner
                2 Add Veterinarian
                3 View People
                4 Create Order
                5 View Orders
                0 Exit
                """);
    }

    @Override
    public void run() {
        boolean running = true;
        while (running) {
            displayMenu();
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {

                    case 1 -> addOwner();

                    case 2 -> addVeterinarian();
                    case 3 -> viewPeople();
                    case 4 -> createOrder();
                    case 5 -> running = false;
                    default -> System.out.println("Invalid choice");
                }
            }
            catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }
    private void addOwner() {
        try {
            System.out.print("Enter Owner ID: ");
            String id = scanner.nextLine();

            System.out.print("Enter Owner Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Owner Phone: ");
            String phone = scanner.nextLine();

            System.out.print("Enter Owner Address: ");
            String address = scanner.nextLine();

            Owner owner = new Owner(id, name, phone, address);
            people.add(owner);


            System.out.println("Owner added & saved to DB ✅");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }



    private void addVeterinarian() {
        try {
            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Phone: ");
            String phone = scanner.nextLine();

            System.out.print("Experience: ");
            int exp = scanner.nextInt();
            scanner.nextLine();

            people.add(new Veterinarian(name, phone, exp));
            System.out.println("Veterinarian added");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine();
        }
    }

    private void viewPeople() {
        if (people.isEmpty()) {
            System.out.println("No people found");
            return;
        }

        for (int i = 0; i < people.size(); i++) {
            System.out.println(i + ": " + people.get(i));
            System.out.println("   " + people.get(i).work());
        }
    }

    private void createOrder() {
        if (people.isEmpty()) {
            System.out.println("Add people first");
            return;
        }

        try {
            viewPeople();
            System.out.print("Choose person index: ");
            int index = scanner.nextInt();
            scanner.nextLine();

            if (!(people.get(index) instanceof Owner owner)) {
                System.out.println("Only Owner can create order");
                return;
            }

            System.out.print("Pet name: ");
            String petName = scanner.nextLine();

            System.out.print("Pet age: ");
            int petAge = scanner.nextInt();
            scanner.nextLine();

            Pet pet = new Pet(petName, petAge);
            VetOrder order = new VetOrder(owner, pet);

            Treatment treatment = null;

            while (true) {
                System.out.print("Treatment name (or stop): ");
                String name = scanner.nextLine();
                if (name.equalsIgnoreCase("stop")) break;

                System.out.print("Price: ");
                double price = scanner.nextDouble();
                scanner.nextLine();

                treatment = new Treatment(name, price);
                order.addTreatment(treatment);
            }


            Veterinarian vet = new Veterinarian("Default Vet", "000000", 5);
            Vaccination vaccination = new Vaccination(
                    "Rabies",
                    "Rabies",
                    2024,
                    2026
            );

            new VetAllDataDAO().insertAllData(
                    owner,
                    vet,
                    pet,
                    treatment,
                    vaccination,
                    order
            );

            orders.add(order);
            System.out.println("Order created & saved to DB ✅");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine();
        }
    }


    private void viewOrders() {
        for (VetOrder order : orders) {
            System.out.println(order);
        }
    }
}