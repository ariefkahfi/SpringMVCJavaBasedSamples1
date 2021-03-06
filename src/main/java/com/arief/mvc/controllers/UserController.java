package com.arief.mvc.controllers;

import com.arief.mvc.beans.dao.services.UserService;
import com.arief.mvc.models.Album;
import com.arief.mvc.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ModelAttribute(value = "listUser")
    public List<User> userList(){
        return userService.getAll();
    }


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

    @RequestMapping("/remove-user/{userId}")
    public String removeUser(@PathVariable String userId){
        User getUser = userService.getOne(userId);

        userService.deletePhotoFromThisUser(userId);
        userService.delete(getUser);
        return "redirect:/user/list-user";
    }
}
