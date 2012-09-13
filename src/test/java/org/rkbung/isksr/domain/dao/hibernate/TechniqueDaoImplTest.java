package org.rkbung.isksr.domain.dao.hibernate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.rkbung.isksr.domain.dao.TechniqueDao;
import org.rkbung.isksr.domain.model.Technique;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@ContextConfiguration(locations = "classpath:test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TechniqueDaoImplTest {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(TechniqueDaoImplTest.class);

    @Autowired
    private TechniqueDao techniqueDaoImpl;

    @Test
    public void testIntegration() throws Exception {
        Technique technique = new Technique();
        technique.setName("test nom");
        final Technique save = techniqueDaoImpl.save(technique);
        LOGGER.error("save {}", save);
        Collection<Technique> techniques = techniqueDaoImpl.getTechniques();
        assertThat(techniques.size(), is(1));
        techniqueDaoImpl.remove(technique);
        techniques = techniqueDaoImpl.searchByName("test");
        assertThat(techniques.size(), is(0));
    }
}
