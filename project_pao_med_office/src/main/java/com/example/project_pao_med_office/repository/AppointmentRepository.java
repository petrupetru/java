package com.example.project_pao_med_office.repository;

import com.example.project_pao_med_office.model.Appointment;
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
public class AppointmentRepository {
    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;
    public List<Appointment> getAppointments() {
        String query = "SELECT * FROM appointments";
        List<Appointment> appointments = new ArrayList<Appointment>();
        try (Connection con = DriverManager.getConnection(url, username, password))
        {
            var statement = con.prepareStatement(query);
            ResultSet res = statement.executeQuery();

            while (res.next())
            {
                Appointment appointment = new Appointment();
                appointment.setId(res.getInt("idappointments"));
                appointment.setIdmedic(res.getInt("idmedic"));
                appointment.setIdclient(res.getInt("idclient"));
                appointment.setDate(res.getObject("date", LocalDate.class));
                appointment.setTime(res.getObject("time", LocalTime.class));
                appointment.setDuration(res.getObject("duration", LocalTime.class));
                appointments.add(appointment);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return appointments;
    }

    public Appointment getAppointmentById(int id) {
        String query = "SELECT * FROM appointments WHERE id = " + id;
        Appointment appointment = new Appointment();
        try (Connection con = DriverManager.getConnection(url, username, password))
        {
            var statement = con.prepareStatement(query);
            ResultSet res = statement.executeQuery();

            while (res.next())
            {
                appointment.setId(res.getInt("idappointments"));
                appointment.setIdmedic(res.getInt("idmedic"));
                appointment.setIdclient(res.getInt("idclient"));
                appointment.setDate(res.getObject("date", LocalDate.class));
                appointment.setTime(res.getObject("time", LocalTime.class));
                appointment.setDuration(res.getObject("duration", LocalTime.class));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return appointment;
    }

    public void addAppointment(Appointment appointment){
        String query = "INSERT INTO `medical_office`.`appointments` (`idappointments`, `idmedic`, `idclient`, `date`," +
                " `time`, `duration`) VALUES ( ?, ?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(url, username, password)) {

            var statement = con.prepareStatement(query);
            statement.setString(1, String.valueOf(appointment.getId_counter()));
            statement.setString(2, appointment.getIdmedic().toString());
            statement.setString(3, appointment.getIdclient().toString());
            statement.setString(4, appointment.getDate().toString());
            statement.setString(5, appointment.getTime().toString());
            statement.setString(6, appointment.getDuration().toString());


            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMedic(int id, Appointment appointment){
        String query = "UPDATE appointments SET idmedic = ?, idclient = ?, date = ?, time = ?," +
                " duration = ? WHERE idappointments = " + id;
        try (Connection con = DriverManager.getConnection(url, username, password)) {

            var statement = con.prepareStatement(query);
            statement.setString(1, appointment.getIdmedic().toString());
            statement.setString(2, appointment.getIdclient().toString());
            statement.setString(3, appointment.getDate().toString());
            statement.setString(4, appointment.getTime().toString());
            statement.setString(5, appointment.getDuration().toString());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMedic(int id){
        String query = "DELETE FROM appointments WHERE idappointments = " + id;
        try(Connection con = DriverManager.getConnection(url, username, password)) {

            var statement = con.prepareStatement(query);
            statement.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }


}