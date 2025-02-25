package com.web1.Sistema_noticias.dao;

import com.web1.Sistema_noticias.model.News;
import com.web1.Sistema_noticias.model.Reporter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
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
         psmt = con.prepareStatement("Insert Into noticia(titulo,lide,corpo,usuario_id) values(?,?,?,?)");
         psmt.setString(1,news.getTitulo());
         psmt.setString(2,news.getLide());
         psmt.setString(3,news.getCorpo());
         psmt.setInt(4,news.reporter.getId());
         psmt.executeUpdate();
         psmt.close();
         System.out.println("News inserido com sucesso!");
        }catch (Exception e) {
            throw new ErrorDao(e);
        }

    }

    @Override
    public News buscar(int id) throws ErrorDao {

       News news = new News();
        try {
            PreparedStatement psmt = con.prepareStatement("select  * from noticia where id = ?");
            psmt.setInt(1, id);
            ResultSet rs = psmt.executeQuery();

            if(rs.next()){
                news.setId(rs.getInt("id"));
                news.setTitulo(rs.getString("titulo"));
                news.setLide(rs.getString("lide"));
                news.setCorpo(rs.getString("corpo"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return news;

    }

    @Override
    public List<News> buscar(Reporter reporter) throws ErrorDao {

        List<News> lista = new ArrayList<>();

        try {
            String sql = "SELECT n.id, n.titulo, n.lide, n.corpo, n.data, u.nome AS reporter_nome " +
                    "FROM noticia n " +
                    "JOIN usuario u ON n.usuario_id = u.id " +
                    "WHERE n.usuario_id = ?";
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setInt(1, reporter.getId());

            // Executa a consulta e recupera os resultados
            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {
                News news = new News();
                news.setId(rs.getInt("id"));
                news.setTitulo(rs.getString("titulo"));
                news.setLide(rs.getString("lide"));
                news.setCorpo(rs.getString("corpo"));

                // Cria um objeto Reporter e atribui o nome recuperado
                Reporter r = new Reporter();
                r.setName(rs.getString("reporter_nome"));  // Agora o nome do reporter é recuperado da consulta
                news.setReporter(r);

                // Convertendo data para LocalDate
                java.sql.Date sqlDate = rs.getDate("data");
                if (sqlDate != null) {
                    news.setData(sqlDate.toLocalDate());
                }

                lista.add(news);
            }
        } catch (SQLException e) {
            throw new ErrorDao(e);
        }
        return lista;
    }

    @Override
    public List<News> listar() throws ErrorDao {

        List<News> lista = new ArrayList<>();

        try {
            PreparedStatement psmt = con.prepareStatement(
                    "SELECT n.id, n.titulo, n.lide, n.corpo, n.data, u.nome AS reporter_nome " +
                            "FROM noticia n " +
                            "JOIN usuario u ON n.usuario_id = u.id"
            );
            psmt.executeQuery();
            ResultSet rs = psmt.getResultSet();

            while (rs.next()) {
                News news = new News();
                news.setId(rs.getInt("id"));
                news.setTitulo(rs.getString("titulo"));
                news.setLide(rs.getString("lide"));
                news.setCorpo(rs.getString("corpo"));

                // Recuperando o nome do reporter diretamente da consulta
                Reporter r = new Reporter();
                r.setName(rs.getString("reporter_nome"));  // Agora é o nome do reporter
                news.setReporter(r);

                // Convertendo data para LocalDate
                java.sql.Date sqlDate = rs.getDate("data");
                if (sqlDate != null) {
                    news.setData(sqlDate.toLocalDate());  // Convertendo para LocalDate
                }
                lista.add(news);
            }
        } catch (SQLException e) {
            throw new ErrorDao(e);
        }
        lista.forEach(System.out::println);
        return lista;
    }


    @Override
    public void deleteById(int id) throws ErrorDao {
        try {
            PreparedStatement psmt = con.prepareStatement("DELETE FROM noticia WHERE id = ?");
            psmt.setInt(1, id);
            psmt.executeUpdate();
            psmt.close();
        } catch (SQLException e) {
            throw new ErrorDao(e);
        }
    }

    @Override
    public void editar(News news) throws ErrorDao {

        PreparedStatement psmt = null;
        try {
            String sql = "UPDATE noticia SET titulo = ?, lide = ?, corpo = ? WHERE id = ?";
            psmt = con.prepareStatement(sql);
            psmt.setString(1, news.getTitulo());
            psmt.setString(2, news.getLide());
            psmt.setString(3, news.getCorpo());
            psmt.setInt(4, news.getId());

            int rowsUpdated = psmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Notícia atualizada com sucesso!");
            } else {
                System.out.println("Nenhuma notícia encontrada com o ID fornecido.");
            }

            psmt.close();
        } catch (SQLException e) {
            throw new ErrorDao(e);
        }

    }

    @Override
    public void sair() throws ErrorDao {
        try {
            con.close();
        } catch (SQLException e) {
            throw new ErrorDao(e);
        }
    }
}
