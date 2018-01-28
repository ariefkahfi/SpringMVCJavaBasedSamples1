package com.arief.mvc.controllers;

import com.arief.mvc.beans.dao.services.AlbumService;
import com.arief.mvc.beans.dao.services.UserService;
import com.arief.mvc.models.Album;
import com.arief.mvc.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;
    @Autowired
    private UserService userService;


    @ModelAttribute(value = "listUser")
    public List<User> getUserList(){
        return userService.getAll();
    }

    @RequestMapping(value = "/form-album",method = RequestMethod.GET)
    public String formAlbumGET(){
        return "albums/form-album";

    }
    @RequestMapping(value = "/form-album",method = RequestMethod.POST)
    public String formAlbumPOST(@RequestParam  Map<String,String> map){
        User getOne = userService.getOne(map.get("album_user_id"));
        Album a = Album.createAlbum(map.get("album_id"),map.get("album_name"),getOne);
        albumService.save(a);
        return "redirect:/success";

    }

    @RequestMapping("/list-album")
    public String listAlbumView(){
        return "albums/list-album";
    }
}
