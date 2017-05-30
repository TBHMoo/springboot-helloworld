package org.spring.springboot.controller;

import org.spring.springboot.domain.User;
import org.spring.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xli on 2017/5/19.
 */

@RestController
public class UserRestController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/api/user" ,method = RequestMethod.GET )
    @ResponseBody
    public User findByName(@RequestParam(value = "userName", required = true) String userName){
        return userService.findByName(userName);
    }

}
