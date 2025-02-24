package com.web1.Sistema_noticias.controller;


import com.web1.Sistema_noticias.dao.ErrorDao;
import com.web1.Sistema_noticias.dao.ReporterDaoClasse;
import com.web1.Sistema_noticias.dao.ReporterDaoInterface;
import com.web1.Sistema_noticias.model.Reporter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Login {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(String login, String senha, Model model, HttpServletResponse response) {

        ReporterDaoInterface dao = new ReporterDaoClasse();
        try {
            Reporter reporter = dao.Logar(login, senha);
            dao.sair();

            if(reporter != null) {
                model.addAttribute("reporter", reporter);
                Cookie sessionCookie = new Cookie("session", String.valueOf(reporter.getId()));
                sessionCookie.setMaxAge(3600);
                sessionCookie.setPath("/");
                response.addCookie(sessionCookie);
                return "redirect:/gerenciador";
            }else {
                model.addAttribute("msg", "Login ou senha incorretos ");
                return "login";
            }

        } catch (ErrorDao e) {
            model.addAttribute("msg", "Erro ao processar o login: " + e.getMessage());
            return "login";
        }
    }

}
