package com.nmerris.newimprovedfb.controllers;

import com.nmerris.newimprovedfb.FizzBuzzProcessor;
import com.nmerris.newimprovedfb.models.User;
import com.nmerris.newimprovedfb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    UserRepository userRepository;


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
            // this actually works, but the error msg info is lost
            // TODO ask Afua how to preserve the page info so it keeps the error m
//            return "redirect:index#play";
                return "index";


        }


        // process fizzbuzz here, store result in user, save to db
        FizzBuzzProcessor fizzBuzzProcessor = new FizzBuzzProcessor((int) user.getNumPicked());
        user.setFizzBuzzResult(fizzBuzzProcessor.startFizzing());
        System.out.println("FizzBuzzResult was: " + user.getFizzBuzzResult());

        // user should now have a name, play date, and fizzbuzz result String
        // TODO add todays date to user
        userRepository.save(user);

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
