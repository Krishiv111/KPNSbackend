package com.nighthawk.spring_portfolio.mvc.memorial;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Memorial {
    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name; // Name of the loved one
    private int age;
    private String cancerType; // Type of cancer
    private String favoriteMemory;
    private String treatmentType; // Type of treatment underwent

    // Array Setup
    public static Memorial[] init() {
        final Memorial[] memorialsArray = {
            new Memorial("Pam Lee", 50, "Lung Cancer", "Fond memories of family vacations, and loved to take", "Chemotherapy"),
            // Add more memorials as needed
        };
        return memorialsArray;
    }

    public Memorial(String name, int age, String cancerType, String favoriteMemory, String treatmentType) {
        this.name = name;
        this.age = age;
        this.cancerType = cancerType;
        this.favoriteMemory = favoriteMemory;
        this.treatmentType = treatmentType;
    }
}
