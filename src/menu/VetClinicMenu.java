package menu;

import database.VetAllDataDAO;
import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class VetClinicMenu implements Menu {

    private static ArrayList<Person> people = new ArrayList<>();
    private static ArrayList<VetOrder> orders = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static VetAllDataDAO dao = new VetAllDataDAO();

    @Override
    public void displayMenu() {
        System.out.println("""
                ===== VET CLINIC MENU =====
                1. Add Owner
                2. Add Veterinarian
                3. View People
                4. Create Order
                5. View Orders
                6. Update Owner
                7. Delete Owner
                8. Search Owner by Name
                9. Search Orders by Price Range
                10. Search Orders by Min Price
                0. Exit
                ==========================
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
                    case 5 -> viewOrders();
                    case 6 -> updateOwner();
                    case 7 -> deleteOwner();
                    case 8 -> searchOwnerByName();
                    case 9 -> searchByPriceRange();
                    case 10 -> searchByMinPrice();
                    case 0 -> running = false;
                    default -> System.out.println("Invalid choice");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }

    private void addOwner() {
        try {
            System.out.print("Owner ID: ");
            String id = scanner.nextLine();

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Phone: ");
            String phone = scanner.nextLine();

            System.out.print("Address: ");
            String address = scanner.nextLine();

            Owner owner = new Owner(id, name, phone, address);
            people.add(owner);

            System.out.println("Owner added");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void addVeterinarian() {
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        System.out.print("Experience: ");
        int exp = scanner.nextInt();
        scanner.nextLine();

        people.add(new Veterinarian(name, phone, exp));
        System.out.println("Veterinarian added");
    }

    private void viewPeople() {
        if (people.isEmpty()) {
            System.out.println("No people found");
            return;
        }

        for (Person p : people) {
            System.out.println(p);
            System.out.println(p.work());
        }
    }

    private void createOrder() {

        if (people.isEmpty()) {
            System.out.println("Add people first");
            return;
        }

        viewPeople();
        System.out.print("Choose index: ");
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

        System.out.print("Treatment name: ");
        String tName = scanner.nextLine();

        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Treatment treatment = new Treatment(tName, price);
        order.addTreatment(treatment);

        Veterinarian vet = new Veterinarian("Default Vet", "000", 5);
        Vaccination vaccination = new Vaccination("Rabies", "Rabies", 2024, 2026);

        dao.insertAllData(owner, vet, pet, treatment, vaccination, order);
        orders.add(order);

        System.out.println("Order created");
    }

    private void viewOrders() {
        for (VetOrder o : orders) {
            System.out.println(o);
        }
    }

    private void updateOwner() {
        System.out.print("Owner ID: ");
        long id = scanner.nextLong();
        scanner.nextLine();

        System.out.print("New name: ");
        String name = scanner.nextLine();

        System.out.print("New phone: ");
        String phone = scanner.nextLine();

        System.out.print("New address: ");
        String address = scanner.nextLine();

        if (dao.updateOwner(id, name, phone, address))
            System.out.println("Updated");
        else
            System.out.println("Not found");
    }

    private void deleteOwner() {
        System.out.print("Owner ID: ");
        long id = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Are you sure? (yes/no): ");
        String confirm = scanner.nextLine();

        if (!confirm.equalsIgnoreCase("yes")) {
            System.out.println("Cancelled");
            return;
        }

        if (dao.deleteByOwnerId(id))
            System.out.println("Deleted");
        else
            System.out.println("Not found");
    }

    private void searchOwnerByName() {
        System.out.print("Name: ");
        dao.searchByOwnerName(scanner.nextLine());
    }

    private void searchByPriceRange() {
        System.out.print("Min price: ");
        double min = scanner.nextDouble();

        System.out.print("Max price: ");
        double max = scanner.nextDouble();
        scanner.nextLine();

        dao.searchByPriceRange(min, max);
    }

    private void searchByMinPrice() {
        System.out.print("Min price: ");
        dao.searchByMinPrice(scanner.nextDouble());
        scanner.nextLine();
    }
}
