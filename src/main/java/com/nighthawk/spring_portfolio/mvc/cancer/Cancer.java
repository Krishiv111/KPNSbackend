

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
    private int deaths;
    private int averageRecoveryTime;
    private String symptoms;

    // Array Setup
    public static Cancer[] init() {
        final Cancer[] cancersArray = {
            new Cancer("Breast", 300590, 43700, 4, "Lump in the breast, change in breast size or shape, nipple discharge, skin changes"),
            new Cancer("Lung", 238340, 127070, 5, "Persistent cough, chest pain, shortness of breath, coughing up blood"),
            new Cancer("Kidney", 81800, 14890, 5, "Blood in urine, back pain, weight loss, fatigue"),
            new Cancer("Colon", 153020, 52550, 6, "Change in bowel habits, rectal bleeding, abdominal pain, fatigue"),
            new Cancer("Leukemia", 59610, 23710, 3, "Fatigue, frequent infections, easy bleeding or bruising, weight loss"),
            new Cancer("Prostate", 288300, 34700, 5, "Frequent urination, difficulty starting or stopping urination, blood in urine or semen"),
            new Cancer("Thyroid", 43720, 2120, 4, "Neck lump, hoarseness, difficulty swallowing, unexplained weight loss"),
            new Cancer("Liver", 41210, 29380, 7, "Jaundice, abdominal pain, unexplained weight loss, fatigue"),
            new Cancer("Stomach", 26500, 11130, 5, "Indigestion, abdominal pain, unexplained weight loss, nausea"),
            new Cancer("Hodgkin Lymphoma", 8830, 900, 4, "Swollen glands, chest pain, cough or breathlessness, extreme tiredness"),
            new Cancer("Pancreatic", 64050, 50550, 6, "Jaundice, abdominal pain, unexplained weight loss, fatigue"),
            new Cancer("Ovarian", 19710, 13270, 5, "Abdominal bloating, pelvic pain, feeling full quickly, frequent urination"),
            new Cancer("Bladder", 82290, 16710, 4, "Blood in urine, frequent urination, pain during urination, back or pelvic pain"),
            new Cancer("Small Intestine", 12070, 2070, 5, "Abdominal pain, unexplained weight loss, blood in stool, fatigue"),
            new Cancer("Brain Cancer", 24810, 18990, 4, "Headaches, seizures, changes in vision, difficulty with balance or walking")
        };
        return cancersArray;
    }
    


    public Cancer(String cancerType, int numOfPeopleAffected, int deaths, int averageRecoveryTime, String symptoms) {
        this.cancerType = cancerType;
        this.numOfPeopleAffected = numOfPeopleAffected;
        this.deaths = deaths;
        this.averageRecoveryTime = averageRecoveryTime;
        this.symptoms = symptoms;
    }
}

