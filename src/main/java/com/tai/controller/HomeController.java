package com.tai.TvShowsProgresser;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/")
public class HomeController {

    @GetMapping("")
    public String index(Model model, HttpServletRequest request){
        model.addAttribute(  "title", "Tv Shows Progresser");
        return "tv_shows_progresser/index.html";
    }
}




