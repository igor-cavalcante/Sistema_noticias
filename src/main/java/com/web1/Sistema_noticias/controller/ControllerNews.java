package com.web1.Sistema_noticias.controller;

import com.web1.Sistema_noticias.dao.*;
import com.web1.Sistema_noticias.model.News;
import com.web1.Sistema_noticias.model.Reporter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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





}
