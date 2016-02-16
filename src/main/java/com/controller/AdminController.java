package com.controller;

import com.dto.RegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/admin")
@Controller
public class AdminController {

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute RegistrationDto registrationDto) {
        System.out.println("...................................................................");
        System.out.print(registrationDto.getEmail());
        System.out.println("...................................................................");
        return "/user/index1";
    }
}
