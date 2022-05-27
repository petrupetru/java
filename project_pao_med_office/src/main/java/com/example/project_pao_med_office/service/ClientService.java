package com.example.project_pao_med_office.service;

import com.example.project_pao_med_office.model.Client;
import com.example.project_pao_med_office.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getClients(){return clientRepository.getClients();}
    public Client getClientById(int id){return clientRepository.getClientById(id);}
    public void addClient(Client client){clientRepository.addClient(client);}
    public void updateClient(int id, Client client){clientRepository.updateClient(id, client);}
    public void deleteClient(int id){clientRepository.deleteClient(id);}

}
