package com.web1.Sistema_noticias.dao;

import com.web1.Sistema_noticias.model.News;
import com.web1.Sistema_noticias.model.Reporter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class NewsDaoClasse implements NewsDaoInterface{

    Connection con;
    public NewsDaoClasse(){
        try {
            con = ConnectDao.dataSource();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void inserir(News news) throws ErrorDao {

        PreparedStatement psmt = null;

        try {
         psmt = con.prepareStatement("Insert Into noticia(imagem,titulo,lide,corpo,usuario_id) values(?,?,?,?,?)");
         psmt.setBytes(1,news.getImagen());
         psmt.setString(2,news.getTitulo());
         psmt.setString(3,news.getLide());
         psmt.setString(4,news.getCorpo());
         psmt.setInt(5,news.reporter.getId());
         psmt.executeUpdate();
         psmt.close();
         System.out.println("News inserido com sucesso!");
        }catch (Exception e) {
            throw new ErrorDao(e);
        }

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
