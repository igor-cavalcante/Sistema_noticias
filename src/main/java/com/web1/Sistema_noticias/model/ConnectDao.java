package com.web1.Sistema_noticias.model;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDao {

    public DataSource dataSource() throws ErrorDao{
        try {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName("org.postgresql.Driver");
            dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
            dataSource.setUsername("aluno");
            dataSource.setPassword("aluno");
            return dataSource;
        }catch (Exception e){
            throw new ErrorDao("Erro ao inicaiar coneção com o banco"+e);
        }
    };



}
