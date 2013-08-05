package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Map;

public enum TipoPessoa{

    Fisica("F"),
    Juridica("J");

    private final String descricao;

    private static final Map<String, TipoPessoa> descricaoMap;

    static {
        Builder<String, TipoPessoa> builder = ImmutableMap.builder();
        for(TipoPessoa pessoa : values()) {
            builder.put(pessoa.getDescricao(), pessoa);
        }
        descricaoMap = builder.build();
    }

    public static TipoPessoa fromDescricao(String descricao){
        return descricaoMap.get(descricao);
    }

    private TipoPessoa(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }
}
