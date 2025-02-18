package com.web1.Sistema_noticias.model;

public class ErrorDao extends Exception {

    public ErrorDao() {
        super("Erro Dao");
    }

    public ErrorDao(String message) {
        super("Erro Dao: " + message);
    }

    public ErrorDao(String message, Throwable cause) {
        super(message, cause);
    }

    public ErrorDao(Throwable cause) {
        super(cause);
    }

    public ErrorDao(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
