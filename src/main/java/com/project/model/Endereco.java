package com.project.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Endereco {
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String cep;

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Logradouro: ").append(logradouro);
        if(complemento != null && !complemento.isEmpty()) {
            builder.append(" - Complemento: ").append(complemento);
        }
        builder.append(" - Bairro: ").append(bairro);
        builder.append(" - Localidade: ").append(localidade);
        builder.append(" - UF: ").append(uf);
        builder.append(" - CEP: ").append(cep);
        return builder.toString();
    }
}
