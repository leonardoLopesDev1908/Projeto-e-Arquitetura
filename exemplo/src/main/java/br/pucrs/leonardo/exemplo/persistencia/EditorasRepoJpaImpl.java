package br.pucrs.leonardo.exemplo.persistencia;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;


@Repository
@Primary
public class EditorasRepoJpaImpl implements IEditorasRepository {
    private IEditorasJpaItfRep repository;

    @Autowired
    public EditorasRepoJpaImpl(IEditorasJpaItfRep repository) {
        this.repository = repository;
    }

    @Override
    public List<Editora> getEditoras() {
        List<Editora> editoras = repository.findAll();
        if (editoras.size() == 0) 
            editoras = new LinkedList<Editora>();
        return editoras;
    }

    @Override
    public Editora getEditoraId(long id) {
        Editora livro = repository.findById(id);
        return livro;
    }

    @Override
    public Editora getEditoraNome(String nome) {
        Editora editoras = repository.findByNome(nome);
        return editoras;
    }
}
