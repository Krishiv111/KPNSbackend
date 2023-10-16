

package com.nighthawk.spring_portfolio.mvc.cancer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cancer {
    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String cancerType;

    // Attributes
    
    private int numOfPeopleAffected;
    private double deathRate;
    private int averageRecoveryTime;
    private String symptoms;

    // Array Setup
    public static Cancer[] init() {
        final Cancer[] cancersArray = {
            new Cancer("Breast", 276480, 0.142, 4, "Lump in the breast, change in breast size or shape, nipple discharge, skin changes"),
            new Cancer("Lung", 235760, 0.254, 5, "Persistent cough, chest pain, shortness of breath, coughing up blood"),
            new Cancer("Kidney", 76120, 0.044, 5, "Blood in urine, back pain, weight loss, fatigue"),
            new Cancer("Colon", 149500, 0.090, 6, "Change in bowel habits, rectal bleeding, abdominal pain, fatigue"),
            new Cancer("Leukemia", 60960, 0.183, 3, "Fatigue, frequent infections, easy bleeding or bruising, weight loss"),
            new Cancer("Prostate", 248530, 0.041, 5, "Frequent urination, difficulty starting or stopping urination, blood in urine or semen"),
            new Cancer("Thyroid", 41120, 0.007, 4, "Neck lump, hoarseness, difficulty swallowing, unexplained weight loss"),
            new Cancer("Liver", 42820, 0.162, 7, "Jaundice, abdominal pain, unexplained weight loss, fatigue"),
            new Cancer("Stomach", 26950, 0.098, 5, "Indigestion, abdominal pain, unexplained weight loss, nausea"),
            new Cancer("Skin", 106110, 0.015, 4, "Changes in the skin, moles, or birthmarks, sores that won't heal, unusual bleeding or changes in existing moles"),
            new Cancer("Pancreatic", 60940, 0.077, 6, "Jaundice, abdominal pain, unexplained weight loss, fatigue"),
            new Cancer("Ovarian", 219440, 0.061, 5, "Abdominal bloating, pelvic pain, feeling full quickly, frequent urination"),
            new Cancer("Bladder", 83460, 0.030, 4, "Blood in urine, frequent urination, pain during urination, back or pelvic pain"),
            new Cancer("Small Intestine", 12340, 0.057, 5, "Abdominal pain, unexplained weight loss, blood in stool, fatigue"),
            new Cancer("Brain Cancer", 24260, 0.158, 4, "Headaches, seizures, changes in vision, difficulty with balance or walking")
        };
        return cancersArray;
    }


    public Cancer(String cancerType, int numOfPeopleAffected, double deathRate, int averageRecoveryTime, String symptoms) {
        this.cancerType = cancerType;
        this.numOfPeopleAffected = numOfPeopleAffected;
        this.deathRate = deathRate;
        this.averageRecoveryTime = averageRecoveryTime;
        this.symptoms = symptoms;
    }
}

