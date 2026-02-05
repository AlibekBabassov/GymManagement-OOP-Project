package database;

import model.Equipment;
import java.util.List;

public class TestSelect {
    public static void main(String[] args) {
        EquipmentDAO dao = new EquipmentDAO();

        List<Equipment> list = dao.getAllEquipment();

        for (Equipment e : list) {
            System.out.println(e);
        }
    }
}
