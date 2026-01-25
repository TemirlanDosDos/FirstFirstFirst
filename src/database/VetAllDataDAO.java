package database;

import model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;

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

        Connection c = DatabaseConnection.getConnection();

        try (PreparedStatement ps = c.prepareStatement(sql)) {

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
            DatabaseConnection.close(c);
        }
    }
}
