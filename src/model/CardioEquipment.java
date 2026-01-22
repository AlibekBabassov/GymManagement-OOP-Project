package model;

public class CardioEquipment extends Equipment {
    private double maxSpeedKph;
    private boolean hasHeartRateMonitor;

    public CardioEquipment(String equipmentId, String name, String equipmentType, boolean isAvailable, int usageCount, double maxSpeedKph, boolean hasHeartRateMonitor) {
        super(equipmentId, name, equipmentType, isAvailable, usageCount);
        setMaxSpeedKph(maxSpeedKph);
        this.hasHeartRateMonitor = hasHeartRateMonitor;
    }

    public CardioEquipment() {
        this("EQCARD0", "Unknown Cardio", "Cardio", true, 0, 20.0, false);
    }

    // getters
    public double getMaxSpeedKph() {
        return maxSpeedKph;
    }
    public boolean isHasHeartRateMonitor() {
        return hasHeartRateMonitor;
    }

    // setters
    public void setMaxSpeedKph(double maxSpeedKph) {
        if (maxSpeedKph <= 0) {
            throw new IllegalArgumentException("Max speed cannot be negative and zero");
        }
        this.maxSpeedKph = maxSpeedKph;
    }
    public void setHasHeartRateMonitor(boolean hasHeartRateMonitor) {
        this.hasHeartRateMonitor = hasHeartRateMonitor;
    }

    @Override
    public String getEquipmentInfo() {
        return super.getEquipmentInfo() + ", Type: " + getEquipmentType() + ", Max speed: " + maxSpeedKph + " kph"
                + ", HR monitor: " + (hasHeartRateMonitor ? "Yes" : "No");
    }

    @Override
    public void start(){
        System.out.println(equipmentType + " exercise is starting");
    }

    @Override
    public String getType() {
        return "Cardio Equipment";
    }

    public void startCardioSession(int minutes) {
        if (!isAvailable()) {
            System.out.println(getEquipmentInfo() + " is not available right now.");
            return;
        }
        if (minutes <= 0) {
            System.out.println("Please provide a positive duration for the cardio session.");
            return;
        }
        setUsageCount(getUsageCount() + 1);
        System.out.println(getEquipmentInfo() + " started cardio session for " + minutes + " minutes.");
    }

    public void enableHeartRateMonitor() {
        if (hasHeartRateMonitor) {
            System.out.println(getEquipmentInfo() + " heart rate monitor enabled.");
        } else {
            System.out.println(getEquipmentInfo() + " does not have a heart rate monitor.");
        }
    }

    public boolean isFastEquipment() {
        return maxSpeedKph >= 25;
    }

    @Override
    public String toString() {
        return super.toString() + " | Cardio{maxSpeedKph=" + maxSpeedKph + ", hasHeartRateMonitor=" + hasHeartRateMonitor + "}";
    }
}
