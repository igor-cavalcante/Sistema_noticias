package com.web1.Sistema_noticias.model;

public class Reporter {

    private int id ;
    private String name ;
    private String login ;
    private String senha ;

    public Reporter(int id, String name, String login, String senha) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.senha = senha;
    }

    public Reporter(String name, String login, String senha) {
        this.name = name;
        this.login = login;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Reporter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
