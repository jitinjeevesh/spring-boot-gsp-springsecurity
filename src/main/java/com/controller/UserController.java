package com.controller;

import com.domain.User;
import com.dto.RegistrationDto;
import com.security.user.CustomUserDetailsService;
import com.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    @Qualifier("customUserDetailsService")
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    protected AuthenticationManager authenticationManager;

    @RequestMapping("/list")
    public ModelAndView list() {
        return new ModelAndView("/user/index1");
    }

    @RequestMapping("/list4")
    public ModelAndView list4() {
        return new ModelAndView("/user/index1");
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping("/list2")
    public ModelAndView list1() {
        return new ModelAndView("/user/index1");
    }

    @Secured("ROLE_USER")
    @RequestMapping("/list3")
    public ModelAndView list3() throws Exception {
        return new ModelAndView("/user/index1");
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(@Validated @ModelAttribute RegistrationDto registrationDto, BindingResult bindingResult) {
        System.out.println("////////////////////////////////////////////////////////////////");
        if (!bindingResult.hasErrors()) {
            User user = userService.save(registrationDto);
            UserDetails userDetails = customUserDetailsService.loadUserByUsername(user.getEmail());
            Authentication auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);
            return new ModelAndView("redirect:/user/list");
        } else {
//            System.out.println(bindingResult.getAllErrors());
            return new ModelAndView("redirect:/login");
        }
    }
}
