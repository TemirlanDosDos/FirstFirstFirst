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
    }

    private static void viewPeople() {
        for (Person p : people) {
            System.out.println(p);
            System.out.println(p.work());

        }
    }

    private static void createOrder() {
        if (people.isEmpty()) return;
        Pet pet = new Pet("Buddy", 3);
        VetOrder order = new VetOrder(people.get(0), pet);
        order.addTreatment(new Treatment("Checkup", 30));
        order.addTreatment(new Treatment("Vaccine", 50));
        order.showPersonType();
        orders.add(order);
    }

    private static void viewOrders() {
        for (VetOrder o : orders) {
            System.out.println(o);
        }
    }
}
