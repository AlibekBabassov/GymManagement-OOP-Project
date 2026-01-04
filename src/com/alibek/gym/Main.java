package com.alibek.gym;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static ArrayList<GymMember> gymMembers = new ArrayList<>();
    private static ArrayList<GymTrainer> gymTrainers = new ArrayList<>();
    private static ArrayList<WorkoutSession> workoutSessions = new ArrayList<>();

    private static ArrayList<Equipment> allEquipment = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        gymMembers.add(new GymMember("Aslan", 18, 60, 175, true));
        gymMembers.add(new GymMember("Alem", 27, 70, 180, true));
        gymMembers.add(new GymMember("Sanzhar", 14, 65, 175, true));
        gymTrainers.add(new GymTrainer("Aibar", "Strength", 5, 500000, true));
        gymTrainers.add(new GymTrainer("Asel",  "Weight Lose", 3, 300000, true));
        workoutSessions.add(new WorkoutSession("0001", "01.01.2026", 90, "High"));
        workoutSessions.add(new WorkoutSession("0002", "02.01.2026", 60, "Low"));

        allEquipment.add(new Equipment("EQ001", "Basic Bench", "General", true, 10));
        allEquipment.add(new StrengthEquipment("EQ002", "Leg Press", "Strength", true, 25, 200, true));
        allEquipment.add(new CardioEquipment("EQ003", "Treadmill", "Cardio", true, 40, 25, true));

        for (Equipment e : allEquipment) {// polymorphism
            e.getType();
        }

        boolean running = true;
        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addMember();
                    break;
                case 2:
                    viewAllMembers();
                    break;
                case 3:
                    addTrainer();
                    break;
                case 4:
                    viewAllTrainers();
                    break;
                case 5:
                    addSession();
                    break;
                case 6:
                    viewAllSessions();
                    break;
                case 7:
                    addEquipment();
                    break;
                case 8:
                    addStrengthEquipment();
                    break;
                case 9:
                    addCardioEquipment();
                    break;
                case 10:
                    viewAllEquipment();
                    break;
                case 11:
                    demonstratePolymorphism();
                    break;
                case 12:
                    viewStrengthEquipmentOnly();
                    break;
                case 13:
                    viewCardioEquipmentOnly();
                    break;
                case 0:
                    System.out.println("\nGoodbye! ");
                    running = false;
                    break;
                default:
                    System.out.println("\n Invalid choice!");
            }
            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n========================================");
        System.out.println("                GYM SYSTEM              ");
        System.out.println("========================================");
        System.out.println("1. Add Member");
        System.out.println("2. View All Members");
        System.out.println("3. Add Trainer");
        System.out.println("4. View All Trainers");
        System.out.println("5. Add Session");
        System.out.println("6. View All Sessions");
        System.out.println("7. Add Equipment (General)");
        System.out.println("8. Add Strength Equipment");
        System.out.println("9. Add Cardio Equipment");
        System.out.println("10. View All Equipment (Polymorphic)");
        System.out.println("11. Demonstrate Polymorphism");
        System.out.println("12. View Strength Equipments Only");
        System.out.println("13. View Cardio Equipments Only");
        System.out.println("0. Exit");
        System.out.println("========================================");
        System.out.print("Enter your choice: ");
    }

    private static void addMember() {
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

        gymMembers.add(item);
        System.out.println("\nMember added successfully! ✅");
    }
    private static void viewAllMembers() {
        System.out.println("\n========================================");
        System.out.println("                ALL MEMBERS             ");
        System.out.println("========================================");
        if (gymMembers.isEmpty()) {
            System.out.println("No members found.");
            return;
        }
        System.out.println("Total members: " + gymMembers.size());
        System.out.println();

        for (int i = 0; i < gymMembers.size(); i++) {
            GymMember item = gymMembers.get(i);
            System.out.println((i + 1) + ". " + item.getName());
            System.out.println(" Age: " + item.getAge());
            System.out.println(" Weight: " + item.getWeightKg());
            System.out.println(" Height: " + item.getHeightMeters());
            System.out.println(" Membership active: " +
                    (item.isMembershipActive() ? " Yes ✅" : " No ❌"));
            if (item.canTrain()) {
                System.out.println(" He(she) can train!🏋️‍♂️");
            }else{
                System.out.println(" He(she) can Not train!🤷‍♂️");
            }
            System.out.println();
        }
    }
    private static void addTrainer() {
        System.out.println("\n--- ADD TRAINER ---");

        System.out.print("Enter trainer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter specialization: ");
        String specialization = scanner.nextLine();
        System.out.print("Enter experience years: ");
        int experienceYears = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Is available? (true/false): ");
        boolean available = scanner.nextBoolean();
        scanner.nextLine();

        GymTrainer item = new GymTrainer(name, specialization, experienceYears, salary, available);

        gymTrainers.add(item);
        System.out.println("\nTrainer added successfully! ✅");
    }
    private static void viewAllTrainers() {
        System.out.println("\n========================================");
        System.out.println("                ALL TRAINERS             ");
        System.out.println("========================================");
        if (gymTrainers.isEmpty()) {
            System.out.println("No trainers found.");
            return;
        }
        System.out.println("Total trainers: " + gymTrainers.size());
        System.out.println();

        for (int i = 0; i < gymTrainers.size(); i++) {
            GymTrainer item = gymTrainers.get(i);
            System.out.println((i + 1) + ". " + item.getName());
            System.out.println(" Specialization: " + item.getSpecialization());
            System.out.println(" Experience years: " + item.getExperienceYears());
            System.out.println(" Salary: " + item.getSalary());
            System.out.println(" Available: " +
                    (item.isAvailable() ? " Yes ✅" : " No ❌"));
            if (item.isExperienced()) {
                System.out.println(" He(she) is experienced!👍️");
            }else{
                System.out.println(" He(she) is Not experienced!🤏");
            }
            System.out.println();
        }
    }
    private static void addSession() {
        System.out.println("\n--- ADD SESSION ---");

        System.out.print("Enter session ID: ");
        String sessionId = scanner.nextLine();
        System.out.print("Enter date: ");
        String date = scanner.nextLine();
        System.out.print("Enter duration in minutes: ");
        int durationMinutes = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter intensity level: ");
        String intensityLevel = scanner.nextLine();


        WorkoutSession item = new WorkoutSession(sessionId, date, durationMinutes, intensityLevel);

        workoutSessions.add(item);
        System.out.println("\nSession added successfully! ✅");
    }
    private static void viewAllSessions() {
        System.out.println("\n========================================");
        System.out.println("                ALL SESSIONS             ");
        System.out.println("========================================");
        if (workoutSessions.isEmpty()) {
            System.out.println("No sessions found.");
            return;
        }
        System.out.println("Total sessions: " + workoutSessions.size());
        System.out.println();

        for (int i = 0; i < workoutSessions.size(); i++) {
            WorkoutSession item = workoutSessions.get(i);
            System.out.println((i + 1) + ". " + item.getSessionId());
            System.out.println(" Date: " + item.getDate());
            System.out.println(" Duration in minutes: " + item.getDurationMinutes());
            System.out.println(" Intensity level: " + item.getIntensityLevel());
            System.out.println();
        }
    }

    private static void addEquipment() {
        System.out.println("\n--- ADD EQUIPMENT ---");
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

        Equipment item = new Equipment(equipmentId, name, equipmentType, isAvailable, usageCount);

        allEquipment.add(item);
        System.out.println("\nEquipment added successfully! ✅");
    }
    private static void addStrengthEquipment() {
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

        Equipment equipment = new StrengthEquipment(equipmentId, name, equipmentType, isAvailable, usageCount, maxWeightKg, isAdjustable);
        allEquipment.add(equipment);
        System.out.println("\n Strength equipment added successfully✅");
    }
    private static void addCardioEquipment() {
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

        Equipment equipment = new CardioEquipment(equipmentId, name, equipmentType, isAvailable, usageCount, maxSpeedKph, hasHeartRateMonitor);
        allEquipment.add(equipment);
        System.out.println("\n Cardio equipment added successfully✅");
    }
    private static void viewAllEquipment() {
        System.out.println("\n========================================");
        System.out.println(" ALL EQUIPMENT (POLYMORPHIC LIST)");
        System.out.println("========================================");
        if (allEquipment.isEmpty()) {
            System.out.println("No equipment found.");
            return;
        }
        System.out.println("Total equipment: " + allEquipment.size());
        System.out.println();
        for (int i = 0; i < allEquipment.size(); i++) {
            Equipment e = allEquipment.get(i);
            System.out.println((i + 1) + ". " + e);

            if (e instanceof StrengthEquipment) {
                StrengthEquipment strengthEquipment = (StrengthEquipment) e;
                if (strengthEquipment.isHeavyDuty()) {
                    System.out.println(" It can handle heavy weight!");
                }
            } else if (e instanceof CardioEquipment) {
                CardioEquipment cardioEquipment = (CardioEquipment) e; // Downcast
                if (cardioEquipment.isFastEquipment()) {
                    System.out.println(" Really fast equipment!");
                }
            }
            System.out.println();
        }
    }
    private static void demonstratePolymorphism() {
        System.out.println("\n========================================");
        System.out.println(" POLYMORPHISM DEMONSTRATION");
        System.out.println("========================================");
        System.out.println("Calling getType() for all equipment:");
        System.out.println();
        for (Equipment e : allEquipment) {
            System.out.println(e.getType());
        }
        System.out.println();
        System.out.println(" Notice: Same method name (getType), different output!");
        System.out.println(" This is POLYMORPHISM in action!");
    }
    private static void viewStrengthEquipmentOnly() {
        System.out.println("\n========================================");
        System.out.println(" STRENGTH EQUIPMENT ONLY");
        System.out.println("========================================");
        int strengthEquipmentCount = 0;
        for (Equipment e : allEquipment) {
            if (e instanceof StrengthEquipment) {
                StrengthEquipment strengthEquipment = (StrengthEquipment) e;
                strengthEquipmentCount++;
                System.out.println(strengthEquipmentCount + ". " + strengthEquipment.getName());
                System.out.println(" Equipment type: " + strengthEquipment.getEquipmentType());
                System.out.println(" Nax weight (kg): " + strengthEquipment.getMaxWeightKg() + " kg");
                if (strengthEquipment.isHeavyDuty()) {
                    System.out.println(" It can handle heavy weight!");
                }
                System.out.println();
            }
        }
        if (strengthEquipmentCount == 0) {
            System.out.println("No strength equipment found.");
        }
    }
    private static void viewCardioEquipmentOnly() {
        System.out.println("\n========================================");
        System.out.println(" CARDIO EQUIPMENT ONLY");
        System.out.println("========================================");
        int cardioEquipmentCount = 0;
        for (Equipment e : allEquipment) {
            if (e instanceof CardioEquipment) {
                CardioEquipment cardioEquipment = (CardioEquipment) e;
                cardioEquipmentCount++;
                System.out.println(cardioEquipmentCount + ". " + cardioEquipment.getName());
                System.out.println(" Equipment type: " + cardioEquipment.getEquipmentType());
                System.out.println(" Nax max speed (kph): " + cardioEquipment.getMaxSpeedKph() + " kph");
                if (cardioEquipment.isFastEquipment()) {
                    System.out.println(" Really fast equipment!");
                }
                System.out.println();
            }
        }
        if (cardioEquipmentCount== 0) {
            System.out.println("No cardio equipment found.");
        }
    }

}
