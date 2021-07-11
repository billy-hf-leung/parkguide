package com.parkguide.app.restservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class parkguideController {

    @GetMapping(value = "/retrieveCarparks", produces = {"application/json"})
    public ResponseEntity<String> retrieveCarparks(@RequestParam(required=false, value = "data") String data
                                                ,@RequestParam(required=false, value = "vehicleTypes") String vehicleTypes
                                                ,@RequestParam(required=false, value = "carparkIds") String carparkIds
                                                ,@RequestParam(required=false, value = "extent") String extent
                                                ,@RequestParam(required=false, value = "lang") String lang) throws Exception{

        RestTemplate restTemplate = new RestTemplate();
        String sourceUrl = "http://api.data.gov.hk/v1/carpark-info-vacancy?"
                + "data=" + data
                + "&vehicleTypes=" + vehicleTypes
                + "&carparkIds=" + carparkIds
                + "&extent=" + extent
                + "&lang=" + lang;

        ResponseEntity<String> response = restTemplate.getForEntity(sourceUrl, String.class);

        return response;
    }
}
