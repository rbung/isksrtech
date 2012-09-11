package org.rkbung.isksr.domain.dao.hibernate;

import org.rkbung.isksr.domain.dao.TechniqueDao;
import org.rkbung.isksr.domain.model.Technique;
import org.springframework.orm.jpa.JpaCallback;
import org.springframework.orm.jpa.support.JpaDaoSupport;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import java.util.Collection;

public class TechniqueDaoImpl extends JpaDaoSupport implements TechniqueDao {
    @Override
    public Collection<Technique> getTechniques() {
        return getJpaTemplate().execute(new JpaCallback<Collection<Technique>>() {
            @Override
            public Collection<Technique> doInJpa(EntityManager entityManager) throws PersistenceException {
                Query q = entityManager.createQuery("SELECT h FROM " +
                        Technique.class.getName() + " h");
                return q.getResultList();
            }
        });
    }

    @Override
    public Collection<Technique> searchByName(final String name) {
        return getJpaTemplate().execute(new JpaCallback<Collection<Technique>>() {
            @Override
            public Collection<Technique> doInJpa(EntityManager entityManager) throws PersistenceException {
                Query q = entityManager.createQuery("SELECT h FROM " +
                        Technique.class.getName() + " h WHERE h.name LIKE %" + name + "%");
                return q.getResultList();
            }
        });
    }

    @Override
    public Technique getById(int id) {
        return getJpaTemplate().find(Technique.class, id);
    }

    @Override
    public Technique save(Technique technique) {
        getJpaTemplate().persist(technique);
        return technique;
    }

    @Override
    public Technique remove(Technique technique) {
        getJpaTemplate().remove(technique);
        return technique;
    }
}
