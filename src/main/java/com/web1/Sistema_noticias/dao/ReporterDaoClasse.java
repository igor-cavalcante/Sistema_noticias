package com.web1.Sistema_noticias.dao;

import com.web1.Sistema_noticias.model.Reporter;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ReporterDaoClasse implements ReporterDaoInterface{

    Connection con;

    public ReporterDaoClasse(){
        try {
            con = ConnectDao.dataSource();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void inserir(Reporter reporter) throws ErrorDao {

        try {
            PreparedStatement psmt = con.prepareStatement("insert into usuario(nome,login,senha) values (?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            psmt.setString(1,reporter.getName());
            psmt.setString(2,reporter.getLogin());
            psmt.setString(3,reporter.getSenha());
            psmt.executeUpdate();
            ResultSet rs = psmt.getGeneratedKeys();

            if(rs.next()){
                reporter.setId(rs.getInt(1));
                psmt.close();
            }
            rs.close();
            System.out.println("usuario"+reporter.toString()+" inserido com sucesso");
        } catch (SQLException e) {
            throw new ErrorDao(e);
        }
    }

    @Override
    public Reporter Logar(String login, String senha) throws ErrorDao {
        try {
            PreparedStatement psmt = con.prepareStatement("select  * from usuario where login = ? and senha = ? ");
            psmt.setString(1,login);
            psmt.setString(2,senha);
            ResultSet rs = psmt.executeQuery();

            if(rs.next()){
                Reporter r = new Reporter(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                );
                rs.close();
                psmt.close();
            return r;
            }
            rs.close();
            psmt.close();
        } catch (SQLException e) {
            throw new ErrorDao(e);
        }
        return null;
    }

    @Override
    public Reporter buscar(int id) {
        return null;
    }

    @Override
    public List<Reporter> listar() {
        return List.of();
    }

    @Override
    public void deletar(int id) {

    }

    @Override
    public void deletar(Reporter reporter) {

    }

    @Override
    public void editar(Reporter reporter) {

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
