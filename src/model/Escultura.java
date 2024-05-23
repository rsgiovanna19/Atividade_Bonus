package model;

import java.io.Serializable;

public class Escultura extends ObraDeArte implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String material;

    public Escultura(String titulo, String artista, int anoDeCriacao, String localizacao, String material) {
        super(titulo, artista, anoDeCriacao, "Escultura", localizacao);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
