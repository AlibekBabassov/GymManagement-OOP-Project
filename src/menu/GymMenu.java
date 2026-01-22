package menu;

import model.*;
import exception.InvalidInputException;
import java.util.ArrayList;
import java.util.Scanner;

public class GymMenu implements Menu {
    private ArrayList<Equipment> allEquipment;
    private ArrayList<GymMember> allMembers;
    private Scanner scanner;

    public GymMenu() {
        this.allEquipment = new ArrayList<>();
        this.allMembers = new ArrayList<>();
        this.scanner = new Scanner(System.in);

        try {
            allEquipment.add(new StrengthEquipment("0001", "Barbel", "Strength", true, 0, 300, true));
            allEquipment.add(new CardioEquipment("0011", "treadmill", "Cardio", true, 0, 20, false));

            allMembers.add(new GymMember("Sunkar", 20, 55, 165, false));
            allMembers.add(new GymMember("Sungat", 21, 70, 180, true));
            allMembers.add(new GymMember("Dastan", 19, 65, 175, false));
        } catch (IllegalArgumentException e) {
            System.out.println("Error initializing test data: " + e.getMessage());
        }
    }

    @Override
    public void displayMenu() {
        System.out.println("\n========================================");
        System.out.println("          GYM MANAGEMENT SYSTEM         ");
        System.out.println("========================================");
        System.out.println("1. Add Strength Equipment");
        System.out.println("2. Add Cardio Equipment");
        System.out.println("3. View All Equipment");
        System.out.println("4. View Strength Equipments Only");
        System.out.println("5. View Cardio Equipments Only");
        System.out.println("6. Get All Equipments type (Polymorphism)");
        System.out.println("7. Add Member");
        System.out.println("8. View All Members");
        System.out.println("9. Train Member");
        System.out.println("0. Exit");
        System.out.println("========================================");
    }

