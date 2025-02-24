package com.web1.Sistema_noticias.controller;

import com.web1.Sistema_noticias.dao.ErrorDao;
import com.web1.Sistema_noticias.dao.ReporterDaoClasse;
import com.web1.Sistema_noticias.dao.ReporterDaoInterface;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller()
public class ControllerReporter {

    @GetMapping("/cadastrarReporter")
    public String view(){
        return "CadastrarReporter";
    }

    @PostMapping("/inserirReporter")
    public String inserir(String nome,String login, String senha,  Model model){
        com.web1.Sistema_noticias.model.Reporter reporter = new com.web1.Sistema_noticias.model.Reporter(nome, login, senha);
        try {
            ReporterDaoInterface dao = new ReporterDaoClasse();
            dao.inserir(reporter);
            dao.sair();
            model.addAttribute("msg", "reporter cadastrado com sucesso");
        } catch (ErrorDao e) {
            // Aqui você pode adicionar um log ou enviar um feedback para o usuário
            model.addAttribute("msg", "erro ao cadastrar os dados" + e.getMessage());
            return "index"; // Pode enviar um atributo de erro para o frontend
        }
        return "index";
    }
}
