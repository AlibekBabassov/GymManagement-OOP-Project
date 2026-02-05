package model;

public abstract class Equipment {
    protected int equipmentId;
    protected String name;
    protected boolean isAvailable;
    protected int usageCount;

    public Equipment(int equipmentId, String name, boolean isAvailable, int usageCount) {
        setEquipmentId(equipmentId);
        setName(name);
        this.isAvailable = isAvailable;
        setUsageCount(usageCount);
    }

    public Equipment() {
        this(1, "Unknown", true, 0);
    }

    // getters
    public int getEquipmentId() {
        return equipmentId;
    }
    public String getName() {
        return name;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public int getUsageCount() {
        return usageCount;
    }

    // setters
    public void setEquipmentId(int equipmentId) {
        if (equipmentId <= 0) {
            throw new IllegalArgumentException("Equipment ID cannot be negative or zero");
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
        return "Equipment{" + "equipmentId = '" + equipmentId + '\'' + ", name = '" + name + '\'' + ", isAvailable = " + isAvailable +
                ", usageCount = " + usageCount + "}";
    }
}