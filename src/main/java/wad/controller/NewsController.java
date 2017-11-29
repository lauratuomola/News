/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NewsController {
    
    @GetMapping("/")
    
    public String home() {
        return "index";
    }
    
    @GetMapping("/uutinen")
    public String uutinen(){
        return "uutinen";
    }
    
    @PostMapping("/uutinen")
    public String add(@RequestParam String header){
        return "redirect:/uutinen";
    }
    
}
