package model;

public class StrengthEquipment extends Equipment {
    private double maxWeightKg;
    private boolean isAdjustable;

    public StrengthEquipment(int equipmentId, String name, boolean isAvailable, int usageCount, double maxWeightKg, boolean isAdjustable) {
        super(equipmentId, name, isAvailable, usageCount);
        setMaxWeightKg(maxWeightKg);
        this.isAdjustable = isAdjustable;
    }

    public StrengthEquipment() {
        this(1, "Unknown Strength", true, 0, 100.0, true);
    }

    // getters
    public double getMaxWeightKg() {
        return maxWeightKg;
    }
    public boolean isAdjustable() {
        return isAdjustable;
    }

    // setters
    public void setMaxWeightKg(double maxWeightKg) {
        if (maxWeightKg <= 0) {
            throw new IllegalArgumentException("Max weight cannot be negative and zero");
        }
        this.maxWeightKg = maxWeightKg;
    }
    public void setAdjustable(boolean adjustable) {
        this.isAdjustable = adjustable;
    }

    @Override
    public String getEquipmentInfo() {
        return super.getEquipmentInfo() + ", Type: Strength, Max weight: " + maxWeightKg + " kg" + ", Adjustable: " + (isAdjustable ? "Yes" : "No");
    }

    @Override
    public void start(){
        System.out.println("Strength exercise is starting");
    }

    @Override
    public String getType() {
        return "Strength Equipment";
    }


    public void adjustResistance(double newWeight) {
        if (!isAvailable()) {
            System.out.println(getEquipmentInfo() + " is not available to adjust.");
            return;
        }
        if (!isAdjustable) {
            System.out.println(getEquipmentInfo() + " is not adjustable.");
            return;
        }
        if (newWeight <= 0 || newWeight > maxWeightKg) {
            System.out.println("Requested weight must be between 0 and " + maxWeightKg + " kg.");
            return;
        }
        System.out.println(getEquipmentInfo() + " resistance adjusted to " + newWeight + " kg.");
    }

    public void performSafetyCheck() {
        System.out.println(getEquipmentInfo() + " safety check performed.");
    }

    public boolean isHeavyDuty() {
        return maxWeightKg >= 150;
    }

    @Override
    public String toString() {
        return super.toString() + " | Strength{maxWeightKg=" + maxWeightKg + ", isAdjustable=" + isAdjustable + "}";
    }
}