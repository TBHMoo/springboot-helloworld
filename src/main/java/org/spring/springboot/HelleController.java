package org.spring.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xli on 2017/3/2.
 */
@RestController
public class HelleController {

    @RequestMapping("/*")
    public String hello(@RequestParam(value = "name",defaultValue = "xoo")String name){
        return "hello"+name;
    }
}
