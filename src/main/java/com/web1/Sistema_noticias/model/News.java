package com.web1.Sistema_noticias.model;

import java.time.LocalDate;

public class News {
    private int id;
    private byte[] imagen;
    private String titulo;
    private String lide;
    private String corpo;
    private LocalDate data;
    public Reporter reporter;

    public News( byte[] imagen , String titulo, String lide, String corpo, Reporter reporter) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.lide = lide;
        this.corpo = corpo;
        this.reporter = reporter;
    }
    public News(int id, String titulo,byte[] imagen , String lide, String corpo, LocalDate data, Reporter reporter) {
        this.id = id;
        this.titulo = titulo;
        this.imagen = imagen;
        this.lide = lide;
        this.corpo = corpo;
        this.data = data;
        this.reporter = reporter;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLide() {
        return lide;
    }

    public void setLide(String lide) {
        this.lide = lide;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    // Método toString para facilitar a visualização
    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", lide='" + lide + '\'' +
                ", corpo='" + corpo + '\'' +
                ", data=" + data +
                ", reporter=" + (reporter != null ? reporter.getName() : "Nenhum") +
                '}';
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
}
