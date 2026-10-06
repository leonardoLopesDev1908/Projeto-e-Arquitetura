package br.pucrs.leonardo.exemplo.persistencia;

import java.util.List;

public interface IEditorasRepository {
    List<Editora> getEditoras();
    Editora getEditoraId(long id);
    List<Editora> getEditoraNome(String nome);
}

