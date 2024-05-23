package model;

import java.io.Serializable;

public class ObraDeArte implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String titulo;
    private String artista;
    private int anoDeCriacao;
    private String tipoDeObra;
    private String localizacao;

    public ObraDeArte(String titulo, String artista, int anoDeCriacao, String tipoDeObra, String localizacao) {
        this.titulo = titulo;
        this.artista = artista;
        this.anoDeCriacao = anoDeCriacao;
        this.tipoDeObra = tipoDeObra;
        this.localizacao = localizacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getAnoDeCriacao() {
        return anoDeCriacao;
    }

    public void setAnoDeCriacao(int anoDeCriacao) {
        this.anoDeCriacao = anoDeCriacao;
    }

    public String getTipoDeObra() {
        return tipoDeObra;
    }

    public void setTipoDeObra(String tipoDeObra) {
        this.tipoDeObra = tipoDeObra;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Artista: " + artista + ", Ano de Criação: " + anoDeCriacao +
                ", Tipo de Obra: " + tipoDeObra + ", Localização: " + localizacao;
    }
}
