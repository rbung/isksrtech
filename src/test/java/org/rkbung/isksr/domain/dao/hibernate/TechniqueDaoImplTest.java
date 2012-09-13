package org.rkbung.isksr.domain.dao.hibernate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.rkbung.isksr.domain.dao.TechniqueDao;
import org.rkbung.isksr.domain.model.Technique;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@ContextConfiguration(locations = "classpath:test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TechniqueDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(TechniqueDaoImplTest.class);

    @Autowired
    private TechniqueDao techniqueDaoImpl;

    @Test
    public void testIntegration() throws Exception {
        Technique technique1 = new Technique();
        technique1.setName("technique1");
        Technique technique2 = new Technique();
        technique2.setName("technique2");
        Technique technique3 = new Technique();
        technique3.setName("technique3");
        Technique technique4 = new Technique();
        technique4.setName("search1");
        Technique technique5 = new Technique();
        technique5.setName("2search");
        techniqueDaoImpl.save(technique1);
        techniqueDaoImpl.save(technique2);
        LOGGER.info("before save {}", technique3);
        techniqueDaoImpl.save(technique3);
        LOGGER.info("after save {}", technique3);
        techniqueDaoImpl.save(technique4);
        techniqueDaoImpl.save(technique5);
        Collection<Technique> techniques = techniqueDaoImpl.getTechniques();
        assertThat(techniques.size(), is(5));
        techniques = techniqueDaoImpl.searchByName("search");
        assertThat(techniques.size(), is(2));
        technique3.setName("search3");
        LOGGER.info("before update {}", technique3);
        techniqueDaoImpl.update(technique3);
        LOGGER.info("after update {}", technique3);
        techniques = techniqueDaoImpl.searchByName("search");
        assertThat(techniques.size(), is(3));
    }
}
