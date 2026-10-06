package br.pucrs.leonardo.exemplo.persistencia;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;


@Repository
@Primary
public class AcervoRepoJpaImpl implements IAcervoRepository {
    private IAcervoJpaItfRep repository;

    @Autowired
    public AcervoRepoJpaImpl(IAcervoJpaItfRep repository) {
        this.repository = repository;
    }

    @Override
    public List<Livro> getLivros() {
        List<Livro> livros = repository.findAll();
        if (livros.size() == 0) 
            livros = new LinkedList<Livro>();
        return livros;
    }

    @Override
    public Livro getLivroId(long id) {
        Livro livro = repository.findById(id);
        return livro;
    }

    @Override
    public List<Livro> getLivrosAutor(String autor) {
        List<Livro> livros = repository.findByAutor(autor);
        if (livros.size() == 0) 
            livros = new LinkedList<Livro>();
        return livros;
    }

    
    
}
