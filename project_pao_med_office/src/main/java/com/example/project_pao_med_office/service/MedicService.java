package com.example.project_pao_med_office.service;

import com.example.project_pao_med_office.model.Medic;
import com.example.project_pao_med_office.repository.MedicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicService {
    private final MedicRepository medicRepository;

    public MedicService(MedicRepository medicRepository) {
        this.medicRepository = medicRepository;
    }

    public List<Medic> getMedics(){return medicRepository.getMedics();}

    public Medic getMedicById(int id){
        return medicRepository.getMedicById(id);
    }

    public void addMedic(Medic medic){
        medicRepository.addMedic(medic);
    }

    public void updateMedic(int id, Medic medic){medicRepository.updateMedic(id, medic);}

    public void deletemedic(int id){medicRepository.deleteMedic(id);}
}
