package com.example.project_pao_med_office.repository;

import com.example.project_pao_med_office.model.Appointment;
import com.example.project_pao_med_office.model.LabTest;
import com.example.project_pao_med_office.model.Medic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LabTestRepository {
    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;

    public List<LabTest> getLabTest() {
        String query = "SELECT * FROM LabTest";
        List<LabTest> labTests = new ArrayList<LabTest>();
        try (Connection con = DriverManager.getConnection(url, username, password))
        {
            var statement = con.prepareStatement(query);
            ResultSet res = statement.executeQuery();

            while (res.next())
            {
                LabTest labTest = new LabTest();
                labTest.setId(res.getInt("idlabtests"));
                labTest.setType(res.getString("type"));
                labTest.setResultDescription(res.getString("result_description"));
                labTest.setIdtest(res.getInt("idtest"));
                labTest.setIdclient(res.getInt("idclient"));

                labTests.add(labTest);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return labTests;
    }

    public LabTest getLabTestById(int id) {
        String query = "SELECT * FROM LabTest where id = " + id;
        LabTest labTest = new LabTest();
        try (Connection con = DriverManager.getConnection(url, username, password))
        {
            var statement = con.prepareStatement(query);
            ResultSet res = statement.executeQuery();

            while (res.next())
            {
                labTest.setId(res.getInt("idlabtests"));
                labTest.setType(res.getString("type"));
                labTest.setResultDescription(res.getString("result_description"));
                labTest.setIdtest(res.getInt("idtest"));
                labTest.setIdclient(res.getInt("idclient"));

            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return labTest;
    }

    public void addLabTest(LabTest labTest){
        String query = "INSERT INTO `medical_office`.`labtests` (`idlabtests`, `type`, `result_description`, `idtest`," +
                " `idclient`) VALUES ( ?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(url, username, password)) {

            var statement = con.prepareStatement(query);
            statement.setString(1, String.valueOf(labTest.getId_counter()));
            statement.setString(2, labTest.getType());
            statement.setString(3, labTest.getResultDescription());
            statement.setString(4, labTest.getIdtest().toString());
            statement.setString(5, labTest.getIdclient().toString());


            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateLbtest(int id, LabTest labTest){
        String query = "UPDATE labtests SET type = ?, result_description = ?, idtest = ?, idclient = ?," +
                " WHERE idappointments = " + id;
        try (Connection con = DriverManager.getConnection(url, username, password)) {

            var statement = con.prepareStatement(query);
            statement.setString(1, labTest.getType());
            statement.setString(2, labTest.getResultDescription());
            statement.setString(3, labTest.getIdtest().toString());
            statement.setString(4, labTest.getIdclient().toString());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteLabTest(int id){
        String query = "DELETE FROM labtests WHERE idlabtests = " + id;
        try(Connection con = DriverManager.getConnection(url, username, password)) {

            var statement = con.prepareStatement(query);
            statement.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }





}