package com.arief.mvc.controllers;

import com.arief.mvc.beans.dao.services.AlbumService;
import com.arief.mvc.beans.dao.services.PhotoService;
import com.arief.mvc.models.Album;
import com.arief.mvc.models.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

        String s1 = multipartFile
                .getOriginalFilename()
                .substring(
                        multipartFile.getOriginalFilename().lastIndexOf("."),
                        multipartFile.getOriginalFilename().length()
                );
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

    @RequestMapping("/list-photo/album")
    public String photoListForAlbum(@RequestParam(value = "album_id",required = false)String s, Model m){
        List<Photo> photoList = photoService.getPhotosByAlbumId(s);
        m.addAttribute("photoList",photoList);
        return "photo/list-photo";
    }

    @RequestMapping("/remove-photo/{photoId}")
    public String removePhotoFromAlbum(@PathVariable int photoId){
        Photo getPhoto = photoService.getOne(photoId);
        String photoUrl = getPhoto.getPhotoUrl();
        String fileName = photoUrl.substring(photoUrl.lastIndexOf("/")+1,photoUrl.length());

        File file = new File("/usr/local/apache/uploads/"+fileName);

        if(file.delete()){
            photoService.delete(getPhoto);
        }
        return "redirect:/photo/list-photo";
    }
}
