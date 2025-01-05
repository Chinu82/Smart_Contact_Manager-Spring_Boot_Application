package com.smartcontactmanager.scm.controllers;

import com.smartcontactmanager.scm.entities.User;
import com.smartcontactmanager.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.smartcontactmanager.scm.forms.UserForms;
import com.smartcontactmanager.scm.helipers.Message;
import com.smartcontactmanager.scm.helipers.MessageType;



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
    public String processRegister(@Valid @ModelAttribute UserForms userForms,BindingResult rBindingResult, HttpSession session){
        System.out.println("Process register");
        System.out.println(userForms);
        //fetch the data
            //UserForm

        //validate form data
        if (rBindingResult.hasErrors())
        {
            return "register";
        }


        //save to database
            
        /*
            //UserForms -> user
                User user = User.builder()
                    .name(userForms.getName())
                    .email(userForms.getEmail())
                    .password(userForms.getPassword())
                    .about(userForms.getAbout())
                    .phoneNumber(userForms.getPhoneNumber())
                    .profilePic("")
                    .build();
            //bcause build() method didnt pass the default value        
        */
            //now default value can set
            User user = new User();
                user.setName(userForms.getName());
                user.setEmail(userForms.getEmail());
                user.setPassword(userForms.getPassword());
                user.setAbout(userForms.getAbout());
                user.setPhoneNumber(userForms.getPhoneNumber());
                user.setProfilePic("https://cdn.pixabay.com/photo/2018/11/13/21/43/avatar-3814049_1280.png");


            User saveUser =  userService.saveUser(user);
            System.out.println("user saved");
            
            //message = "registration successfully"

            //add the message
            Message message = Message.builder().content("Registration Successfully").type(MessageType.blue).build();

            session.setAttribute("message",message);


        //redirectio login page
        return "redirect:/register";
    }
}
