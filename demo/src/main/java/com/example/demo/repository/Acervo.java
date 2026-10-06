package com.example.demo.repository;

import java.util.*;
import org.springframework.stereotype.Component;

import com.example.demo.entities.Livro;

@Component
public class Acervo {
    private List<Livro> livros;

    public Acervo() {
         livros = new ArrayList<>();
        livros.add(new Livro("O Senhor dos Anéis: A Sociedade do Anel", "John R. R. Tolkien", 1954));
        livros.add(new Livro("O Senhor dos Anéis: As Duas Torres", "John R. R. Tolkien", 1954));
        livros.add(new Livro("O Senhor dos Anéis: O Retorno do Rei", "John R. R. Tolkien", 1954));
        livros.add(new Livro("Silmarilion", "John R. R. Tolkien & Christopher Tolkien", 1977));
        livros.add(new Livro("Duna", "Frank Herbert", 1965));
        livros.add(new Livro("Os Messias de Duna", "Frank Herbert", 1969));
        livros.add(new Livro("Novo livro", "Maria da Silva", 2026));
        livros.add(new Livro("Livro do Pedro", "Pedro da Silva", 2024)); 
    }

    public List<Livro> getLivros() {
        return livros;
    }
    
    public List<String> getTitulos() {
        return livros.stream()
               .map(livro->livro.getTitulo())
               .toList();
    }

    public List<String> getListaAutores() {
        return livros.stream()
                .map(l -> l.getAutor())
                .distinct()
                .toList();
    }

    public List<Livro> getLivrosDoAutor(String autor) {
        return livros.stream()
                  .filter(livro->livro.getAutor().equals(autor))
                  .toList();
    }

    public List<Livro> getLivrosDoAutor(String autor,
                                        int ano) {
       return livros.stream()
         .filter(livro->livro.getAutor().equals(autor))
         .filter(livro->livro.getAno() == ano)
         .toList();
    }
    
    public boolean cadastraLivroNovo(Livro livro) {
        livros.add(livro);
        return true;
    }

    public Livro getLivroTitulo(String titulo) {
            Livro resp = livros.stream()
                   .filter(livro->livro.getTitulo().equals(titulo))
                   .findFirst()
                   .orElse(null);   
            return resp;
    }

    public boolean deleteBook(int ano) {
        int sizeBeforeDelete = livros.size();

        livros = livros.stream()
            .filter(l -> l.getAno() != ano)
            .toList();

        return livros.size() != sizeBeforeDelete;
    }
}