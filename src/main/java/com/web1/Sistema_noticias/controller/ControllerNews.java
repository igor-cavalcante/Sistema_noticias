package com.web1.Sistema_noticias.controller;

import com.web1.Sistema_noticias.dao.*;
import com.web1.Sistema_noticias.model.News;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.io.IOException;
import java.util.List;

@Controller
public class ControllerNews {

    @GetMapping("/")
    public String index(Model model) {
        try {
            NewsDaoInterface dao = new  NewsDaoClasse();
            List<News> Listnews = dao.listar();
            model.addAttribute("noticias", Listnews);
            System.out.println(Listnews);
            dao.sair();
            return "index";
        } catch (ErrorDao e) {
            model.addAttribute("msg", "Erro ao carregar notícias: " + e.getMessage());
        }
        return "index";
    }


    @GetMapping("/noticiaNews/{id:\\d+}")
    public String noticia(@PathVariable("id") int id, Model model) {
        try {
            NewsDaoInterface dao = new  NewsDaoClasse();
            List<News> Listnews = dao.listar();
            model.addAttribute("noticias", Listnews);
            News t = dao.buscar(id);
            model.addAttribute("noticia", t);

            System.out.println(t);
            dao.sair();

        } catch (ErrorDao e) {
            model.addAttribute("msg", "Erro ao carregar notícias: " + e.getMessage());
            return "buscarNews";
        }
        return "buscarNews";
    }







}
