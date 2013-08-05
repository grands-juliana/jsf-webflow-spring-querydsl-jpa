package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.converter;

import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.conta.Movimento;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.conta.OrigemConta;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.conta.SituacaoConta;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.conta.formapagamento.FormaPagamento;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.conta.parcela.SituacaoParcela;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa.TipoPessoa;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa.contato.TipoOperadora;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa.contato.TipoTelefone;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa.endereco.TipoEndereco;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa.endereco.TipoLogradouro;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa.enderecoeletronico.TipoEmail;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa.enderecoeletronico.TipoEnderecoEletronico;
import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.stereotype.Controller;

@Controller
public class TypeActionConverter {

    public List<TipoEmail> getItemsEmail() {
        return ImmutableList.copyOf(TipoEmail.values());
    }

    public List<TipoEndereco> getItemsEndereco() {
        return ImmutableList.copyOf(TipoEndereco.values());
    }

    public List<TipoEnderecoEletronico> getItemsEnderecoEletronico() {
        return ImmutableList.copyOf(TipoEnderecoEletronico.values());
    }

    public List<TipoLogradouro> getItemsLogradouro() {
        return ImmutableList.copyOf(TipoLogradouro.values());
    }

    public List<TipoOperadora> getItemsOperadora() {
        return ImmutableList.copyOf(TipoOperadora.values());
    }

    public List<TipoTelefone> getItemsTelefone() {
        return ImmutableList.copyOf(TipoTelefone.values());
    }

    public List<TipoPessoa> getItemsPessoa() {
        return ImmutableList.copyOf(TipoPessoa.values());
    }

    public List<SituacaoConta> getItemsSituacaoConta() {
        return ImmutableList.copyOf(SituacaoConta.values());
    }

    public List<OrigemConta> getItemsOrigemConta() {
        return ImmutableList.copyOf(OrigemConta.values());
    }

    public List<SituacaoParcela> getItemsSituacaoParcela() {
        return ImmutableList.copyOf(SituacaoParcela.values());
    }

    public List<Movimento> getItemsMovimento() {
        return ImmutableList.copyOf(Movimento.values());
    }

    public List<FormaPagamento> getItemsFormaPagamento() {
        return ImmutableList.copyOf(FormaPagamento.values());
    }
}
