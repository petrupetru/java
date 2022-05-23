package com.example.project_pao_med_office.controller;

import com.example.project_pao_med_office.model.Medic;
import com.example.project_pao_med_office.service.MedicService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MedicController {
    private final MedicService medicService;

    public MedicController(MedicService medicService) {
        this.medicService = medicService;
    }

    @GetMapping("/medics")
    public List<Medic> getMedics(){return medicService.getMedics();}
    @GetMapping("/medics/{id}")
    public Medic getMedicById(@PathVariable int id){
        return medicService.getMedicById(id);
    }
    @PostMapping(value="/add-medic",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public void addMedic(@RequestBody Medic medic){
        medicService.addMedic(medic);
    }

}