    @Override
    public void run() {
        boolean running = true;

        while (running) {
            displayMenu();
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addStrengthEquipment();
                        break;
                    case 2:
                        addCardioEquipment();
                        break;
                    case 3:
                        viewAllEquipment();
                        break;
                    case 4:
                        viewStrengthEquipments();
                        break;
                    case 5:
                        viewCardioEquipments();
                        break;
                    case 6:
                        demonstratePolymorphism();
                        break;
                    case 7:
                        addMember();
                        break;
                    case 8:
                        viewAllMembers();
                        break;
                    case 9:
                        trainMember();
                        break;
                    case 0:
                        running = false;
                        System.out.println("\nThank you for using Gym Management System!");
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("❌ Invalid choice! Please select 0-9.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("❌ Error: Please enter a valid number!");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }

    private void addStrengthEquipment() {
        try {
            System.out.println("\n--- ADD STRENGTH EQUIPMENT ---");

            System.out.print("Enter equipment ID: ");
            String equipmentId = scanner.nextLine();
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter equipment type: ");
            String equipmentType = scanner.nextLine();
            System.out.print("Enter is available (true/false): ");
            boolean isAvailable = scanner.nextBoolean();
            scanner.nextLine();
            System.out.print("Enter usage count: ");
            int usageCount = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter max weight (kg): ");
            double maxWeightKg = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Enter is adjustable? (true/false): ");
            boolean isAdjustable = scanner.nextBoolean();
            scanner.nextLine();

            StrengthEquipment strengthEquipment = new StrengthEquipment(equipmentId, name, equipmentType, isAvailable, usageCount, maxWeightKg, isAdjustable);
            allEquipment.add(strengthEquipment);
            System.out.println("\n Strength equipment added successfully✅");
        } catch (java.util.InputMismatchException e) {
            System.out.println("❌ Error: Invalid input type!");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Validation Error: " + e.getMessage());
        }
    }
    private void addCardioEquipment() {
        try {
            System.out.println("\n--- ADD CARDIO EQUIPMENT ---");

            System.out.print("Enter equipment ID: ");
            String equipmentId = scanner.nextLine();
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter equipment type: ");
            String equipmentType = scanner.nextLine();
            System.out.print("Enter is available (true/false): ");
            boolean isAvailable = scanner.nextBoolean();
            scanner.nextLine();
            System.out.print("Enter usage count: ");
            int usageCount = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter max Speed (Kph): ");
            double maxSpeedKph = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Enter has heart rate monitor? (true/false): ");
            boolean hasHeartRateMonitor = scanner.nextBoolean();
            scanner.nextLine();

            CardioEquipment cardioEquipment = new CardioEquipment(equipmentId, name, equipmentType, isAvailable, usageCount, maxSpeedKph, hasHeartRateMonitor);
            allEquipment.add(cardioEquipment);
            System.out.println("\n Cardio equipment added successfully✅");
        } catch (java.util.InputMismatchException e) {
            System.out.println("❌ Error: Invalid input type!");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Validation Error: " + e.getMessage());
        }
    }
    private void viewAllEquipment() {
        System.out.println("\n========================================");
        System.out.println("              ALL EQUIPMENT             ");
        System.out.println("========================================");
        if (allEquipment.isEmpty()) {
            System.out.println("No equipment found.");
            return;
        }

        for (int i = 0; i < allEquipment.size(); i++) {
            Equipment e = allEquipment.get(i);
            System.out.println((i + 1) + ". " );

            if (e instanceof StrengthEquipment) {
                System.out.print("[STRENGTH EQUIPMENT] ");
                StrengthEquipment strengthEquipment = (StrengthEquipment) e;
                if (strengthEquipment.isHeavyDuty()) {
                    System.out.println(" It can handle heavy weight!");
                }
            } else if (e instanceof CardioEquipment) {
                System.out.print("[CARDIO EQUIPMENT] ");
                CardioEquipment cardioEquipment = (CardioEquipment) e; // Downcast
                if (cardioEquipment.isFastEquipment()) {
                    System.out.println(" Really fast equipment!");
                }
            }
            System.out.println(e.toString());
        }
    }
    private void viewStrengthEquipments() {
        System.out.println("\n========================================");
        System.out.println("         STRENGTH EQUIPMENT ONLY        ");
        System.out.println("========================================");
        boolean foundStrengthEquipment = false;

        for (Equipment s : allEquipment) {
            if (s instanceof StrengthEquipment) {
                StrengthEquipment strengthEquipment = (StrengthEquipment) s;
                System.out.println(strengthEquipment.toString());
                System.out.println(" Equipment type: " + strengthEquipment.getEquipmentType());
                System.out.println(" Nax weight (kg): " + strengthEquipment.getMaxWeightKg() + " kg");
                if (strengthEquipment.isHeavyDuty()) {
                    System.out.println(" It can handle heavy weight!");
                }
                System.out.println();
                foundStrengthEquipment= true;
            }
        }

        if (!foundStrengthEquipment) {
            System.out.println("No Strength Equipments found.");
        }
    }
    private void viewCardioEquipments() {
        System.out.println("\n========================================");
        System.out.println("           CARDIO EQUIPMENT ONLY        ");
        System.out.println("========================================");
        boolean foundCardioEquipment = false;
        for (Equipment s : allEquipment) {
            if (s instanceof CardioEquipment) {
                CardioEquipment cardioEquipment = (CardioEquipment) s;
                System.out.println(cardioEquipment.toString());
                System.out.println(" Equipment type: " + cardioEquipment.getEquipmentType());
                System.out.println(" Nax max speed (kph): " + cardioEquipment.getMaxSpeedKph() + " kph");
                if (cardioEquipment.isFastEquipment()) {
                    System.out.println(" Really fast equipment!");
                }
                System.out.println();
                foundCardioEquipment= true;
            }
        }

        if (!foundCardioEquipment) {
            System.out.println("No Cardio Equipments found.");
        }
    }
    private void demonstratePolymorphism() {
        System.out.println("\n========================================");
        System.out.println("   POLYMORPHISM: All EQUIPMENTS STARTING");
        System.out.println("========================================");

        if (allEquipment.isEmpty()) {
            System.out.println("No equipments to demonstrate.");
            return;
        }

        for (Equipment e : allEquipment) {
            e.start();
        }

        System.out.println("\n✅ As you can see, same method (start()) but different behavior!");
        System.out.println("This is POLYMORPHISM in action!");
    }
    private void addMember() {
        try {
            System.out.println("\n--- ADD MEMBER ---");

            System.out.print("Enter member name: ");
            String name = scanner.nextLine();
            System.out.print("Enter age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter weight(Kg): ");
            double weightKg = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Enter height: ");
            double heightMeters = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Is membership active? (true/false): ");
            boolean membershipActive = scanner.nextBoolean();
            scanner.nextLine();

            GymMember item = new GymMember(name, age, weightKg, heightMeters, membershipActive);

            allMembers.add(item);
            System.out.println("\nMember added successfully! ✅");
        }catch (java.util.InputMismatchException e) {
            System.out.println("❌ Error: Invalid input type!");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Validation Error: " + e.getMessage());
        }
    }
    private void viewAllMembers() {
        System.out.println("\n========================================");
        System.out.println("                ALL MEMBERS             ");
        System.out.println("========================================");
        if (allMembers.isEmpty()) {
            System.out.println("No members found.");
            return;
        }

        for (int i = 0; i < allMembers.size(); i++) {
            System.out.println((i + 1) + ". " + allMembers.get(i).toString());
        }
    }
    private void trainMember() {
        System.out.println("\n--- Train Member ---");

        if (allMembers.isEmpty()) {
            System.out.println("❌ No member available to train!");
            return;
        }

        System.out.println("Available members:");
        for (int i = 0; i < allMembers.size(); i++) {
            System.out.println((i + 1) + ". " + allMembers.get(i).getName());
        }

        try {
            System.out.print("Select member number to train: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice < 1 || choice > allMembers.size()) {
                throw new InvalidInputException("Invalid member number!");
            }

            GymMember item = allMembers.get(choice - 1);
            item.train();
            System.out.println(item.getTrainingPlan());

        } catch (java.util.InputMismatchException e) {
            System.out.println("❌ Error: Please enter a valid number!");
            scanner.nextLine();
        } catch (InvalidInputException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}




