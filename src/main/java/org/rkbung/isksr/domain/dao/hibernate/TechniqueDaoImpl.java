package org.rkbung.isksr.domain.dao.hibernate;

import org.rkbung.isksr.domain.dao.TechniqueDao;
import org.rkbung.isksr.domain.model.Technique;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;

public class TechniqueDaoImpl implements TechniqueDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Technique> getTechniques() {
        return entityManager.createQuery("SELECT t FROM Technique t").getResultList();
    }

    @Override
    public Collection<Technique> searchByName(final String name) {
        return entityManager.createQuery("SELECT t FROM Technique t WHERE t.name LIKE :name").setParameter("name", "%" + name + "%").getResultList();
    }

    @Override
    public Technique getById(int id) {
        return entityManager.find(Technique.class, id);
    }

    @Override
    public Technique save(Technique technique) {
        entityManager.persist(technique);
        return technique;
    }

    @Override
    public Technique remove(Technique technique) {
        entityManager.remove(technique);
        return technique;
    }

    @Override
    public Technique update(Technique technique) {
        entityManager.merge(technique);
        return technique;
    }
}
