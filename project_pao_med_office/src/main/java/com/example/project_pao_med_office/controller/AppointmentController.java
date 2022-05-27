package com.example.project_pao_med_office.controller;


import com.example.project_pao_med_office.model.Appointment;
import com.example.project_pao_med_office.model.Medic;
import com.example.project_pao_med_office.service.AppointmentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AppointmentController {
     private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }
    @GetMapping("/appointments")
    public List<Appointment> getAppointments(){return appointmentService.getAppointments();}

    @GetMapping("/appointments/{id}")
    public Appointment getAppointmentById(@PathVariable int id){
        return appointmentService.getAppointmentById(id);
    }

    @PostMapping(value="/add-appointment",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void addAppointment(@RequestBody Appointment appointment){
        appointmentService.addAppointment(appointment);
    }


    @PatchMapping(value = "/update-appointment/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateAppointment(@PathVariable int id, @RequestBody Appointment appointment){
        appointmentService.updateAppointment(id, appointment);
    }

    @PatchMapping("/delete-appointment/{id}")
    public void deleteAppointmenr(@PathVariable int id){
        appointmentService.deleteAppointment(id);
    }

}
