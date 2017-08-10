package com.nmerris.newimprovedfb.controllers;

import com.nmerris.newimprovedfb.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class MainController {

    // home page
    @GetMapping(value = {"/", "/index"})
    public String indexPageGet(Model model)
    {
        model.addAttribute("someUser", new User());
        return "index";
    }


    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.POST)
    public String indexPagePost(@Valid @ModelAttribute("someUser") User user, BindingResult bindingResult, Model model) {


        if(bindingResult.hasErrors()) {
            return "index";
        }


        // process fizzbuzz here, store result in user, save to db

        return "index";
    }
//
//
//    @GetMapping("/fizzbuzzresult")
//    public String displayFizzBuzzResult(User user) {
//
//
//        // get stuff from user (should now have list of fizz buzz results)
//        // put it in fizzbuzzresult with tleaf
//
//
//        return ""
//    }
//

}
