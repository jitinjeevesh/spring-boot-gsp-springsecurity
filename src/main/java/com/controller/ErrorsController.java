package com.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorsController {

    @RequestMapping("/403")
    public String accessDenied() {
        return "errors/403";
    }

    @RequestMapping("/404")
    public ModelAndView notFound() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            return new ModelAndView("errors/404");
        } else {
            return new ModelAndView("redirect:/login");
        }
    }

    @RequestMapping("/500")
    public String internalServerError() {
        return "errors/500";
    }
}
