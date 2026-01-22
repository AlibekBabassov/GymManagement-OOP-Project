package model;

public class GymMember implements Trainable {
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
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Member name cannot be empty");
        }
        if (name.length() < 3) {
            throw new IllegalArgumentException("Member name must be at least 3 characters");
        }
        this.name = name;
    }
    public void setAge(int age){
        if (age <= 0) {
            throw new IllegalArgumentException("Age cannot be negative and zero");
        }
        this.age = age;
    }
    public void setWeightKg(double weightKg){
        if (weightKg <= 0) {
            throw new IllegalArgumentException("Weight cannot be negative and zero");
        }
        this.weightKg = weightKg;
    }
    public void setHeightMeters(double heightMeters){
        if (heightMeters<= 0) {
            throw new IllegalArgumentException("Height cannot be negative and zero");
        }
        this.heightMeters = heightMeters;
    }
    public void setMembershipActive(boolean membershipActive){
        this.membershipActive = membershipActive;
    }

    @Override
    public void train(){
        System.out.println("🏋️‍♂️ Training " + name + "...");
        System.out.println("   Age: " + age);
        System.out.println("   Weight: " + weightKg + " Kg");
        System.out.println("✅ " + name + " is ready to everything!");
    }

    @Override
    public String getTrainingPlan(){
        return "Plan for " + name + " : 100 Push ups, 100 Pull ups, and 10 km running";
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
