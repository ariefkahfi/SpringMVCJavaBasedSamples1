package com.arief.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/photo")
public class PhotoController {

    @RequestMapping(value = "/form-photo",method = RequestMethod.GET)
    public String formPhotoGET(){
        return "photo/form-photo";
    }
    @RequestMapping(value = "/form-photo",method = RequestMethod.POST)
    public String formPhotoPOST(){
        return "redirect:";
    }
    @RequestMapping("/list-photo")
    public String listPhotoView(){
        return "photo/list-photo";
    }
}
