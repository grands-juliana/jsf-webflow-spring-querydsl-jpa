package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.conta.formapagamento;

import com.google.common.collect.ImmutableMap;
import java.util.Map;

public enum FormaPagamento {

    BOLETO("Boleto"),
    CARTAO_DE_CREDITO("Cartão de crédito"),
    CARTAO_DE_DEBITO("Cartão de débito"),
    CHEQUE("Cheque"),
    DEPOSITO("Depósito"),
    DINHEIRO("Dinheiro"),
    TRANSFERENCIA("Transferência");

    private final String descricao;

    private static final Map<String, FormaPagamento> descricaoMap;

    static {
        ImmutableMap.Builder<String, FormaPagamento> builder = ImmutableMap.builder();
        for (FormaPagamento pagamento : FormaPagamento.values()) {
            builder.put(pagamento.getDescricao(), pagamento);
        }
        descricaoMap = builder.build();
    }

    public static FormaPagamento fromString(String descricao) {
        return descricaoMap.get(descricao);
    }

    public String getDescricao() {
        return descricao;
    }

    private FormaPagamento(String descricao) {
        this.descricao = descricao;
    }
}
