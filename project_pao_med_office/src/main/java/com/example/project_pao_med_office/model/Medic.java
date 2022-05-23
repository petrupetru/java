package com.example.project_pao_med_office.model;


import java.time.Instant;
import java.time.LocalTime;


public class Medic {
    private static int id_counter = 100;

    private Integer id;

    private String name;

    private String specialization;


    private String phone;

    private String mail;

    private Instant hireDate;


    private LocalTime programStart;


    private LocalTime programEndl;

    public Medic() {
        Medic.id_counter++;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Instant getHireDate() {
        return hireDate;
    }

    public void setHireDate(Instant hireDate) {
        this.hireDate = hireDate;
    }

    public LocalTime getProgramStart() {
        return programStart;
    }

    public void setProgramStart(LocalTime programStart) {
        this.programStart = programStart;
    }

    public LocalTime getProgramEndl() {
        return programEndl;
    }

    public void setProgramEndl(LocalTime programEndl) {
        this.programEndl = programEndl;
    }

    public static int getId_counter() {
        return id_counter;
    }

    public static void setId_counter(int id_counter) {
        Medic.id_counter = id_counter;
    }
}