package com.web1.Sistema_noticias.dao;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

public class ConnectDao {

    public static Connection dataSource() throws ErrorDao {
        try {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName("org.postgresql.Driver");
            dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
            dataSource.setUsername("postgres");
            dataSource.setPassword("Icsa@123");
            return dataSource.getConnection();
        }catch (Exception e){
            throw new ErrorDao("Erro ao inicaiar coneção com o banco"+e);
        }
    };

}
