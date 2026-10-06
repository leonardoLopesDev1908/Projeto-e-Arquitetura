package br.pucrs.leonardo.exemplo.persistencia;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface IEditorasJpaItfRep extends CrudRepository<Editora,Long>{
    List<Editora> findAll(); 
    Editora findById(long id); 
    Editora findByNome(String nome);
}
