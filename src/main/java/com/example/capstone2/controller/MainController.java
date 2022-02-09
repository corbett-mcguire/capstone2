package com.example.capstone2.controller;


import com.example.capstone2.model.Type;
import com.example.capstone2.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(path = "/api")
public class MainController {
    private static final Logger LOGGER = Logger.getLogger(MainController.class.getName());
    private MainService mainService;

    @Autowired
    public void setMainService(MainService mainService) {
        this.mainService = mainService;
    }

    // http://localhost:9092/api/types
    @GetMapping("/types")
    public List<Type> getTypes() {
        System.out.println("calling getTypes method from controller");
        return mainService.getTypes();
    }
}
