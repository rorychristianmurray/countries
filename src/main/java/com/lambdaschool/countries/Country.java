package com.lambdaschool.countries;

import java.util.concurrent.atomic.AtomicLong;

public class Country
{
    // id
    // name
    // population
    // land mass size
    // median age (either of 2 mids if even or 1 mid if odd)
    private static final AtomicLong counter = new AtomicLong();
    private long id;
    private String name;
    private int population;
    private int landMass;
    private int medianAge;

    public Country(String name, int population, int landMass, int medianAge)
    {
        this.id = counter.incrementAndGet();
        this.name = name;
        this.population = population;
        this.landMass = landMass;
        this.medianAge = medianAge;
    }

    public Country(Country toClone)
    {
        this.id = counter.incrementAndGet();
        this.name = toClone.name;
        this.population = toClone.population;
        this.landMass = toClone.landMass;
        this.medianAge = toClone.medianAge;
    }

    public long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getPopulation()
    {
        return population;
    }

    public void setPopulation(int population)
    {
        this.population = population;
    }

    public int getLandMass()
    {
        return landMass;
    }

    public void setLandMass(int landMass)
    {
        this.landMass = landMass;
    }

    public int getMedianAge()
    {
        return medianAge;
    }

    public void setMedianAge(int medianAge)
    {
        this.medianAge = medianAge;
    }

    @Override
    public String toString()
    {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", population=" + population +
                ", landMass=" + landMass +
                ", medianAge=" + medianAge +
                '}';
    }
}
