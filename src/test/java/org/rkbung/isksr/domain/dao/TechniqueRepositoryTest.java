package org.rkbung.isksr.domain.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.rkbung.isksr.domain.model.Technique;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(locations = "classpath:test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class TechniqueRepositoryTest {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(TechniqueRepositoryTest.class);

    @Autowired
    private TechniqueRepository techniqueRepository;

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
        techniqueRepository.save(technique1);
        techniqueRepository.save(technique2);
        techniqueRepository.save(technique3);
        techniqueRepository.save(technique4);
        techniqueRepository.save(technique5);
        long count = techniqueRepository.count();
        assertThat(count).isEqualTo(5);
    }
}
