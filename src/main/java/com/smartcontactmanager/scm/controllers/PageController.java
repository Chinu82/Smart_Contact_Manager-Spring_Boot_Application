package com.smartcontactmanager.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(Model model){
        System.out.println("Home Page Handler");
        //to reach template automatically
        //sending data to view
        model.addAttribute("name", "Substring Technologies");
        model.addAttribute("youtubeChannel", "Learn Code Spring boot");
        model.addAttribute("githubRepository", "https://github.com/Chinu82");
        return "home";
    }

    //about route

    @RequestMapping("/about")
    public String aboutPage(Model model){
        model.addAttribute("isLogin", false);
        System.out.println("About page Loading... ");
        return "about";
    }

    //service
    @RequestMapping("/services")
    public String servicesPage(){
        System.out.println("Services page Loading... ");
        return "services";
    }

    //contact
    @RequestMapping("/contact")
    public String contact() {
        return "contact";
    }
    
    //login
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    //register
    @RequestMapping("/register")
    public String register() {
        return "register";
    }
}
