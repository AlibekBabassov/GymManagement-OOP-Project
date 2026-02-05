package menu;

import model.*;
import database.*;
import exception.InvalidInputException;
import java.util.List;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class GymMenu implements Menu {
    private Scanner scanner;
    private EquipmentDAO equipmentDAO;


    public GymMenu() {
        this.scanner = new Scanner(System.in);
        this.equipmentDAO = new EquipmentDAO();

        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║  GYM MANAGEMENT SYSTEM v2.0            ║");
        System.out.println("║  Week 8: Fully Database-Driven         ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("✅ All data is stored in PostgreSQL");
        System.out.println("✅ No in-memory ArrayLists");
        System.out.println("✅ Complete CRUD operations");

        try {
            allEquipment.add(new StrengthEquipment("0001", "Barbel", "Strength", true, 0, 300, true));
            allEquipment.add(new CardioEquipment("0011", "treadmill", "Cardio", true, 0, 20, false));

            allMembers.add(new GymMember(1, "Sunkar", 20, 55, 165, false));
            allMembers.add(new GymMember(2, "Sungat", 21, 70, 180, true));
            allMembers.add(new GymMember(3, "Dastan", 19, 65, 175, false));
        } catch (IllegalArgumentException e) {
            System.out.println("Error initializing test data: " + e.getMessage());
        }
    }

    @Override
    public void displayMenu() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║         MAIN MENU - Week 8            ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("┌─ EQUIPMENT MANAGEMENT ─────────────────┐");
        System.out.println("│ 1. Add Strength Equipment              │");
        System.out.println("│ 2. Add Cardio Equipment                │");
        System.out.println("│ 3. View All Equipment                  │");
        System.out.println("│ 4. View Strength Equipment Only        │");
        System.out.println("│ 5. View Cardio Equipment Only          │");
        System.out.println("│ 6. Update Equipment                    │");
        System.out.println("│ 7. Delete Equipment                    │");
        System.out.println("├─ SEARCH & FILTER ──────────────────────┤");
        System.out.println("│ 8. Search by Name                      │");
        System.out.println("│ 9. Search by Usage Count Range         │");
        System.out.println("│10. High-Usage-Count Equipment          │");
        System.out.println("├─ DEMO & OTHER ─────────────────────────┤");
        System.out.println("│11. Polymorphism Demo                   │");
        System.out.println("│ 0. Exit                                │");
        System.out.println("└────────────────────────────────────────┘");
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
                        updateEquipment();
                        break;
                    case 7:
                        deleteEquipment();
                        break;
                    case 8:
                        searchByName();
                        break;
                    case 9:
                        searchByUsageCountRange();
                        break;
                    case 10:
                        searchHighUsageCountEquipment();
                        break;
                    case 11:
                        demonstratePolymorphism();
                        break;
                    case 0:
                        running = false;
                        System.out.println("\n╔════════════════════════════════════════╗");
                        System.out.println("║  Thank you for using our system!      ║");
                        System.out.println("║  Goodbye! 👋                          ║");
                        System.out.println("╚════════════════════════════════════════╝");
                        break;
                    default:
                        System.out.println("❌ Invalid choice! Please select 0-11.");
                }

                if (choice != 0) {
                    pressEnterToContinue();
                }

            } catch (java.util.InputMismatchException e) {
                System.out.println("❌ Error: Please enter a valid number!");
                scanner.nextLine();
                pressEnterToContinue();
            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage());
                scanner.nextLine();
                pressEnterToContinue();
            }
        }

        scanner.close();
    }

    private void addStrengthEquipment() {
        try {
            System.out.println("\n--- ADD STRENGTH EQUIPMENT ---");

            System.out.print("Enter equipment ID: ");
            int equipmentId = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
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

            StrengthEquipment strengthEquipment = new StrengthEquipment(equipmentId, name, isAvailable, usageCount, maxWeightKg, isAdjustable);
            equipmentDAO.insertStrengthEquipment(strengthEquipment);
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
            int equipmentId = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
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

            CardioEquipment cardioEquipment = new CardioEquipment(equipmentId, name, isAvailable, usageCount, maxSpeedKph, hasHeartRateMonitor);
            equipmentDAO.insertCardioEquipment(cardioEquipment);
            System.out.println("\n Cardio equipment added successfully✅");
        } catch(java.util.InputMismatchException e){
            System.out.println("Invalid type of Input");
            scanner.nextLine();
        } catch(IllegalArgumentException e){
            System.out.println("Invalid input" + e.getMessage());
        }
    }
    private void viewAllEquipment() {
        equipmentDAO.displayAllEquipment();
    }
    private void viewStrengthEquipments() {
        List<StrengthEquipment> strengthEquipments = equipmentDAO.getAllStrengthEquipment();

        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║         STRENGTH EQUIPMENT ONLY       ║");
        System.out.println("╚════════════════════════════════════════╝");

        if (strengthEquipments.isEmpty()) {
            System.out.println("📭 No strength equipments in database.");
        } else {
            for (int i = 0; i < strengthEquipments.size(); i++) {
                StrengthEquipment strengthEquipment = strengthEquipments.get(i);
                System.out.println((i + 1) + ". " + strengthEquipment.toString());
                System.out.println("   Max weight kg: " + strengthEquipment.getMaxWeightKg());
                if (strengthEquipment.isAdjustable()) {
                    System.out.println("   Adjustable!");
                }
                System.out.println();
            }
            System.out.println("Total Strength equipments: " + strengthEquipments.size());
        }
    }
    private void viewCardioEquipments() {
        List<CardioEquipment> cardioEquipments= equipmentDAO.getAllCardioEquipment();

        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║         CARDIO EQUIPMENT ONLY         ║");
        System.out.println("╚════════════════════════════════════════╝");

        if (cardioEquipments.isEmpty()) {
            System.out.println("📭 No cardio equipments in database.");
        } else {
            for (int i = 0; i < cardioEquipments.size(); i++) {
                CardioEquipment cardioEquipment = cardioEquipments.get(i);
                System.out.println((i + 1) + ". " + cardioEquipment.toString());
                System.out.println("   Max speed kph: " + cardioEquipment.getMaxSpeedKph());
                if (cardioEquipment.isHasHeartRateMonitor()) {
                    System.out.println("   It has heart rate monitor!");
                }
                System.out.println();
            }
            System.out.println("Total Cardio equipments: " + cardioEquipments.size());
        }
    }

    private void updateEquipment() {
        System.out.println("\n┌─ UPDATE EQUIPMENT ─────────────────────────┐");
        System.out.print("│ Enter Equipment ID to update: ");

        try {
            int equipmentId = scanner.nextInt();
            scanner.nextLine();

            Equipment existingEquipment = equipmentDAO.getEquipmentById(equipmentId);
        for (Equipment e : allEquipment) {
            e.start();
        }

        System.out.println("\n✅ As you can see, same method (start()) but different behavior!");
        System.out.println("This is POLYMORPHISM in action!");
    }
    private void addMember(){
        try {
            System.out.println("\n--- ADD MEMBER ---");

            System.out.print("Enter memberID: ");
            int memberID = scanner.nextInt();
            scanner.nextLine();
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

            GymMember item = new GymMember(memberID, name, age, weightKg, heightMeters, membershipActive);

            if (existingEquipment == null) {
                System.out.println("❌ No equipment found with ID: " + equipmentId);
                return;
            }

            System.out.println("│ Current Info:");
            System.out.println("│ " + existingEquipment.toString());
            System.out.println("└────────────────────────────────────────┘");

            System.out.println("\n┌─ ENTER NEW VALUES ─────────────────────┐");
            System.out.println("│ (Press Enter to keep current value)   │");

            System.out.print("│ New Name [" + existingEquipment.getName() + "]: ");
            String newName = scanner.nextLine();
            if (newName.trim().isEmpty()) {
                newName = existingEquipment.getName();
            }

            System.out.print("│ New Available [" + existingEquipment.isAvailable() + "]: ");
            String availableInput = scanner.nextLine();
            Boolean newAvailable = availableInput.trim().isEmpty() ?
                    existingEquipment.isAvailable() : Boolean.parseBoolean(availableInput);

            System.out.print("│ New Usage count [" + existingEquipment.getUsageCount() + "]: ");
            String usageInput = scanner.nextLine();
            int newUsageCount = usageInput.trim().isEmpty() ?
                    existingEquipment.getUsageCount() : Integer.parseInt(usageInput);

            if (existingEquipment instanceof StrengthEquipment) {
                StrengthEquipment strengthEquipment = (StrengthEquipment) existingEquipment;
                System.out.print("│ New Max weight kg [" + strengthEquipment.getMaxWeightKg() + "]: ");
                String maxWeightInput = scanner.nextLine();
                double newMaxWeight = maxWeightInput.trim().isEmpty() ?
                        strengthEquipment.getMaxWeightKg() : Double.parseDouble(maxWeightInput);
                String adjustableInput = scanner.nextLine();
                boolean newAdjustable = adjustableInput.trim().isEmpty() ?
                        strengthEquipment.isAdjustable() : Boolean.parseBoolean(adjustableInput);

                StrengthEquipment updatedStrengthEquipment = new StrengthEquipment(equipmentId, newName, newAvailable, newUsageCount, newMaxWeight, newAdjustable);
                equipmentDAO.updateStrengthEquipment(updatedStrengthEquipment);

            } else if (existingEquipment instanceof CardioEquipment) {
                CardioEquipment cardioEquipment = (CardioEquipment) existingEquipment;
                System.out.print("│ New Max speed kph [" + cardioEquipment.getMaxSpeedKph() + "]: ");
                String maxSpeedInput = scanner.nextLine();
                double newMaxSpeed = maxSpeedInput.trim().isEmpty() ?
                        cardioEquipment.getMaxSpeedKph() : Double.parseDouble(maxSpeedInput);
                String hasHeartRateMonitorInput = scanner.nextLine();
                boolean newHasHeartRateMonitor = hasHeartRateMonitorInput.trim().isEmpty() ?
                        cardioEquipment.isHasHeartRateMonitor() : Boolean.parseBoolean(hasHeartRateMonitorInput);

                CardioEquipment updatedCardioEquipment = new CardioEquipment(equipmentId, newName, newAvailable, newUsageCount, newMaxSpeed, newHasHeartRateMonitor);
                equipmentDAO.updateCardioEquipment(updatedCardioEquipment);
            }

            System.out.println("└────────────────────────────────────────┘");

        } catch (NumberFormatException e) {
            System.out.println("❌ Error: Invalid number format!");
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Validation Error: " + e.getMessage());
        }
    }
    private void deleteEquipment() {
        System.out.println("\n┌─ DELETE EQUIPMENT ─────────────────────────┐");
        System.out.print("│ Enter Equipment ID to delete: ");

        try {
            int equipmentId = scanner.nextInt();
            scanner.nextLine();

            Equipment equipment = equipmentDAO.getEquipmentById(equipmentId);
    private void viewAllMembers(){
        System.out.println("\n========================================");
        System.out.println("                ALL MEMBERS             ");
        System.out.println("========================================");
        if (allMembers.isEmpty()) {
            System.out.println("No members found.");
            return;
        }

            if (equipment == null) {
                System.out.println("❌ No equipment found with ID: " + equipmentId);
                return;
            }

            System.out.println("│ Equipment to delete:");
            System.out.println("│ " + equipment.toString());
            System.out.println("└────────────────────────────────────────┘");

            System.out.print("⚠️  Are you sure? (yes/no): ");
            String confirmation = scanner.nextLine();

            if (confirmation.equalsIgnoreCase("yes")) {
                equipmentDAO.deleteEquipment(equipmentId);
            } else {
                System.out.println("❌ Deletion cancelled.");
            }

        } catch (java.util.InputMismatchException e) {
            System.out.println("❌ Error: Invalid input!");
            scanner.nextLine();
        }
    }
    private void searchByName() {
        System.out.println("\n┌─ SEARCH BY NAME ───────────────────────┐");
        System.out.print("│ Enter name to search: ");
        String name = scanner.nextLine();
        System.out.println("└────────────────────────────────────────┘");

        List<Equipment> results = equipmentDAO.searchByName(name);

        displaySearchResults(results, "Search: '" + name + "'");
    }
    private void searchByUsageCountRange() {
        try {
            System.out.println("\n┌─ SEARCH BY USAGE COUNT RANGE ───────────────┐");
            System.out.print("│ Enter minimum usage count: ");
            double minUsageCount = scanner.nextDouble();

            System.out.print("│ Enter maximum usage count: ");
            double maxUsageCount = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("└────────────────────────────────────────┘");

            List<Equipment> results = equipmentDAO.searchByUsageCountRange(minUsageCount, maxUsageCount);

            displaySearchResults(results, "Usage count: " + minUsageCount + " - " + maxUsageCount);

        } catch (java.util.InputMismatchException e) {
            System.out.println("❌ Error: Invalid number!");
            scanner.nextLine();
        }
    }
    private void searchHighUsageCountEquipment() {
        try {
            System.out.println("\n┌─ HIGH-USAGE-COUNT EQUIPMENT ──────────┐");
            System.out.print("│ Enter minimum usage count: ");
            double minUsageCount = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("└────────────────────────────────────────┘");

            List<Equipment> results = equipmentDAO.searchByMinUsageCount(minUsageCount);

            displaySearchResults(results, "Usage count >= " + minUsageCount);

        } catch (java.util.InputMismatchException e) {
            System.out.println("❌ Error: Invalid number!");
            scanner.nextLine();
        }
    }
    private void displaySearchResults(List<Equipment> results, String criteria) {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║         SEARCH RESULTS                ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("Criteria: " + criteria);
        System.out.println("─────────────────────────────────────────");

        if (results.isEmpty()) {
            System.out.println("📭 No equipment found matching criteria.");
        } else {
            for (int i = 0; i < results.size(); i++) {
                Equipment s = results.get(i);
                System.out.print((i + 1) + ". ");
                System.out.print("[" + s.getType() + "] ");
                System.out.println(s.toString());
            }
            System.out.println("─────────────────────────────────────────");
            System.out.println("Total Results: " + results.size());
        }
    }

    private void demonstratePolymorphism() {
        equipmentDAO.demonstratePolymorphism();
    }


    private void pressEnterToContinue() {
        System.out.println("\n[Press Enter to continue...]");
        scanner.nextLine();
    }
}




