package com.example.project_pao_med_office.repository;

import com.example.project_pao_med_office.model.Client;
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
public class ClientRepository {
    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;
    public List<Client> getClients() {
        String query = "SELECT * FROM clients";
        List<Client> clients = new ArrayList<Client>();
        try (Connection con = DriverManager.getConnection(url, username, password))
        {
            var statement = con.prepareStatement(query);
            ResultSet res = statement.executeQuery();

            while (res.next())
            {
                Client client = new Client();
                client.setId(res.getInt("idclients"));
                client.setName(res.getString("name"));
                client.setPhone(res.getString("phone"));
                client.setMail(res.getString("mail"));
                client.setCnp(res.getString("cnp"));
                clients.add(client);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return clients;
    }

    public Client getClientById(int id){
        String query = "SELECT * FROM clients WHERE idcliets = " + id;
        Client client = new Client();
        try (Connection con = DriverManager.getConnection(url, username, password))
        {
            var statement = con.prepareStatement(query);
            ResultSet res = statement.executeQuery();

            res.next();
            client.setId(res.getInt("idclients"));
            client.setName(res.getString("name"));
            client.setPhone(res.getString("phone"));
            client.setMail(res.getString("mail"));
            client.setCnp(res.getString("cnp"));

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return client;

    }

    public void addClient(Client client){
        String query = "INSERT INTO `medical_office`.`clients` (`idclients`, `name`, `phone`," +
                " `mail`, `cnp`) VALUES ( ?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(url, username, password)) {

            var statement = con.prepareStatement(query);
            statement.setString(1, String.valueOf(client.getId_counter()));
            statement.setString(2, client.getName());
            statement.setString(3, client.getPhone());
            statement.setString(4, client.getMail());
            statement.setString(5, client.getCnp());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateClient(int id, Client client){
        String query = "UPDATE clients SET name = ?, phone = ?, mail = ?," +
                " cnp = ? WHERE idclients = " + id;
        try (Connection con = DriverManager.getConnection(url, username, password)) {

            var statement = con.prepareStatement(query);
            statement.setString(1, client.getName());
            statement.setString(2, client.getPhone());
            statement.setString(3, client.getMail());
            statement.setString(4, client.getCnp());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteClient(int id){
        String query = "DELETE FROM clients WHERE idclients = " + id;
        try(Connection con = DriverManager.getConnection(url, username, password)) {

            var statement = con.prepareStatement(query);
            statement.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}