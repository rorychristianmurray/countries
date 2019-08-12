package com.lambdaschool.countries;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

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

//    // localhost:2019/data/country/{id}
//    // returns JSON object with country data by id
    @GetMapping(value = "/country/{id}", produces ={"application/json"})
    public ResponseEntity<?> getCountryDetail(@PathVariable long id)
    {
        Country rtnCountry = CountriesApplication.ourCountryList.findCountry(c -> (c.getId() == id));
        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
    }

//    // localhost:2019/data/names/all
//    // returns JSON object with all countries sorted by name alphabetically
//    @GetMapping(value = "/names/all", produces = {"application/json"})
//    public ResponseEntity<?> getCountryNames()
//    {
//        // return new response entity calling method here
//        ArrayList<Country> countryNames = CountriesApplication.ourCountryList.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
//
//
//
//        ArrayList<Country> countryNames = CountriesApplication.ourCountryList.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
//        return new ResponseEntity<>(countryNames, HttpStatus.OK);
//    }

}
