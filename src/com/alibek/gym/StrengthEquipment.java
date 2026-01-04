package com.alibek.gym;

public class StrengthEquipment extends Equipment {
    private double maxWeightKg;
    private boolean isAdjustable;

    public StrengthEquipment(String equipmentId, String name, String equipmentType, boolean isAvailable, int usageCount, double maxWeightKg, boolean isAdjustable) {
        super(equipmentId, name, equipmentType, isAvailable, usageCount);
        setMaxWeightKg(maxWeightKg);
        this.isAdjustable = isAdjustable;
    }

    public StrengthEquipment() {
        this("EQSTR0", "Unknown Strength", "Strength", true, 0, 100.0, true);
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
        if (maxWeightKg > 0) {
            this.maxWeightKg = maxWeightKg;
        } else {
            System.out.println("Warning: maxWeightKg must be positive! Setting to 50.0.");
            this.maxWeightKg = 50.0;
        }
    }
    public void setAdjustable(boolean adjustable) {
        this.isAdjustable = adjustable;
    }

    @Override
    public String getEquipmentInfo() {
        return super.getEquipmentInfo() + ", Type: " + getEquipmentType() + ", Max weight: " + maxWeightKg + " kg" + ", Adjustable: " + (isAdjustable ? "Yes" : "No");
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