package com.arief.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/album")
public class AlbumController {

    @RequestMapping(value = "/form-album",method = RequestMethod.GET)
    public String formAlbumGET(){
        return "albums/form-album";
    }
    @RequestMapping(value = "/form-album",method = RequestMethod.POST)
    public String formAlbumPOST(){
        return "redirect:";
    }

    @RequestMapping("/list-album")
    public String listAlbumView(){
        return "albums/list-album";
    }
}
