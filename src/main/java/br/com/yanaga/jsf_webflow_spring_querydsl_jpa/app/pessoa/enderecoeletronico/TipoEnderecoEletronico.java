package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa.enderecoeletronico;

import com.google.common.collect.ImmutableMap;
import java.util.Map;

public enum TipoEnderecoEletronico {

    EMAIL("E-mail"),
    SITE("Site"),
    MSN("Msn"),
    TWITTER("Twitter"),
    FACEBOOK("Facebook"),
    LINKEDIN("Linkedin"),
    SKYPE("Skype"),
    GTALK("Gtalk"),
    BLOG("Blog"),
    YAHOO_MENSSEGER("Yahoo Messenger");

    private final String descricao;

    private static final Map<String, TipoEnderecoEletronico> descricaoMap;

    static {
        ImmutableMap.Builder<String, TipoEnderecoEletronico> builder = ImmutableMap.builder();
        for (TipoEnderecoEletronico endereco : values()) {
            builder.put(endereco.getDescricao(), endereco);
        }
        descricaoMap = builder.build();
    }

    public static TipoEnderecoEletronico fromDescricao(String descricao) {
        return descricaoMap.get(descricao);
    }

    private TipoEnderecoEletronico(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
