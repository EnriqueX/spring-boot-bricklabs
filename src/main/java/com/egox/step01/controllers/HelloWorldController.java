package com.egox.step01.controllers;

import com.egox.step01.models.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

//Controller
@RestController
public class HelloWorldController {

    @Autowired
    private ResourceBundleMessageSource messageSource;

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

    @GetMapping("/getMessages")
    public String getMessagesInI18NFormat(@RequestHeader(name = "Accept-language", required = false) String locale){
        return messageSource.getMessage("label.hello", null, Locale.of(locale));
    }

    @GetMapping("/getMessages2")
    public String getMessagesInI18NFormat2(){
        return messageSource.getMessage("label.hello", null, LocaleContextHolder.getLocale());
    }
}
