package com.nmerris.newimprovedfb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    // home page
    @GetMapping(value = {"/", "/index"})
    public String indexPageGet()
    {
        return "index";
    }

}
