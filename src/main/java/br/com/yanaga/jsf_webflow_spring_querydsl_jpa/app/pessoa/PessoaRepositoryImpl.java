package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa;

import com.mysema.query.jpa.impl.JPAQuery;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class PessoaRepositoryImpl implements PessoaRepositoryCustom{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Pessoa> consultaComplexa(){
        JPAQuery query = new JPAQuery(entityManager);
        QPessoa qPessoa = QPessoa.pessoa;
        return query.from(qPessoa).list(qPessoa);
    }

    @Override
    public List<Pessoa> consultaCnpjRazao(String value){

        JPAQuery query = new JPAQuery(entityManager);
        QPessoa qPessoa = QPessoa.pessoa;

        List<Pessoa> list = query.from(qPessoa).where(qPessoa.nomeRazaoSocial.containsIgnoreCase(value)).list(qPessoa);

        return list;
    }
}
