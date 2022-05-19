package com.App;

import com.Entity.City;
import com.Entity.Continent;
import com.Entity.Country;
import com.Repository.CityRepository;
import com.Repository.ContinentRepository;
import com.Repository.CountryRepository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    private static final String path = "D:\\Facultate\\An2Sem2\\PA---Java\\Lab9Homework\\concap.csv";

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line = bufferedReader.readLine();
            line = bufferedReader.readLine();
            City city;
            Country country;
            Continent continent;
            while (line != null) {
                city = new City();
                country = new Country();
                continent = new Continent();
                String[] data = line.split(",");

                if (new ContinentRepository().findByName(data[5]).isEmpty()) {
                    continent.setName(data[5]);
                    new ContinentRepository().create(continent);
                }
                else
                {
                    continent=new ContinentRepository().findByName(data[5]).get(0);
                }

                if (new CountryRepository().findByName(data[0]).isEmpty()) {
                    country.setName(data[0]);
                    country.setCode(data[4]);
                    country.setContinent(continent);
                    new CountryRepository().create(country);
                }
                else
                {
                    country=new CountryRepository().findByName(data[0]).get(0);
                }

                city.setCountry(country);
                city.setName(data[1]);
                city.setCapital(true);
                city.setLatitude(Double.parseDouble(data[2]));
                city.setLongitude(Double.parseDouble(data[3]));
                new CityRepository().create(city);

                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}