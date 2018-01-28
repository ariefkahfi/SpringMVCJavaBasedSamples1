package com.arief.mvc.controllers;

import com.arief.mvc.beans.dao.services.UserService;
import com.arief.mvc.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;




    @RequestMapping(value = "/form-user",method = RequestMethod.GET)
    public String formUserGET(){
        return "user/form-user";
    }

    @RequestMapping(value = "/form-user",method = RequestMethod.POST)
    public String formUserPOST(@RequestParam Map<String,String> requestMapParams){
        User u = User.createModel(requestMapParams.get("user_id"),requestMapParams.get("user_name"));
        userService.save(u);
        return "redirect:/success";
    }

    @RequestMapping("/list-user")
    public String listUserView(){
        return "user/list-user";
    }
}
