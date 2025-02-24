package com.web1.Sistema_noticias.dao;

import com.web1.Sistema_noticias.model.News;

import java.util.List;

public interface NewsDaoInterface {
    public News inserir(News news) throws ErrorDao;
    public News buscar (int id) throws ErrorDao;
    public List<News> buscar(String query) throws ErrorDao;
    public List<News> listar() throws ErrorDao;
    public void deletar(News news) throws ErrorDao;
    public void deleteById(int id) throws ErrorDao;
    public void editar(int id ) throws ErrorDao;



}
