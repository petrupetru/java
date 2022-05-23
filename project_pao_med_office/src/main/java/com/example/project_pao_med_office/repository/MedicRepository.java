package com.example.project_pao_med_office.repository;

import com.example.project_pao_med_office.model.Medic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MedicRepository {
    @Value("{db.url}")
    private String url;
    @Value("{db.username}")
    private String username;
    @Value("{db.password}")
    private String password;

    public List<Medic> getMedics() {
        String query = "SELECT * FROM MEDICS";
        List<Medic> medics = new ArrayList<Medic>();
        try (Connection con = DriverManager.getConnection(url, username, password))
        {
            var statement = con.prepareStatement(query);
            ResultSet res = statement.executeQuery();

            while (res.next())
            {
                Medic medic = new Medic();
                medic.setId(res.getInt("idmedics"));
                medic.setName(res.getString("name"));
                medic.setSpecialization(res.getString("specialization"));
                medic.setPhone(res.getString("phone"));
                medic.setMail(res.getString("mail"));
                medic.setHireDate(res.getObject("hire_date", Instant.class));
                medic.setProgramStart(res.getObject("program_start", LocalTime.class));
                medic.setProgramEndl(res.getObject("program_endl", LocalTime.class));
                medics.add(medic);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return medics;
    }

    public Medic getMedicById(int id){
        String query = "SELECT * FROM MEDICS WHERE idmedics = " + id;
        Medic medic = new Medic();
        try (Connection con = DriverManager.getConnection(url, username, password))
        {
            var statement = con.prepareStatement(query);
            ResultSet res = statement.executeQuery();

            res.next();

            medic.setId(res.getInt("idmedics"));
            medic.setName(res.getString("name"));
            medic.setSpecialization(res.getString("specialization"));
            medic.setPhone(res.getString("phone"));
            medic.setMail(res.getString("mail"));
            medic.setHireDate(res.getObject("hire_date", Instant.class));
            medic.setProgramStart(res.getObject("program_start", LocalTime.class));
            medic.setProgramEndl(res.getObject("program_endl", LocalTime.class));

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return medic;

    }

    public void addMedic(Medic medic){
        String query = "INSERT INTO `medical_office`.`medics` (`idmedics`, `name`, `specialization`, `phone`, `mail`, `hire_date`, `program_start`, `program_endl`) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(url, username, password)) {

            var statement = con.prepareStatement(query);
            statement.setString(1, String.valueOf(medic.getId_counter()));
            statement.setString(2, medic.getName());
            statement.setString(3, medic.getSpecialization());
            statement.setString(4, medic.getPhone());
            statement.setString(5, medic.getMail());
            statement.setString(6, medic.getHireDate().toString());
            statement.setString(7, medic.getProgramStart().toString());
            statement.setString(8, medic.getProgramEndl().toString());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
