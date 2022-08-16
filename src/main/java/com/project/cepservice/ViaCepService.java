package com.project.cepservice;

import javax.enterprise.context.Dependent;

@Dependent
public class ViaCepService extends AbstractCepService {
    private static final String dominio = "https://viacep.com.br/";
    protected ViaCepService() {
        super(dominio);
    }

    @Override
    protected String buildPath(String cep) {
        return "ws/" + cep + "/json";
    }
}
