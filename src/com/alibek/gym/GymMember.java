package com.alibek.gym;

public class GymMember {
    private String name;
    private int age;
    private double weightKg;
    private double heightMeters;
    private boolean membershipActive;

    public GymMember(String name, int age, double weightKg, double heightMeters, boolean membershipActive){
        this.name = name;
        this.age = age;
        this.weightKg = weightKg;
        this.heightMeters = heightMeters;
        this.membershipActive = membershipActive;
    }

    public GymMember(){
        this("Unknown", 18, 60.0, 1.75, false);
    }

//getters
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public double getWeightKg(){
        return weightKg;
    }
    public double getHeightMeters(){
        return heightMeters;
    }
    public boolean isMembershipActive(){
        return membershipActive;
    }
//setters
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setWeightKg(double weightKg){
        this.weightKg = weightKg;
    }
    public void setHeightMeters(double heightMeters){
        this.heightMeters = heightMeters;
    }
    public void setMembershipActive(boolean membershipActive){
        this.membershipActive = membershipActive;
    }


    public void activateMembership(){
        this.membershipActive = true;
        System.out.println(name + "'s membership activated.");
    }

    public double calculateBMI(){
        if (heightMeters <= 0) {
            return -1;
        }
        return weightKg / (heightMeters * heightMeters);
    }

    public boolean canTrain(){
        return this.age >= 16 && this.membershipActive;
    }

    @Override
    public String toString(){
        return "GymMember{" + "name = '" + name + "'" + ", age = " + age + ", weightKg = " + weightKg +
                ", heightMeters = " + heightMeters + ", membershipActive = " + membershipActive + "}";
    }
}
