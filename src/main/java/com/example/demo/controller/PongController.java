package com.example.demo.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
public class PongController {

    @RequestMapping(value = "/pong", method = RequestMethod.GET)
    @CrossOrigin(origins = "*") //TODO change me!
    public String pong() throws IOException {
        TmdbConnection tmdbConnection = new TmdbConnection();
        String output ;
        output = tmdbConnection.present();
        return output;
    }
}