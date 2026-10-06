package br.pucrs.leonardo.exemplo.persistencia;

import jakarta.persistence.*;

@Entity
public class Editora {
    @Id
    private long id;
    private String nome;

    public Editora() {        
    }

    public Editora(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public String getTitulo() {
        return nome;
    }

}
