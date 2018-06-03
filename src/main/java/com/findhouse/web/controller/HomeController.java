package com.findhouse.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = {"/", "/index"})
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/403")
    public String accessErorr(Model model) {
        return "403";
    }
    @GetMapping("/404")
    public String notFoundPage(Model model) {
        return "404";
    }

    @GetMapping("/500")
    public String internalErorr(Model model) {
        return "500";
    }

    @GetMapping("/logout")
    public String logoutPage(Model model) {
        return "logout";
    }
}
