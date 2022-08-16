package com.project.cepservice;

import com.project.model.Endereco;

public interface CepService {
    //A interface vai separar as classes e as declarar, mas não é responsável por "inicializá-las"
    Endereco buscaEndereco(String cep);
}