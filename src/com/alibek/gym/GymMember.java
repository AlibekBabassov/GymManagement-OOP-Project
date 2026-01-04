package com.alibek.gym;

public class GymMember {
    private String name;
    private int age;
    private double weightKg;
    private double heightMeters;
    private boolean membershipActive;

    public GymMember(String name, int age, double weightKg, double heightMeters, boolean membershipActive){
        setName(name);
        setAge(age);
        setWeightKg(weightKg);
        setHeightMeters(heightMeters);
        this.membershipActive = membershipActive;
    }

    public GymMember(){
        this("Unknown", 16, 60.0, 1.75, false);
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
        if(name != null && !name.trim().isEmpty()){
            this.name = name;
        }else{
            System.out.println("Warning: Name cannot be empty!");
        }
    }
    public void setAge(int age){
        if(age >= 0){
            this.age = age;
        }else{
            System.out.println("Warning: Age cannot be negative! Setting to 16.");
            this.age = 16;
        }
    }
    public void setWeightKg(double weightKg){
        if(weightKg > 0){
            this.weightKg = weightKg;
        }else{
            System.out.println("Warning: Weight cannot be negative and 0! Setting to 60.");
            this.weightKg = 60;
        }
    }
    public void setHeightMeters(double heightMeters){
        if(heightMeters > 0){
            this.heightMeters = heightMeters;
        }else{
            System.out.println("Warning: Height cannot be negative and 0! Setting to 175.");
            this.heightMeters = 175;
        }
    }
    public void setMembershipActive(boolean membershipActive){
        this.membershipActive = membershipActive;
    }


    public void activateMembership(){
        this.membershipActive = true;
        System.out.println(name + "'s membership activated.");
    }

    public double calculateBMI(){
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
