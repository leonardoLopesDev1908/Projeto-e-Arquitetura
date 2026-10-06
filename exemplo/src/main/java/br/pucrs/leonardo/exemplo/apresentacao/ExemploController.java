package br.pucrs.leonardo.exemplo.apresentacao;

import br.pucrs.leonardo.exemplo.persistencia.*;
import java.util.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/biblioteca")
public class ExemploController {
    private IAcervoRepository acervo;
    private IEditorasRepository editorasRepository;

    @Autowired
    public ExemploController(IAcervoRepository acervo, IEditorasRepository editorasRepository) {
        this.acervo = acervo;        
        this.editorasRepository = editorasRepository;
    }

    @GetMapping("")
    public String getMensagemInicial() {
        return "Aplicacao Spring-Boot funcionando!";
    }

    @GetMapping("/livros")
    public List<Livro> getLivros() {
        return acervo.getLivros();
    }

    @GetMapping("/livroid/{id}")
    public Livro getLivroId(@PathVariable long id) {
        return acervo.getLivroId(id);
    }

    @GetMapping("/livrosautor/{autor}")
    public List<Livro> getLivrosTitulo(@PathVariable String autor) {
        return acervo.getLivrosAutor(autor);
    }

    @GetMapping("/editoras")
    public List<Editora> getEditoras() {
        return editorasRepository.getEditoras(); 
    }

    @GetMapping("/editoraid/{id}")
    public Editora getEditoraId(@PathVariable long id) {
        return editorasRepository.getEditoraId(id);
    }

    @GetMapping("/editoranome/{nome}")
    public Editora getEditoraNome(@PathVariable String nome) {
        return editorasRepository.getEditoraNome(nome);
    }

}
