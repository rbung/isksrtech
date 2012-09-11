package org.rkbung.isksr.domain.dao.hibernate;

import org.junit.Test;
import org.rkbung.isksr.domain.dao.TechniqueDao;
import org.rkbung.isksr.domain.model.Technique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(locations = "file:test-db.xml")
public class TechniqueDaoImplTest {
    @Autowired
    private TechniqueDao techniqueDaoImpl;

    @Test
    public void testIntegration() throws Exception {
        Technique technique = new Technique();
        technique.setName("test nom");
        techniqueDaoImpl.save(technique);
        techniqueDaoImpl.remove(technique);
    }
}
