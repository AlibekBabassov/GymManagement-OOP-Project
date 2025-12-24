package com.alibek.gym;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Gym Management System!");
        System.out.println("This system helps manage members, trainers, and workout plans.");
        System.out.println("Features planned:");
        System.out.println("- Member registration and membership tracking");
        System.out.println("- Trainer schedules and workout plans");
        System.out.println("Developed by: Alibek, Object-Oriented Programming Course");
        System.out.println();
        System.out.println("---------------------------------------------------------");
        System.out.println();

        GymMember member1 = new GymMember("Alibek", 18, 61, 1.70, false);
        GymMember member2 = new GymMember("Zhiger", 20, 70, 1.85, false);

        GymTrainer trainer1 = new GymTrainer("Eldos", "Strength", 3, 300000.0, true);
        GymTrainer trainer2 = new GymTrainer("Marat", "Weight Loss", 5, 250000, true);

        WorkoutSession session1 = new WorkoutSession("0001", "2026-01-01", 60, "High");

        System.out.println("--- MEMBERS ---");
        System.out.println(member1);
        System.out.println(member2);
        System.out.println();

        System.out.println("--- TRAINERS ---");
        System.out.println(trainer1);
        System.out.println(trainer2);
        System.out.println();

        System.out.println("--- SESSIONS ---");
        System.out.println(session1);
        System.out.println();

        System.out.println("---TESTING GETTERS---");
        System.out.println("Member1 name is " + member1.getName() + ".");
        System.out.println("Member2 age is " + member2.getAge() + ".");
        System.out.println("Trainer1's experience years:  " + trainer1.getExperienceYears() + " year.");
        System.out.println("Trainer2's salary: " + trainer2.getSalary() + " KZT.");
        System.out.println("Session1's ID: " + session1.getSessionId() + ".");
        System.out.println();

        System.out.println("---TESTING SETTERS---");
        System.out.println("Updating member2...");
        member2.setName("Nurhan");
        member2.setAge(17);
        member2.setWeightKg(55);
        member2.setHeightMeters(170);
        member2.setMembershipActive(true);
        System.out.println("Updated: " + member2);
        System.out.println();

        System.out.println("Updating trainer1...");
        trainer1.setName("Zhandos");
        trainer1.setSpecialization("Fitness");
        trainer1.setExperienceYears(2);
        trainer1.setSalary(400000);
        trainer1.setAvailable(false);
        System.out.println("Updated: " + trainer1);
        System.out.println();

        System.out.println("--- TESTING GYMMEMBER METHODS---");
        member1.activateMembership();
        System.out.printf("BMI of member1: %.2f \n", member1.calculateBMI());
        System.out.printf("Member2 can train -> %b", member2.canTrain());
        System.out.println();
        System.out.println();

        System.out.println("--- TESTING GYMTRAINER METHODS---");
        System.out.printf("Is trainer2 experienced? -> %b\n", trainer2.isExperienced());
        trainer2.increaseSalary(10);
        trainer1.assignWorkout(session1, member1);
        trainer2.assignWorkout(session1, member1);
        System.out.println();

        System.out.println("--- TESTING WORKOUTSESSION METHODS---");
        session1.startSession();
        session1.endSession();
        System.out.println();

        System.out.println("---FINAL STATE---");
        System.out.println("Gym Members:");
        System.out.println(member1);
        System.out.println(member2);
        System.out.println();
        System.out.println("Gym Trainers:");
        System.out.println(trainer1);
        System.out.println(trainer2);
        System.out.println();
        System.out.println("Workout Session:");
        System.out.println(session1);
        System.out.println("\n===Program Complete===");



    }
}
