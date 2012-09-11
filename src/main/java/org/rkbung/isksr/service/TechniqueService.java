package org.rkbung.isksr.service;

import org.rkbung.isksr.domain.model.Technique;

public interface TechniqueService {
    public Technique get(String name);

    public boolean delete (String name);

    public boolean update (Technique technique);

    public boolean create(Technique technique);
}
