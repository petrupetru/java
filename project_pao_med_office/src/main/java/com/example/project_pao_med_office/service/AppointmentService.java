package com.example.project_pao_med_office.service;

import com.example.project_pao_med_office.model.Appointment;
import com.example.project_pao_med_office.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> getAppointments(){return appointmentRepository.getAppointments();}

    public Appointment getAppointmentById(int id){return appointmentRepository.getAppointmentById(id);}

    public void addAppointment(Appointment appointment){appointmentRepository.addAppointment(appointment);}

    public void updateAppointment(int id, Appointment appointment){appointmentRepository.updateMedic(id, appointment);}

    public void deleteAppointment(int id){appointmentRepository.deleteMedic(id);}


}
