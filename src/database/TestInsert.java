package database;

import model.StrengthEquipment;

public class TestInsert {
    public static void main(String[] args) {
        StrengthEquipment strengthEquipment = new StrengthEquipment(1, "dumbbell", true, 100, 60, true);

        EquipmentDAO dao = new EquipmentDAO();
        dao.insertStrengthEquipment(strengthEquipment);
    }
}
