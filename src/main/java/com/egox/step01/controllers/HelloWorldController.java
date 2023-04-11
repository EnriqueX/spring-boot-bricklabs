package com.egox.step01.controllers;

import com.egox.step01.models.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class HelloWorldController {

    //URI - /helloWorld
    //GET Method
    //@RequestMapping(method = RequestMethod.GET, path = "/helloWorld")
    @GetMapping("/helloWorldX")
    public String helloWorld(){
        return "Hello World X";
    }

    @GetMapping("/helloWorldBean")
    public UserDetails helloWorldBean(){
        UserDetails ud = new UserDetails();
        ud.setFirstName("Enrique");
        ud.setLastName("X");
        ud.setCity("Monterrey");
        return ud;
    }
}
