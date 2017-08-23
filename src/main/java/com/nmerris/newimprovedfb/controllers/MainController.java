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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.ArrayList;

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




        // TODO add a table of users, from the db, and put it in index#users
        // this should happen all the time, no need for a separate controller method, it should just always reflect
        // the current data in the db, ok if it's empty for now
        // this needs to happen before anything else in this method


        if(bindingResult.hasErrors()) {
            // this actually works, but the error msg info is lost
            // TODO ask Afua how to preserve the page info so it keeps the error msg
//            return "redirect:index#play";
//            model.setView(new RedirectView("index#play", true));
            return "index";


        }


        // process fizzbuzz here, store result in user, save to db
        FizzBuzzProcessor fizzBuzzProcessor = new FizzBuzzProcessor((int) user.getNumPicked());
        user.setFizzBuzzResult(fizzBuzzProcessor.startFizzing());
//        System.out.println("FizzBuzzResult was: " + user.getFizzBuzzResult());

        // user should now have a name, play date, and fizzbuzz result String
        // TODO add todays date to user
        userRepository.save(user);


        // add all the Users to the model
        model.addAttribute("userList", userRepository.findAll());
        model.addAttribute("fizzResult", user.getFizzBuzzResult());



        // same as above, want to go to index#play but also keep page info
        // now it should show the results of the users entry
        // TODO ask Fi
        return "index";



    }


}
