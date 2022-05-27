package com.example.project_pao_med_office.controller;

import com.example.project_pao_med_office.model.LabTest;
import com.example.project_pao_med_office.model.Medic;
import com.example.project_pao_med_office.service.LabTestService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LabTestController {
    private final LabTestService labTestService;

    public LabTestController(LabTestService labTestService) {
        this.labTestService = labTestService;
    }

    @GetMapping("/labtests")
    public List<LabTest> getLabTests(){return labTestService.getLabTests();}

    @GetMapping("/labtests/{id}")
    public LabTest getLabTestsById(@PathVariable int id){
        return labTestService.getLabTestById(id);
    }

    @PostMapping(value="/add-labtest",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void addLabTest(@RequestBody LabTest labTest){
        labTestService.addLabTest(labTest);
    }


    @PatchMapping(value = "/update-labtest/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateLabTest(@PathVariable int id, @RequestBody LabTest labTest){
        labTestService.updateLabTest(id, labTest);
    }

    @PatchMapping("/delete-medic/{id}")
    public void deleteLabTest(@PathVariable int id){
        labTestService.deleteLabTest(id);
    }

}
