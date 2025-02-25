package com.web1.Sistema_noticias.controller;


import com.web1.Sistema_noticias.dao.ErrorDao;
import com.web1.Sistema_noticias.dao.NewsDaoClasse;
import com.web1.Sistema_noticias.dao.NewsDaoInterface;
import com.web1.Sistema_noticias.model.News;
import com.web1.Sistema_noticias.model.Reporter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class ControllerGerenciador {

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
                        return -1;
                    }
                }
            }
        }
        return -1;
    }

    @GetMapping("/gerenciador")
    public String gerenciador(HttpServletRequest request, Model model) {
        if (isUserLoggedIn(request)) {

            int id = recuperarIdUsuario(request);
            // Cria um objeto Reporter com o ID recuperado
            Reporter reporter = new Reporter();
            reporter.setId(id);

            NewsDaoInterface dao = new NewsDaoClasse();

            try {
                List<News> noticias = dao.buscar(reporter);
                // Adiciona as notícias no model para renderizar na página
                model.addAttribute("noticias", noticias);
                dao.sair();

                return "gerenciador";
            } catch (ErrorDao e) {
                model.addAttribute("msg", "Erro ao buscar as noticias do reporter");
                return "gerenciador";
            }
        }
        model.addAttribute("msg", "Você precisa se logar primeiro");
        return "login";
    }

    @GetMapping("/cadastrarNoticiaView")
    public String cadastrarNoticiaView(Model model) {
        return "cadastrarNoticia";

    }

    @PostMapping("/inserirNoticia")
    public  String inserirNoticiaPost(String titulo, String lide, String corpo, Model model, HttpServletRequest request) {

        try {
            int id = recuperarIdUsuario(request);
            Reporter reporter = new Reporter();
            reporter.setId(id);
            News news = new News(titulo,lide,corpo,reporter);
            NewsDaoInterface dao = new NewsDaoClasse();
            dao.inserir(news);
            dao.sair();

            model.addAttribute("msg", "Dados cadastrados com sucesso!");
            return "cadastrarNoticia";
        } catch (ErrorDao e) {
            model.addAttribute("msg", "erro ao cadastrar os dados" + e.getMessage());
            return "cadastrarNoticia";
        } catch (Exception e) {
            model.addAttribute("msg", "erro ao cadastrar os dados" + e.getMessage());
            return "cadastrarNoticia";
        }
    }

    @GetMapping("/editarNoticia/{id}")
    public String editarNoticiaView(@PathVariable("id") int id, Model model, HttpServletRequest request) {
        if (isUserLoggedIn(request)) {
            News noticia = null;
            NewsDaoInterface dao = new NewsDaoClasse();
            try {
                noticia = dao.buscar(id);
                model.addAttribute("noticia", noticia);
                return "editarNews";
            } catch (ErrorDao e) {
                model.addAttribute("noticia", noticia);
                return "editarNews";
            }
        }else {
            model.addAttribute("msg", "Você precisa se logar primeiro");
            return "login";
        }
    }


    @PostMapping("/editarNoticia")
    public String editarNoticiaPost( int id, String titulo, String lide, String corpo, Model model, HttpServletRequest request) {

        if (isUserLoggedIn(request)) {
            try {

                int userId = recuperarIdUsuario(request);

                Reporter reporter = new Reporter();
                reporter.setId(userId);

                News news = new News(titulo, lide, corpo, reporter);
                news.setId(id);

                NewsDaoInterface dao = new NewsDaoClasse();
                dao.editar(news);
                dao.sair();
                return "redirect:/gerenciador";

            } catch (ErrorDao e) {
                model.addAttribute("msg", "Erro ao atualizar os dados: " + e.getMessage());
                return "editarNews";
            } catch (Exception e) {
                model.addAttribute("msg", "Erro ao atualizar os dados: " + e.getMessage());
                return "editarNews";
            }
        }else{
            model.addAttribute("msg", "Você precisa se logar primeiro");
            return "login";
        }
    }

    @GetMapping("/deletarNoticia/{id}")
    public String deletarNoticia(@PathVariable("id") int id, Model model,HttpServletRequest request) {
       if(isUserLoggedIn(request)){

           NewsDaoInterface dao = new NewsDaoClasse();
           try {
               dao.deleteById(id);
               dao.sair();
           } catch (ErrorDao e) {
               model.addAttribute("msg", "erro ao deletar os dados" + e.getMessage());
               return "gerenciador";
           }
           return "redirect:/gerenciador";
       }else {
           model.addAttribute("msg", "Você precisa se logar primeiro");
           return "login";

       }
    }

}
