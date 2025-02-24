package com.web1.Sistema_noticias.dao;

import com.web1.Sistema_noticias.model.Reporter;

import java.sql.SQLException;
import java.util.List;

public interface ReporterDaoInterface {
    public Reporter Logar (String login, String senha) throws ErrorDao;
    public  void inserir(Reporter reporter) throws ErrorDao;
    public Reporter buscar(int id) throws ErrorDao;
    public List<Reporter> listar() throws ErrorDao;
    public void deletar(int id) throws ErrorDao;
    public void deletar(Reporter reporter) throws ErrorDao;
    public  void editar(Reporter reporter) throws ErrorDao;
    public void sair() throws ErrorDao;
}
