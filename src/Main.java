import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Person> people = new ArrayList<>();
    private static ArrayList<VetOrder> orders = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("""
                    1 Add Owner
                    2 Add Veterinarian
                    3 View People
                    4 Create Order
                    5 View Orders
                    0 Exit
                    """);

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addOwner();
                case 2 -> addVeterinarian();
                case 3 -> viewPeople();
                case 4 -> createOrder();
                case 5 -> viewOrders();
                case 0 -> running = false;
            }
        }
    }

    private static void addOwner() {
        System.out.print("ID: ");
        long id = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        System.out.print("Address: ");
        String address = scanner.nextLine();

        people.add(new Owner(id, name, phone, address));
        System.out.println("Owner added");
    }

    private static void addVeterinarian() {
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

    private static void viewPeople() {
        if (people.isEmpty()) {
            System.out.println("No people found");
            return;
        }

        for (int i = 0; i < people.size(); i++) {
            System.out.println(i + ": " + people.get(i));
            System.out.println("   " + people.get(i).work());
        }
    }

    private static void createOrder() {
        if (people.isEmpty()) {
            System.out.println("Add people first");
            return;
        }

        viewPeople();
        System.out.print("Choose person index: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index < 0 || index >= people.size()) {
            System.out.println("Invalid index");
            return;
        }

        System.out.print("Pet name: ");
        String petName = scanner.nextLine();

        System.out.print("Pet age: ");
        int petAge = scanner.nextInt();
        scanner.nextLine();

        Pet pet = new Pet(petName, petAge);
        VetOrder order = new VetOrder(people.get(index), pet);

        boolean adding = true;
        while (adding) {
            System.out.print("Treatment name (or 'stop'): ");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("stop")) {
                adding = false;
            } else {
                System.out.print("Price: ");
                double price = scanner.nextDouble();
                scanner.nextLine();
                order.addTreatment(new Treatment(name, price));
            }
        }

        order.showPersonType();
        orders.add(order);

        System.out.println("Order created successfully");
    }

    private static void viewOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders found");
            return;
        }

        for (VetOrder o : orders) {
            System.out.println(o);
        }
    }
}
