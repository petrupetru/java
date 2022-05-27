package com.example.project_pao_med_office;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectPaoMedOfficeApplication {
    /*
    * proiect java medical office:
    * endpoints: /api/{class}s ->get all from class
    *            /api/{class}s/id ->get from class with id
    *            /api/add-{class} -> add object
    *            /api/update-{class}/id -> update object with id = id
    *            /api/delete-{class} -> delete object with id = id
    * {class} = medic, client, appointment, labtest

     */

    public static void main(String[] args) {
        SpringApplication.run(ProjectPaoMedOfficeApplication.class, args);
    }

}
