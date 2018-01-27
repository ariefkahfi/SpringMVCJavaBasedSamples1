package com.arief.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/form-user",method = RequestMethod.GET)
    public String formUserGET(){
        return "user/form-user";
    }
    @RequestMapping(value = "/form-user",method = RequestMethod.POST)
    public String formUserPOST(){
        return "redirect:";
    }

    @RequestMapping("/list-user")
    public String listUserView(){
        return "user/list-user";
    }
}
