package com.example.project_pao_med_office.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public class LabTest {
    private static int id_counter = 100;

    public LabTest() {
        id_counter++;
    }

    public static int getId_counter() {
        return id_counter;
    }

    private Integer id;

    private String type;

    private String resultDescription;

    private Integer idtest;

    private Integer idclient;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getResultDescription() {
        return resultDescription;
    }

    public void setResultDescription(String resultDescription) {
        this.resultDescription = resultDescription;
    }

    public Integer getIdtest() {
        return idtest;
    }

    public void setIdtest(Integer idtest) {
        this.idtest = idtest;
    }

    public Integer getIdclient() {
        return idclient;
    }

    public void setIdclient(Integer idclient) {
        this.idclient = idclient;
    }

}