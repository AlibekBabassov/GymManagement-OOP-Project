package com.alibek.gym;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static ArrayList<GymMember> gymMembers = new ArrayList<>();
    private static ArrayList<GymTrainer> gymTrainers = new ArrayList<>();
    private static ArrayList<WorkoutSession> workoutSessions = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        gymMembers.add(new GymMember("Aslan", 18, 60, 175, true));
        gymMembers.add(new GymMember("Alem", 27, 70, 180, true));
        gymMembers.add(new GymMember("Sanzhar", 14, 65, 175, true));
        gymTrainers.add(new GymTrainer("Aibar", "Strength", 5, 500000, true));
        gymTrainers.add(new GymTrainer("Asel",  "Weight Lose", 3, 300000, true));
        workoutSessions.add(new WorkoutSession("0001", "01.01.2026", 90, "High"));
        workoutSessions.add(new WorkoutSession("0002", "02.01.2026", 60, "Low"));

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

}
