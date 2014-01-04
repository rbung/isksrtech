package org.rkbung.isksr.controller;

import org.rkbung.isksr.domain.model.Technique;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicLong;

@Controller
public class TechniqueController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TechniqueController.class);

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/technique")
    @ResponseBody
    public Technique get() {
        Technique result = new Technique();
        result.setId(counter.incrementAndGet());
        result.setName("name");
        LOGGER.info("Technique : {}", result);
        return result;
    }
}
