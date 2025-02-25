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

@Controller
public class ControllerNews {

    @GetMapping("/")
    public String index(Model model){
        return "index";
    }

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

    /**
     * Recupera o ID do usuário a partir do cookie de sessão.
     * @param request HttpServletRequest
     * @return ID do usuário ou -1 se não autenticado
     */
    private int recuperarIdUsuario(HttpServletRequest request) {
        if (request.getCookies() != null) {
            for (Cookie c : request.getCookies()) {
                if ("session".equals(c.getName())) {
                    try {
                        return Integer.parseInt(c.getValue());
                    } catch (NumberFormatException e) {
                        return -1; // ID inválido no cookie
                    }
                }
            }
        }
        return -1; // Usuário não autenticado
    }

    @GetMapping("/gerenciador")
    public String gerenciador(HttpServletRequest request, Model model) {
        if (isUserLoggedIn(request)) {
            return "gerenciador";
        }
        model.addAttribute("msg", "Você precisa se logar primeiro");
        return "login";  // Retorna diretamente a página de login sem redirecionar
    }

    @GetMapping("/cadastrarNoticiaView")
    public String cadastrarNoticiaView(Model model) {
            return "cadastrarNoticia";

    }



    @PostMapping("/inserirNoticia")
    public  String inserirNoticiaPost(String titulo, String lide, String corpo, MultipartFile imagem, Model model, HttpServletRequest request) {

        try {
            int id = recuperarIdUsuario(request);
            byte[] imagemBytes = imagem.getBytes();
            Reporter reporter = new Reporter(id);
            News news = new News(imagemBytes,titulo,lide,corpo,reporter);
            NewsDaoInterface dao = new NewsDaoClasse();
            dao.inserir(news);
            dao.sair();

            model.addAttribute("msg", "Dados cadastrados com sucesso!");
            return "cadastrarNoticia";

        } catch (ErrorDao e) {
            // Aqui você pode adicionar um log ou enviar um feedback para o usuário
            model.addAttribute("msg", "erro ao cadastrar os dados" + e.getMessage());
            return "cadastrarNoticia"; // Pode enviar um atributo de erro para o frontend
        } catch (Exception e) {
            // Aqui você pode adicionar um log ou enviar um feedback para o usuário
            model.addAttribute("msg", "erro ao cadastrar os dados" + e.getMessage());
            return "cadastrarNoticia"; // Pode enviar um atributo de erro para o frontend
        }
    }


}
