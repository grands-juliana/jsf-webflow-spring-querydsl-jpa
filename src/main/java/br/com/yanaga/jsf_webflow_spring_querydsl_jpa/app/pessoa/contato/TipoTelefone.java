package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa.contato;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Map;

public enum TipoTelefone{

    PRINCIPAL("Principal"),
    COBRANCA("Cobrança"),
    COMERCIAL("Comercial"),
    RESIDENCIAL("Residencial");

    private final String descricao;

    private static final Map<String, TipoTelefone> descricaoMap;

    static {
        Builder<String, TipoTelefone> builder = ImmutableMap.builder();
        for(TipoTelefone telefone : values()) {
            builder.put(telefone.getDescricao(), telefone);
        }
        descricaoMap = builder.build();
    }

    public static TipoTelefone fromDescricao(String descricao){
        return descricaoMap.get(descricao);
    }

    private TipoTelefone(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }
}
