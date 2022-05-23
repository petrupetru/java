package com.example.project_pao_med_office.service;

import com.example.project_pao_med_office.repository.AnalyzeRepository;
import org.springframework.stereotype.Service;

@Service
public class AnalyzeService {
    private final AnalyzeRepository analyzeRepository;

    public AnalyzeService(AnalyzeRepository analyzeRepository) {
        this.analyzeRepository = analyzeRepository;
    }
}
