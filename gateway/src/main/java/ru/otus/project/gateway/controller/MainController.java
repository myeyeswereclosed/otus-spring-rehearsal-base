package ru.otus.project.gateway.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class MainController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
