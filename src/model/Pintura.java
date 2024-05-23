package model;

import java.io.Serializable;

public class Pintura extends ObraDeArte implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String tecnica;

    public Pintura(String titulo, String artista, int anoDeCriacao, String localizacao, String tecnica) {
        super(titulo, artista, anoDeCriacao, "Pintura", localizacao);
        this.tecnica = tecnica;
    }

    public String getTecnica() {
        return tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }
}
