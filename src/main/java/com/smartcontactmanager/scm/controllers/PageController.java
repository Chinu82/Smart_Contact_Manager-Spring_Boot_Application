package com.smartcontactmanager.scm.controllers;

import com.smartcontactmanager.scm.entities.User;
import com.smartcontactmanager.scm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.smartcontactmanager.scm.forms.UserForms;



@Controller
public class PageController {

    @Autowired
    private UserService userService;

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
    public String register(Model model) {

        UserForms userForms = new UserForms();
        //default name
        userForms.setEmail("@gmail.com");
        model.addAttribute("userForms", userForms);
        
        return "register";
    }

    //processing register
    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processRegister(@ModelAttribute UserForms userForms){
        System.out.println("Process register");
        System.out.println(userForms);
        //fetch the data
            //UserForm

        //validate form data
            //Todo
        //save to database
            //UserForms -> user
            User user = User.builder()
                    .name(userForms.getName())
                    .email(userForms.getEmail())
                    .password(userForms.getPassword())
                    .about(userForms.getAbout())
                    .phoneNumber(userForms.getPhoneNumber())
                    .profilePic("")
                    .build();
            User saveUser =  userService.saveUser(user);
            System.out.println("user saved");
        //message = "registration successfully"
        //redirectio login page
        return "redirect:/register";
    }
}
