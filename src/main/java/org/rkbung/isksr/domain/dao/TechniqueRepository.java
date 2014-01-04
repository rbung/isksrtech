package org.rkbung.isksr.domain.dao;

import org.rkbung.isksr.domain.model.Technique;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TechniqueRepository extends CrudRepository<Technique, Long> {
    List<Technique> findByName(String name);
}
