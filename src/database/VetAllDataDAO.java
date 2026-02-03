package database;

import model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VetAllDataDAO {

    public void insertAllData(
            Owner owner,
            Veterinarian vet,
            Pet pet,
            Treatment treatment,
            Vaccination vaccination,
            VetOrder order
    ) {

        String sql = """
                INSERT INTO vet_all_data (
                    owner_id, owner_name, owner_phone, owner_address,
                    vet_name, vet_phone, vet_experience,
                    pet_name, pet_age,
                    treatment_name, treatment_price,
                    vaccine_name, disease, vaccination_year, valid_until_year,
                    total_price
                )
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return;

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, owner.getId());
            ps.setString(2, owner.getName());
            ps.setString(3, owner.getPhoneNumber());
            ps.setString(4, owner.getAddress());

            ps.setString(5, vet.getName());
            ps.setString(6, vet.getPhoneNumber());
            ps.setInt(7, vet.getExperienceYears());

            ps.setString(8, pet.getNickname());
            ps.setInt(9, pet.getAge());

            ps.setString(10, treatment.getName());
            ps.setDouble(11, treatment.getPrice());

            ps.setString(12, vaccination.getVaccineName());
            ps.setString(13, vaccination.getDisease());
            ps.setInt(14, vaccination.getVaccinationYear());
            ps.setInt(15, vaccination.getValidUntilYear());

            ps.setDouble(16, order.getTotalPrice());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.close(connection);
        }
    }

    public boolean updateOwner(long ownerId, String name, String phone, String address) {

        String sql = """
                UPDATE vet_all_data
                SET owner_name = ?, owner_phone = ?, owner_address = ?
                WHERE owner_id = ?
                """;

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, address);
            ps.setLong(4, ownerId);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            DatabaseConnection.close(connection);
        }
    }

    public boolean deleteByOwnerId(long ownerId) {

        String sql = "DELETE FROM vet_all_data WHERE owner_id = ?";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, ownerId);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            DatabaseConnection.close(connection);
        }
    }

    public void searchByOwnerName(String name) {

        String sql = """
                SELECT owner_name, owner_phone, pet_name, total_price
                FROM vet_all_data
                WHERE owner_name ILIKE ?
                ORDER BY owner_name
                """;

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return;

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                printOwnerInfo(
                        rs.getString("owner_name"),
                        rs.getString("owner_phone"),
                        rs.getString("pet_name"),
                        rs.getDouble("total_price")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.close(connection);
        }
    }

    public void searchByPriceRange(double min, double max) {

        String sql = """
                SELECT owner_name, total_price
                FROM vet_all_data
                WHERE total_price BETWEEN ? AND ?
                ORDER BY total_price DESC
                """;

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return;

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setDouble(1, min);
            ps.setDouble(2, max);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(
                        "Owner: " + rs.getString("owner_name") +
                                ", Total: " + rs.getDouble("total_price")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.close(connection);
        }
    }

    public void searchByMinPrice(double minPrice) {

        String sql = """
                SELECT owner_name, total_price
                FROM vet_all_data
                WHERE total_price >= ?
                ORDER BY total_price DESC
                """;

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return;

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setDouble(1, minPrice);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        "Owner: " + rs.getString("owner_name") +
                                ", Total: " + rs.getDouble("total_price")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.close(connection);
        }
    }


    private void printOwnerInfo(String owner, String phone, String pet, double total) {
        System.out.println(
                "Owner: " + owner +
                        ", Phone: " + phone +
                        ", Pet: " + pet +
                        ", Total: " + total
        );
    }
}
