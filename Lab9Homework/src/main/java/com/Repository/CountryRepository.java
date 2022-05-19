package com.Repository;

import com.Entity.Country;

public class CountryRepository extends AbstractRepository<Country> {
    public CountryRepository() {
        super(Country.class);
    }
}
