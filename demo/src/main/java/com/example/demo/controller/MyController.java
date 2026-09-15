package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Livro;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController 
@RequestMapping("/biblioteca")
public class MyController {
    
    private List<Livro> livros;

    public MyController() {
        livros = new ArrayList<>();
        livros.add(new Livro("O Senhor dos Anéis: A Sociedade do Anel", "John R. R. Tolkien", 1954));
        livros.add(new Livro("O Senhor dos Anéis: As Duas Torres", "John R. R. Tolkien", 1954));
        livros.add(new Livro("O Senhor dos Anéis: O Retorno do Rei", "John R. R. Tolkien", 1954));
        livros.add(new Livro("Silmarilion", "John R. R. Tolkien & Christopher Tolkien", 1977));
        livros.add(new Livro("Duna", "Frank Herbert", 1965));
        livros.add(new Livro("Os Messias de Duna", "Frank Herbert", 1969));
    }

    @GetMapping("/")
    public String getInitialMessage() {
        return "Minha aplicação Spring Boot funcionando!";
    }

    @GetMapping("/livros")
    public ResponseEntity<List<Livro>> getLivros() {
        return ResponseEntity.ok(livros);
    }

    @GetMapping("/titulos")
    public ResponseEntity<List<String>> getTitulos() {
        List<String> titulos = livros.stream()
            .map(Livro::getTitulo)
            .collect(Collectors.toList());

        return ResponseEntity.ok(titulos);
    }   

    @GetMapping("/autores")
    public ResponseEntity<List<String>> getAutores() {
        List<String> autores = livros.stream()
            .map(Livro::getAutor)
            .collect(Collectors.toList());

        return ResponseEntity.ok(autores);
    }
    
    @GetMapping("/livrosautor")
    public ResponseEntity<List<String>> getAuthorsByBook(@RequestParam(value = "author") String author) {
        List<String> searchedBooks = livros.stream()
            .filter(l -> l.getAutor().equals(author))
            .map(Livro::getTitulo)
            .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(searchedBooks);
    }
}
