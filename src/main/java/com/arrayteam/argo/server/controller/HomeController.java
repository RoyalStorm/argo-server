package com.arrayteam.argo.server.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;


@Controller
@ApiIgnore
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "redirect:/swagger-ui.html";
    }

    @RequestMapping("/docs")
    public String docs() {
        return "redirect:/swagger-ui.html";
    }

}
