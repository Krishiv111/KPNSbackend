package com.nighthawk.spring_portfolio.mvc.cancer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClinicalTrialsService {

    @Value("${clinical.trials.api.base.url}")
    private String apiUrl;

    public String getClinicalTrials(String query) {
        RestTemplate restTemplate = new RestTemplate();
        String url = apiUrl + "?expr=" + query;
        return restTemplate.getForObject(url, String.class);
    }
}
