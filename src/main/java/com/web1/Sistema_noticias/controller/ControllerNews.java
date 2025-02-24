package com.web1.Sistema_noticias.controller;

import com.web1.Sistema_noticias.dao.ErrorDao;
import com.web1.Sistema_noticias.dao.ReporterDaoClasse;
import com.web1.Sistema_noticias.dao.ReporterDaoInterface;
import com.web1.Sistema_noticias.model.Reporter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ControllerNews {


    public static Boolean isUserLoggedIn(HttpServletRequest request) {

        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie c : cookies){
                if(c.getName().equals("session")){
                   return true;
                }
            }
        }
        return false;
    }


    @GetMapping("/")
    public String index(Model model){
        return "index";
    }

    @GetMapping("/gerenciador")
    public String gerenciador(HttpServletRequest request, Model model) {
        if (isUserLoggedIn(request)) {
            return "gerenciador";
        }
        model.addAttribute("msg", "Você precisa se logar primeiro");
        return "login";  // Retorna diretamente a página de login sem redirecionar
    }

    @GetMapping("/cadastrarNoticia")
    public String cadastrarNoticiaView(Model model) {
            return "cadastrarNoticia";

    }

    @PostMapping("/cadastrarNoticia")
    public  String cadastrarNoticiaPost(){

        return "cadastrarNoticia";
    }


}
