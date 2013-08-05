package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa;

import java.util.List;

public interface PessoaRepositoryCustom{

    public List<Pessoa> consultaComplexa();

    public List<Pessoa> consultaCnpjRazao(String value);
}
