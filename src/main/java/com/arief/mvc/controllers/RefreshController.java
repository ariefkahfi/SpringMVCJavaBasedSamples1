package com.arief.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@Controller
public class RefreshController {


    @RequestMapping("/success")
    public void refreshHeader(HttpServletRequest request , HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=utf-8");
        response
                .getWriter()
                .write("" +
                        "<h1>Request success</h1>" +
                        "   <div>Please wait... <br/>" +
                        "   redirect to " + request.getHeader("referer") + "</div>" +
                        "");
        response.setHeader("Refresh","3; url="+request.getHeader("referer"));
    }

}
