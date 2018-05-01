package com.tai.TvShowsProgresser;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HomeController {

    @RequestMapping(value = "/")
    public String index() {
        return "Hello World" ;
    }
}