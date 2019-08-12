package com.lambdaschool.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController // managed by Spring Boot - mappings of end points - annotation
@RequestMapping("/data") // all endpoints start with /data
public class PopulationController
{
    // localhost:2019/data/population/size/{people}
    // returns JSON object with countries of pop size larger than int people
    @GetMapping(value = "/population/size/{people}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesBySize(@PathVariable int people)
    {
        ArrayList<Country> countriesBySize = CountriesApplication.ourCountryList.findCountries(c -> (c.getPopulation() >= people));
//        countriesBySize.sort((c1, c2) -> c1.getPopulation().compareTo(c2.getPopulation()));
        return new ResponseEntity<>(countriesBySize, HttpStatus.OK);
    }

    // localhost:2019/data/population/min
    // returns JSON object with the country with smallest population
    @GetMapping(value = "/population/min", produces = {"application/json"})
    public ResponseEntity<?> getCountryMin()
    {
        CountriesApplication.ourCountryList.countryList.sort((c1, c2) -> c1.getPopulation() - c2.getPopulation());
        // Gets item at index 0 in countryList ArrayList which is an object of Country type
        Country minCountry = CountriesApplication.ourCountryList.countryList.get(0);
        return new ResponseEntity<>(minCountry, HttpStatus.OK);
    }

    // localhost:2019/data/population/max
    // returns JSON object with the country with largest population
    @GetMapping(value = "/population/max", produces = {"application/json"})
    public ResponseEntity<?> getCountryMax()
    {
        CountriesApplication.ourCountryList.countryList.sort((c1, c2) -> c2.getPopulation() - c1.getPopulation());
        // Gets item at index 0 in countryList ArrayList which is an object of Country type
        // int lastIndex = CountriesApplication.ourCountryList.countryList.length - 1
        Country maxCountry = CountriesApplication.ourCountryList.countryList.get(0);
        return new ResponseEntity<>(maxCountry, HttpStatus.OK);
    }

    // localhost:2019/data/population/median
    // returns JSON object with the country with the median population
    @GetMapping(value = "/population/max", produces = {"application/json"})
    public ResponseEntity<?> getCountryMax()
    {

    }


}
