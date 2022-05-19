package com.Repository;

import com.Entity.Continent;

public class ContinentRepository extends AbstractRepository<Continent> {
    public ContinentRepository() {
        super(Continent.class);
    }

    @Override
    public void create(Continent object) {
        if (findByName(object.getName()).isEmpty())
            super.create(object);
    }
}
