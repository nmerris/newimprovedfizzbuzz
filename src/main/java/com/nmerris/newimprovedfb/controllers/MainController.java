package com.nmerris.newimprovedfb.controllers;

import com.nmerris.newimprovedfb.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String indexPagePost(@ModelAttribute User someUser) {

        return "index";
    }


}
