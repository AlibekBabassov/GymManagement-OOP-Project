package database;

import model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipmentDAO {
    public boolean insertStrengthEquipment(StrengthEquipment strengthEquipment) {
        String sql = "INSERT INTO equipment (name, equipment_type, is_available, usage_count, max_speed_kph, has_heart_rate_monitor, max_weight_kg,is_adjustable) " +
                "VALUES (?, 'STRENGTHEQUIPMENT', ?, ?, NULL, NULL, ?, ?)";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, strengthEquipment.getName());
            statement.setBoolean(2, strengthEquipment.isAvailable());
            statement.setInt(3, strengthEquipment.getUsageCount());
            statement.setDouble(4, strengthEquipment.getMaxWeightKg());
            statement.setBoolean(5, strengthEquipment.isAdjustable());

            int rowsInserted = statement.executeUpdate();
            statement.close();

            if (rowsInserted > 0) {
                System.out.println("✅ Strength equipment inserted: " + strengthEquipment.getName());
                return true;
            }

        } catch (SQLException e) {
            System.out.println("❌ Insert Strength equipment failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return false;
    }

    public boolean insertCardioEquipment(CardioEquipment cardioEquipment) {
        String sql = "INSERT INTO equipment (name, equipment_type, is_available, usage_count, max_speed_kph, has_heart_rate_monitor, max_weight_kg,is_adjustable) " +
                "VALUES (?, 'CARDIOEQUIPMENT', ?, ?, ?, ?, NULL, NULL)";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cardioEquipment.getName());
            statement.setBoolean(2, cardioEquipment.isAvailable());
            statement.setInt(3, cardioEquipment.getUsageCount());
            statement.setDouble(4, cardioEquipment.getMaxSpeedKph());
            statement.setBoolean(5, cardioEquipment.isHasHeartRateMonitor());

            int rowsInserted = statement.executeUpdate();
            statement.close();

            if (rowsInserted > 0) {
                System.out.println("✅ Cardio equipment inserted: " + cardioEquipment.getName());
                return true;
            }

        } catch (SQLException e) {
            System.out.println("❌ Insert Cardio equipment failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return false;
    }

    public List<Equipment> getAllEquipment() {
        List<Equipment> equipmentList = new ArrayList<>();
        String sql = "SELECT * FROM equipment ORDER BY equipment_id";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return equipmentList;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Equipment equipment = extractEquipmentFromResultSet(resultSet);
                if (equipment != null) {
                    equipmentList.add(equipment);
                }
            }

            resultSet.close();
            statement.close();

            System.out.println("✅ Retrieved " + equipmentList.size() + " equipment from database");

        } catch (SQLException e) {
            System.out.println("❌ Select all equipment failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return equipmentList;
    }

    public Equipment getEquipmentById(int equipmentId) {
        String sql = "SELECT * FROM equipment WHERE equipment_id = ?";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return null;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, equipmentId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Equipment equipment = extractEquipmentFromResultSet(resultSet);

                resultSet.close();
                statement.close();

                if (equipment != null) {
                    System.out.println("✅ Found equipment with ID: " + equipmentId);
                }

                return equipment;
            }

            System.out.println("⚠️ No equipment found with ID: " + equipmentId);

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println("❌ Select by ID failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return null;
    }

    public List<StrengthEquipment> getAllStrengthEquipment() {
        List<StrengthEquipment> strengthEquipments = new ArrayList<>();
        String sql = "SELECT * FROM equipment WHERE equipment_type = 'STRENGTHEQUIPMENT' ORDER BY equipment_id";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return strengthEquipments;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Equipment equipment = extractEquipmentFromResultSet(resultSet);
                if (equipment instanceof StrengthEquipment) {
                    strengthEquipments.add((StrengthEquipment) equipment);
                }
            }

            resultSet.close();
            statement.close();

            System.out.println("✅ Retrieved " + strengthEquipments.size() + " strength equipments");

        } catch (SQLException e) {
            System.out.println("❌ Select strength equipments failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return strengthEquipments;
    }

    public List<CardioEquipment> getAllCardioEquipment() {
        List<CardioEquipment> cardioEquipments = new ArrayList<>();
        String sql = "SELECT * FROM equipment WHERE equipment_type = 'CARDIOEQUIPMENT' ORDER BY equipment_id";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return cardioEquipments;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Equipment equipment = extractEquipmentFromResultSet(resultSet);
                if (equipment instanceof CardioEquipment) {
                    cardioEquipments.add((CardioEquipment) equipment);
                }
            }

            resultSet.close();
            statement.close();

            System.out.println("✅ Retrieved " + cardioEquipments.size() + " cardio equipments");

        } catch (SQLException e) {
            System.out.println("❌ Select cardio equipments failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return cardioEquipments;
    }

    public boolean updateStrengthEquipment(StrengthEquipment strengthEquipment) {
        String sql = "UPDATE equipment SET name = ?, is_available = ?, usage_count = ?, max_weight_kg = ?, is_adjustable = ? " +
                "WHERE equipment_id = ? AND equipment_type = 'STRENGTHEQUIPMENT'";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, strengthEquipment.getName());
            statement.setBoolean(2, strengthEquipment.isAvailable());
            statement.setInt(3, strengthEquipment.getUsageCount());
            statement.setDouble(4, strengthEquipment.getMaxWeightKg());
            statement.setBoolean(5, strengthEquipment.isAdjustable());
            statement.setInt(6, strengthEquipment.getEquipmentId());

            int rowsUpdated = statement.executeUpdate();
            statement.close();

            if (rowsUpdated > 0) {
                System.out.println("✅ Strength equipment updated: " + strengthEquipment.getName());
                return true;
            } else {
                System.out.println("⚠️ No Strength equipment found with ID: " + strengthEquipment.getEquipmentId());
            }

        } catch (SQLException e) {
            System.out.println("❌ Update Strength equipment failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return false;
    }

    public boolean updateCardioEquipment(CardioEquipment cardioEquipment) {
        String sql = "UPDATE equipment SET name = ?, is_available = ?, usage_count = ?, max_speed_kph = ?, has_heart_rate_monitor = ? " +
                "WHERE equipment_id = ? AND equipment_type = 'CARDIOEQUIPMENT'";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cardioEquipment.getName());
            statement.setBoolean(2, cardioEquipment.isAvailable());
            statement.setInt(3, cardioEquipment.getUsageCount());
            statement.setDouble(4, cardioEquipment.getMaxSpeedKph());
            statement.setBoolean(5, cardioEquipment.isHasHeartRateMonitor());
            statement.setInt(6, cardioEquipment.getEquipmentId());

            int rowsUpdated = statement.executeUpdate();
            statement.close();

            if (rowsUpdated > 0) {
                System.out.println("✅ Cardio equipment updated: " + cardioEquipment.getName());
                return true;
            } else {
                System.out.println("⚠️ No Cardio equipment found with ID: " + cardioEquipment.getEquipmentId());
            }

        } catch (SQLException e) {
            System.out.println("❌ Update Cardio equipment failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return false;
    }

    public boolean deleteEquipment(int equipmentId) {
        String sql = "DELETE FROM equipment WHERE equipment_id = ?";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, equipmentId);

            int rowsDeleted = statement.executeUpdate();
            statement.close();

            if (rowsDeleted > 0) {
                System.out.println("✅ Equipment deleted (ID: " + equipmentId + ")");
                return true;
            } else {
                System.out.println("⚠️ No equipment found with ID: " + equipmentId);
            }

        } catch (SQLException e) {
            System.out.println("❌ Delete failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return false;
    }

    public List<Equipment> searchByName(String name) {
        List<Equipment> equipmentList = new ArrayList<>();

        String sql = "SELECT * FROM equipment WHERE name ILIKE ? ORDER BY name";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return equipmentList;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + name + "%");  // % = wildcard

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Equipment equipment = extractEquipmentFromResultSet(resultSet);
                if (equipment != null) {
                    equipmentList.add(equipment);
                }
            }

            resultSet.close();
            statement.close();

            System.out.println("✅ Found " + equipmentList.size() + " equipment matching '" + name + "'");

        } catch (SQLException e) {
            System.out.println("❌ Search by name failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return equipmentList;
    }

    public List<Equipment> searchByUsageCountRange(double minUsageCount, double maxUsageCount) {
        List<Equipment> equipmentList = new ArrayList<>();

        String sql = "SELECT * FROM equipment WHERE usage_count BETWEEN ? AND ? ORDER BY usage_count DESC";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return equipmentList;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, minUsageCount);
            statement.setDouble(2, maxUsageCount);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Equipment equipment = extractEquipmentFromResultSet(resultSet);
                if (equipment != null) {
                    equipmentList.add(equipment);
                }
            }

            resultSet.close();
            statement.close();

            System.out.println("✅ Found " + equipmentList.size() + " equipment in usage count range " +
                    minUsageCount + " - " + maxUsageCount);

        } catch (SQLException e) {
            System.out.println("❌ Search by usage count failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return equipmentList;
    }

    public List<Equipment> searchByMinUsageCount(double minUsageCount) {
        List<Equipment> equipmentList = new ArrayList<>();

        String sql = "SELECT * FROM equipment WHERE usage_count >= ? ORDER BY usage_count DESC";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return equipmentList;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, minUsageCount);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Equipment equipment = extractEquipmentFromResultSet(resultSet);
                if (equipment != null) {
                    equipmentList.add(equipment);
                }
            }

            resultSet.close();
            statement.close();

            System.out.println("✅ Found " + equipmentList.size() + " equipment usage >= " + minUsageCount);

        } catch (SQLException e) {
            System.out.println("❌ Search by min usage count failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return equipmentList;
    }

    private Equipment extractEquipmentFromResultSet(ResultSet resultSet) throws SQLException {
        int equipmentId = resultSet.getInt("equipment_id");
        String name = resultSet.getString("name");
        String equipmentType = resultSet.getString("equipment_type");
        boolean isAvailable = resultSet.getBoolean("is_available");
        int usageCount = resultSet.getInt("usage_count");

        Equipment equipment = null;

        if ("STRENGTHEQUIPMENT".equals(equipmentType)) {
            double maxWeightKg = resultSet.getDouble("max_weight_kg");
            boolean isAdjustable = resultSet.getBoolean("is_adjustable");
            equipment = new StrengthEquipment(equipmentId, name, isAvailable, usageCount, maxWeightKg, isAdjustable);

        } else if ("CARDIOEQUIPMENT".equals(equipmentType)) {
            double maxSpeedKph = resultSet.getDouble("max_speed_kph");
            boolean hasHeartRateMonitor = resultSet.getBoolean("has_heart_rate_monitor");
            equipment = new CardioEquipment(equipmentId, name, isAvailable, usageCount, maxSpeedKph, hasHeartRateMonitor);
        }

        return equipment;
    }

    public void displayAllEquipment() {
        List<Equipment> equipmentList = getAllEquipment();

        System.out.println("\n========================================");
        System.out.println("   ALL EQUIPMENT FROM DATABASE");
        System.out.println("========================================");

        if (equipmentList.isEmpty()) {
            System.out.println("No equipment in database.");
        } else {
            for (int i = 0; i < equipmentList.size(); i++) {
                Equipment e = equipmentList.get(i);
                System.out.print((i + 1) + ". ");
                System.out.print("[" + e.getType() + "] ");
                System.out.println(e.toString());
            }
        }

        System.out.println("========================================\n");
    }

    public void demonstratePolymorphism() {
        List<Equipment> equipmentList = getAllEquipment();

        System.out.println("\n========================================");
        System.out.println("  POLYMORPHISM: Equipment from Database");
        System.out.println("========================================");

        if (equipmentList.isEmpty()) {
            System.out.println("No equipment to demonstrate.");
        } else {
            for (Equipment e : equipmentList) {
                e.start();
            }
        }

        System.out.println("========================================\n");
    }
}
