package com.project.cepservice;

import com.project.model.Endereco;

public abstract class AbstractCepService implements CepService {
    /* Essa classe abstrata vai servir como modelo para as subclasses dela. Uma classe abstrata é uma que não pode ser instanciada
       Ela define alguns métodos abstratos, isto é: MÉTODOS QUE AS SUBCLASSES SÃO OBRIGADOS A DEFINIR. A função dessa classe é abstrair
       métodos em comum para as classes dos diferentes serviços de api que iremos consumir.
     */

    @Override
    public Endereco buscaEndereco(String cep){
        return null;
    }
}
