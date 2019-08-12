package com.lambdaschool.countries;

import java.util.ArrayList;

public class CountryList
{
    public ArrayList<Country> countryList = new ArrayList<>();

    public CountryList()
    {
        countryList.add(new Country("China",1420062022,9388211,39));
        countryList.add(new Country("India",1368737513,2973190,28));
        countryList.add(new Country("U.S.",329093110,9147420,38));
        countryList.add(new Country("Indonesia",269536482,1811570,29));
        countryList.add(new Country("Brazil",212392717,8358140,33));
        countryList.add(new Country("Pakistan",204596442,770880,23));
        countryList.add(new Country("Nigeria",200962417,910770,18));
        countryList.add(new Country("Bangladesh",168065920,130170,27));
        countryList.add(new Country("Russia",143895551,16376870,40));
        countryList.add(new Country("Mexico",132328035,1943950,29));
        countryList.add(new Country("Japan",126854745,364555,48));
        countryList.add(new Country("Ethiopia",110135635,1000000,20));
    }

    public Country findCountry(CountryChecker tester)
    {
        for (Country c : countryList)
        {
            if(tester.test(c))
            {
                return c;
            }
        }
        return null;
    }

    public ArrayList<Country> findCountries(CountryChecker tester)
    {
        public ArrayList<Country> tempCountryList = new ArrayList<>();
        for (Country c : countryList)
        {
            if(tester.test(c))
            {
                tempCountryList.add(c);
            }
        }
        return tempCountryList;
    }
}
