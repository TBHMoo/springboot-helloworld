package org.spring.springboot;

import org.spring.springboot.aop.Tag;
import org.spring.springboot.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * Created by xli on 2017/3/2.
 */
@RestController
public class HelleController {

    private Logger logger = Logger.getLogger(getClass().toString());

    @Value("${city.name}")
    private String cityName;

    @Autowired
    private City city;

    @RequestMapping("/{name}")
    @Tag
    public String hello(@PathVariable(value = "name") String name ){
        logger.info("hello logger");
        return "hello "+name + "  I'm in " + cityName +"  to "+ city.getCityName() ;
    }

//    @RequestMapping("/{age}")
////    @Tag
//    public String age(@PathVariable(value = "age") Integer age ){
//        return "hello "+age;
//    }
}
