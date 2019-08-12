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
        countriesBySize.sort((c1, c2) -> c1.getPopulation().compareTo(c2.getPopulation()));
        return new ResponseEntity<>(countriesBySize, HttpStatus.OK);
    }


}
