package com.team2.gpstracking;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;
import java.util.Map;

@Controller
public class MapController {
    @GetMapping("/")
    public String map(Model model) {
        model.addAttribute("vars", "varss");
        System.out.println("HERE ");
        return "index";
    }
}
