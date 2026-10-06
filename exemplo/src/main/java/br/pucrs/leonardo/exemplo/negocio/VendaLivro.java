package br.pucrs.nomeusuario.exemplo.negocio;

import br.pucrs.nomeusuario.exemplo.persistencia.Livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class VendaLivro {

    @Autowired
    public VendaLivro() {
        
    }

    public double calculaPreco(Livro livro) {
        if(livro.getAno() >= 2023)
            return 100.00;
        else
            return 50.00;
    }

}
