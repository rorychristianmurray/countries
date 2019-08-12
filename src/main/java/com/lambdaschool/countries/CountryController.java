package com.lambdaschool.countries;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // managed by Spring Boot - mappings of end points - annotation
@RequestMapping("/data") // all endpoints start with /data

public class CountryController
{
    // localhost:2019/data/allcountries
    // returns JSON object with all countries data
    @GetMapping(value = "/allcountries", produces ={"application/json"})
    public ResponseEntity<?> getAllCountries()
    {
        return new ResponseEntity<>(CountriesApplication.ourCountryList.countryList, HttpStatus.OK);
    }

}
