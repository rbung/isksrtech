package org.rkbung.isksr.domain.dao;

import org.rkbung.isksr.domain.model.Technique;

import java.util.Collection;
import java.util.List;

public interface TechniqueDao {
    Collection<Technique> getTechniques();

    Technique getById(int id);

    Technique save(Technique technique);

    Collection<Technique> searchByName(String name);

    Technique remove(Technique technique);
}
