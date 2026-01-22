package model;

public class GymTrainer {
    private String name;
    private String specialization;
    private int experienceYears;
    private double salary;
    private boolean available;

    public GymTrainer(String name, String specialization, int experienceYears, double salary, boolean available){
        setName(name);
        setSpecialization(specialization);
        setExperienceYears(experienceYears);
        setSalary(salary);
        this.available = available;
    }

    public GymTrainer(){
        this("NoName", "General", 0, 200000.0, true);
    }

    // Getters
    public String getName(){
        return name;
    }
    public String getSpecialization(){
        return specialization;
    }
    public int getExperienceYears(){
        return experienceYears;
    }
    public double getSalary(){
        return salary;
    }
    public boolean isAvailable(){
        return available;
    }

    // Setters
    public void setName(String name){
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Trainer name cannot be empty");
        }
        if (name.length() < 3) {
            throw new IllegalArgumentException("Trainer name must be at least 3 characters");
        }
        this.name = name;
    }
    public void setSpecialization(String specialization){
        if (specialization == null || specialization.trim().isEmpty()) {
            throw new IllegalArgumentException("Specialization cannot be empty");
        }
        if (specialization.length() < 5) {
            throw new IllegalArgumentException("Specialization must be at least 5 characters");
        }
        this.specialization = specialization;
    }
    public void setExperienceYears(int experienceYears){
        if (experienceYears < 0) {
            throw new IllegalArgumentException("Experience year cannot be negative");
        }
        this.experienceYears = experienceYears;
    }
    public void setSalary(double salary){
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
        this.salary = salary;
    }
    public void setAvailable(boolean available){
        this.available = available;
    }


    public boolean isExperienced(){
        if(this.experienceYears >= 3){
            return true;
        }else{
            return false;
        }
    }

    public void increaseSalary(double percent){
        if (percent > 0 && percent <= 100) {
            this.salary = this.salary * (1.0 + percent / 100.0);
            System.out.printf("%s's salary increased by %.2f%%. New salary: %.2f KZT", this.name, percent, this.salary);
            System.out.println();
        } else {
            System.out.println("Invalid discount!");
        }
    }

    public void assignWorkout(WorkoutSession session, GymMember member){
        if (!this.available) {
            System.out.println("Trainer " + name + " is not available.");
        }else {
            session.setTrainer(this);
            session.setMember(member);
            this.available = false;
            System.out.println("Trainer " + name + " assigned to session " + session.getSessionId() + " for member " + member.getName());
        }
    }

    @Override
    public String toString(){
        return "Trainer{" + "name = '" + name + "'" + ", specialization = '" + specialization + "'" +
                ", experienceYears = " + experienceYears + ", salary = " + salary + " KZT" +
                ", available = " + available + "}";
    }
}