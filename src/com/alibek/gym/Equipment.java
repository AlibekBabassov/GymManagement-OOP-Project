package com.alibek.gym;

public class Equipment {
    protected String equipmentId;
    protected String name;
    protected String equipmentType;
    protected boolean isAvailable;
    protected int usageCount;

    public Equipment(String equipmentId, String name, String equipmentType, boolean isAvailable, int usageCount) {
        setEquipmentId(equipmentId);
        setName(name);
        setEquipmentType(equipmentType);
        this.isAvailable = isAvailable;
        setUsageCount(usageCount);
    }

    public Equipment() {
        this("EQ000", "Unknown", "General", true, 0);
    }

    // getters
    public String getEquipmentId() {
        return equipmentId;
    }
    public String getName() {
        return name;
    }
    public String getEquipmentType() {
        return equipmentType;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public int getUsageCount() {
        return usageCount;
    }

    // setters
    public void setEquipmentId(String equipmentId) {
        if (equipmentId != null && !equipmentId.trim().isEmpty()) {
            this.equipmentId = equipmentId;
        } else {
            System.out.println("Warning: Equipment ID cannot be empty!");
        }
    }
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Warning: Name cannot be empty!");
        }
    }
    public void setEquipmentType(String equipmentType) {
        if (equipmentType != null && !equipmentType.trim().isEmpty()) {
            this.equipmentType = equipmentType;
        } else {
            System.out.println("Warning: Equipment type cannot be empty! Setting to 'General'.");
            this.equipmentType = "General";
        }
    }
    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }
    public void setUsageCount(int usageCount) {
        if (usageCount >= 0) {
            this.usageCount = usageCount;
        } else {
            System.out.println("Warning: Usage count cannot be negative! Setting to 0.");
            this.usageCount = 0;
        }
    }

    public String getEquipmentInfo() {
        return "Equipment ID: " + equipmentId + ", Name: " + name;
    }

    public String getType() {
        return "Gym equipment";
    }

    public void activateEquipment() {
        this.isAvailable = true;
        System.out.println(name + " is now available.");
    }

    public void deactivateEquipment() {
        this.isAvailable = false;
        System.out.println(name + " is now not available.");
    }

    public void reserveEquipment() {
        if (this.isAvailable) {
            this.isAvailable = false;
            this.usageCount++;
            System.out.println(getEquipmentInfo() + " has been reserved.");
        } else {
            System.out.println(getEquipmentInfo() + " is currently not available.");
        }
    }

    public boolean isUsable() {
        return this.isAvailable;
    }

    @Override
    public String toString() {
        return "Equipment{" + "equipmentId = '" + equipmentId + '\'' + ", name = '" + name + '\'' +
                ", equipmentType = '" + equipmentType + '\'' + ", isAvailable = " + isAvailable +
                ", usageCount = " + usageCount + "}";
    }
}