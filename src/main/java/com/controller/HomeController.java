package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping("/dashboard")
    public ModelAndView dashboard() {
        ModelMap model = new ModelMap();
        model.addAttribute("users", "Jeevesh");
        return new ModelAndView("/home/dashboard", model);
//        return "/home/dashboard";
    }
}
