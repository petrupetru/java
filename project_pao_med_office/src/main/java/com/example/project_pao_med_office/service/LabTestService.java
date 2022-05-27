package com.example.project_pao_med_office.service;

import com.example.project_pao_med_office.model.LabTest;
import com.example.project_pao_med_office.repository.LabTestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabTestService {
    private final LabTestRepository labTestRepository;

    public LabTestService(LabTestRepository labTestRepository) {
        this.labTestRepository = labTestRepository;
    }

    public List<LabTest> getLabTests(){return labTestRepository.getLabTest();}
    public LabTest getLabTestById(int id){return labTestRepository.getLabTestById(id);}
    public void addLabTest(LabTest labTest){labTestRepository.addLabTest(labTest);}
    public void updateLabTest(int id, LabTest labTest){labTestRepository.updateLbtest(id, labTest);}
    public void deleteLabTest(int id){labTestRepository.deleteLabTest(id);}
}
