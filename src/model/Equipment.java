package model;

public abstract class Equipment {
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
        if (equipmentId == null || equipmentId.trim().isEmpty()) {
            throw new IllegalArgumentException("Equipment ID cannot be empty");
        }
        if (equipmentId.length() < 3) {
            throw new IllegalArgumentException("Equipment ID  must be at least 3 characters");
        }
        this.equipmentId = equipmentId;
    }
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Equipment name cannot be empty");
        }
        if (name.length() < 3) {
            throw new IllegalArgumentException("Equipment name must be at least 3 characters");
        }
        this.name = name;
    }
    public void setEquipmentType(String equipmentType) {
        if (equipmentType == null || equipmentType.trim().isEmpty()) {
            throw new IllegalArgumentException("Equipment Type cannot be empty");
        }
        if (equipmentType.length() < 3) {
            throw new IllegalArgumentException("Equipment Type must be at least 3 characters");
        }
        this.equipmentType = equipmentType;
    }
    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }
    public void setUsageCount(int usageCount) {
        if (usageCount < 0) {
            throw new IllegalArgumentException("Usage count cannot be negative");
        }
        this.usageCount = usageCount;
    }

    public String getEquipmentInfo() {
        return "Equipment ID: " + equipmentId + ", Name: " + name;
    }

    public abstract void start();
    public abstract String getType();

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