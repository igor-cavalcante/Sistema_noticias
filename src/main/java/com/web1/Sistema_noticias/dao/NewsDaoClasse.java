package com.web1.Sistema_noticias.dao;

import com.web1.Sistema_noticias.model.News;

import java.util.List;

public class NewsDaoClasse implements NewsDaoInterface{

    @Override
    public News inserir(News news) throws ErrorDao {
        return null;
    }

    @Override
    public News buscar(int id) throws ErrorDao {
        return null;
    }

    @Override
    public List<News> buscar(String query) throws ErrorDao {
        return List.of();
    }

    @Override
    public List<News> listar() throws ErrorDao {
        return List.of();
    }

    @Override
    public void deletar(News news) throws ErrorDao {

    }

    @Override
    public void deleteById(int id) throws ErrorDao {

    }

    @Override
    public void editar(int id) throws ErrorDao {

    }
}
