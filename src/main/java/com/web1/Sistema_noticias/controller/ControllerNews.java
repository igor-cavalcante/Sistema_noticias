package com.web1.Sistema_noticias.controller;

import com.web1.Sistema_noticias.dao.ErrorDao;
import com.web1.Sistema_noticias.dao.ReporterDaoClasse;
import com.web1.Sistema_noticias.dao.ReporterDaoInterface;
import com.web1.Sistema_noticias.model.Reporter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerNews {


    @GetMapping("/")
    public String index(Model model){

        return "index";
    }


}
