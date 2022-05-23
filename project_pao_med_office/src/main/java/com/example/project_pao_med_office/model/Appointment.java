package com.example.project_pao_med_office.model;


import java.time.LocalDate;
import java.time.LocalTime;


public class Appointment {
    private Integer id;

    private Integer idmedic;


    private Integer idclient;

    private LocalDate date;

    private LocalTime time;


    private LocalTime duration;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdmedic() {
        return idmedic;
    }

    public void setIdmedic(Integer idmedic) {
        this.idmedic = idmedic;
    }

    public Integer getIdclient() {
        return idclient;
    }

    public void setIdclient(Integer idclient) {
        this.idclient = idclient;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

}