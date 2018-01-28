package com.arief.mvc.controllers;

import com.arief.mvc.beans.dao.services.AlbumService;
import com.arief.mvc.beans.dao.services.PhotoService;
import com.arief.mvc.models.Album;
import com.arief.mvc.models.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.Part;
import java.io.*;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/photo")
public class PhotoController {

    @Autowired
    private PhotoService photoService;
    @Autowired
    private AlbumService albumService;


    @ModelAttribute(value =  "listAlbum")
    public List<Album> albumList(){
        return albumService.getAll();
    }

    @RequestMapping(value = "/form-photo",method = RequestMethod.GET)
    public String formPhotoGET(){
        return "photo/form-photo";
    }

    @RequestMapping(value = "/form-photo",method = RequestMethod.POST)
    public String formPhotoPOST(@RequestParam("photo_name")String photoName,
                                @RequestParam("photo_url")MultipartFile multipartFile,
                                @RequestParam("album_photo_id")String albumPhotoId,
                                WebRequest webRequest) throws IOException {

        String uuid = UUID.randomUUID().toString();
        byte []bytes = multipartFile.getBytes();

        String s1 = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."),multipartFile.getOriginalFilename().length());
        String finalFilePath = uuid + s1;

        File file = new File("/usr/local/apache/uploads/"+finalFilePath);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(bytes);



        Album getOne = albumService.getOne(albumPhotoId);

        String contextPath = webRequest.getContextPath();

        Photo p = Photo.createPhoto(photoName,"http://localhost:8080"+contextPath+"/images/"+finalFilePath,getOne);
        photoService.save(p);


        return "redirect:/success";
    }
    @RequestMapping("/list-photo")
    public String listPhotoView(){
        return "photo/list-photo";
    }
}
