package br.com.AluraChallenge.bolao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(value = "/")
    public String testAPI() {
        return "Show, funciona!";
    }
}

