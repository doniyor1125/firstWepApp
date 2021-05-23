package com.example.demo.Controller;

import com.example.demo.Entity.entity;
import com.example.demo.Service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class controller {

    @Autowired
    private service service;

    @GetMapping("/")

    public String getAll(Model model){
        List<entity> entityList = service.getAll();
        model.addAttribute("entityList", entityList);
        model.addAttribute("entitySize", entityList.size());
        return "index";
    }

    @RequestMapping("/delete/{id}")
    public String deleteTask(@PathVariable int id) {
        service.delete(id);
        return "redirect:/";
    }

    @PostMapping("/add")
    public String addTask(@ModelAttribute entity entity) {
        service.save(entity);
        return "redirect:/";
    }

}
