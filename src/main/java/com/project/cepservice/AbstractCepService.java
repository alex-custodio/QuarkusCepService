package com.project.cepservice;

import com.project.model.Endereco;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.Objects;
import java.util.logging.Logger;

public abstract class AbstractCepService implements CepService {
    /* Essa classe abstrata vai servir como modelo para as subclasses dela. Uma classe abstrata é uma que não pode ser instanciada
       Ela define alguns métodos abstratos, isto é: MÉTODOS QUE AS SUBCLASSES SÃO OBRIGADOS A DEFINIR. A função dessa classe é abstrair
       métodos em comum para as classes dos diferentes serviços de api que iremos consumir.
     */
    // Atributos
    private WebTarget target; // é o objeto que vai fazer a requisição http
    private String dominio; // é o dominio de cada serviço
    private final static Logger log = Logger.getLogger(CepService.class.getSimpleName());
    //Métodos
    private String insertSlash(String url){
        return url.endsWith("/") ? url : url + "/";
    }
    protected abstract String buildPath(String cep);

    private String getFullPath(String cep){
        return this.dominio + buildPath(cep);
    }
    //Construtor
    protected AbstractCepService(String dominio){
        this.dominio = insertSlash(Objects.requireNonNull(dominio, "I need a non null value bruh"));
        final Client client = ClientBuilder.newClient();
        this.target = client.target(dominio);
    }
    //Método implementado de CepService
    @Override
    public Endereco buscaEndereco(String cep){
        Objects.requireNonNull(cep, "I need a non null value bruh :(");
        log.info("Enviando requisição para " + getFullPath(cep));
        return target.path(buildPath(cep)).request().get(Endereco.class);
    }
}
