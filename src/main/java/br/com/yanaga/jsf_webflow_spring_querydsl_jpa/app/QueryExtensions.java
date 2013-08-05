package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app;

import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa.NomeRazaoSocial;
import com.mysema.query.annotations.QueryDelegate;
import com.mysema.query.support.Expressions;
import com.mysema.query.types.Expression;
import com.mysema.query.types.Ops;
import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.path.BeanPath;

public class QueryExtensions{

    private QueryExtensions(){
    }

    @QueryDelegate(NomeRazaoSocial.class)
    public static BooleanExpression containsIgnoreCase(
            BeanPath<NomeRazaoSocial> nomeRazaoSocial,
            String contained){
        System.out.println(NomeRazaoSocial.class +"-------> NomeRazaoSocial: " + nomeRazaoSocial.toString());
        System.out.println(NomeRazaoSocial.class +"-------> Contained      : " + contained.toString());

        Expression<String> constant = Expressions.constant(String.format("%%%s%%", contained));
        System.out.println(NomeRazaoSocial.class +"-------> Expressions : " + Expressions.predicate(Ops.LIKE, nomeRazaoSocial, constant));
        return Expressions.predicate(Ops.LIKE, nomeRazaoSocial, constant);
    }
}
