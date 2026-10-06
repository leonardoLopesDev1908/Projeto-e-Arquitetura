package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Livro;
import com.example.demo.repository.Acervo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController 
@RequestMapping("/biblioteca")
public class MyController {
    
    private final Acervo acervo;

    public MyController(Acervo acervo) {
        this.acervo = acervo;
    }

    @GetMapping("/")
    public String getInitialMessage() {
        return "Minha aplicação Spring Boot funcionando!";
    }

    @GetMapping("/livros")
    public ResponseEntity<List<Livro>> getLivros() {
        return ResponseEntity.ok().body(acervo.getLivros());
    }

    @GetMapping("/titulos")
    public ResponseEntity<List<String>> getTitulos() {
       return ResponseEntity.ok().body(acervo.getTitulos());
    }   

    @GetMapping("/autores")
    public ResponseEntity<List<String>> getAutores() {
        return ResponseEntity.ok().body(acervo.getListaAutores());
    }
    
    @GetMapping("/livrosautor")
    public ResponseEntity<List<Livro>> getBookByAuthor(@RequestParam(value = "author") String author) {
        return ResponseEntity.ok().body(acervo.getLivrosDoAutor(author));
    }

    @GetMapping("/livrosautorano/{autor}/ano/{ano}")
    public ResponseEntity<List<Livro>> getAuthorsWithPathParam(@PathVariable("autor") String author, @PathVariable("ano") int ano) {
        return ResponseEntity.ok().body(acervo.getLivrosDoAutor(author, ano));
    }
    
    @PostMapping("/livro")
    public ResponseEntity<Void> addBook(@RequestBody Livro livro) {
        if(acervo.cadastraLivroNovo(livro))
            return ResponseEntity.status(HttpStatus.CREATED).build();
        else 
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @DeleteMapping("/removelivrosano/{ano}")
    public ResponseEntity<Boolean> deleteBook(@PathVariable("ano") int ano) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(acervo.deleteBook(ano));
    }
}
