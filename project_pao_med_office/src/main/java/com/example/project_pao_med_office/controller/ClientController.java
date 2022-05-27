package com.example.project_pao_med_office.controller;

import com.example.project_pao_med_office.model.Client;
import com.example.project_pao_med_office.model.Medic;
import com.example.project_pao_med_office.service.ClientService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clients")
    public List<Client> getClients(){return clientService.getClients();}

    @GetMapping("/clients/{id}")
    public Client getClientById(@PathVariable int id){
        return clientService.getClientById(id);
    }

    @PostMapping(value="/add-client",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void addClient(@RequestBody Client client){clientService.addClient(client);}


    @PatchMapping(value = "/update-client/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateMedic(@PathVariable int id, @RequestBody Client client){
         clientService.updateClient(id, client);
    }

    @PatchMapping("/delete-client/{id}")
    public void deleteClient(@PathVariable int id){
        clientService.deleteClient(id);
    }
}
