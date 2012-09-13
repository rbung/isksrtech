package org.rkbung.isksr.domain.dao.hibernate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.rkbung.isksr.domain.dao.TechniqueDao;
import org.rkbung.isksr.domain.model.Technique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;

@ContextConfiguration(locations = "classpath:test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TechniqueDaoImplTest {
    @Autowired
    private TechniqueDao techniqueDaoImpl;

    @Test
    public void testIntegration() throws Exception {
        Technique technique = new Technique();
        technique.setName("test nom");
        techniqueDaoImpl.save(technique);
        Collection<Technique> techniques = techniqueDaoImpl.searchByName("test");
        techniqueDaoImpl.remove(technique);
        techniques = techniqueDaoImpl.searchByName("test");
    }
}
