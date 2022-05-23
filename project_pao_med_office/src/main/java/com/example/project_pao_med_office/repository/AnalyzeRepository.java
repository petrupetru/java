package com.example.project_pao_med_office.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class AnalyzeRepository {
    @Value("{db.url}")
    private String url;
    @Value("{db.username}")
    private String username;
    @Value("{db.password}")
    private String password;


}