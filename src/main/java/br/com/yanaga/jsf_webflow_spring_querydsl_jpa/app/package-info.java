@TypeDefs({
    @TypeDef(name = "formaPagamento", defaultForType = FormaPagamento.class, typeClass = FormaPagamentoUserType.class),
    @TypeDef(name = "movimento", defaultForType = Movimento.class, typeClass = MovimentoUserType.class),
    @TypeDef(name = "nomeRazaoSocial", defaultForType = NomeRazaoSocial.class, typeClass = NomeRazaoSocialUserType.class),
    @TypeDef(name = "origemConta", defaultForType = OrigemConta.class, typeClass = OrigemContaUserType.class),
    @TypeDef(name = "situacaoConta", defaultForType = SituacaoConta.class, typeClass = SituacaoContaUserType.class),
    @TypeDef(name = "situacaoParcela", defaultForType = SituacaoParcela.class, typeClass = SituacaoParcelaUserType.class),
    @TypeDef(name = "tipoEmail", defaultForType = TipoEmail.class, typeClass = TipoEmailUserType.class),
    @TypeDef(name = "tipoEnderecoEletronico", defaultForType = TipoEnderecoEletronico.class, typeClass = TipoEnderecoEletronicoUserType.class),
    @TypeDef(name = "tipoEndereco", defaultForType = TipoEndereco.class, typeClass = TipoEnderecoUserType.class),
    @TypeDef(name = "tipoLogradouro", defaultForType = TipoLogradouro.class, typeClass = TipoLogradouroUserType.class),
    @TypeDef(name = "tipoOperadora", defaultForType = TipoOperadora.class, typeClass = TipoOperadoraUserType.class),
    @TypeDef(name = "tipoPessoa", defaultForType = TipoPessoa.class, typeClass = TipoPessoaUserType.class),
    @TypeDef(name = "tipoTelefone", defaultForType = TipoTelefone.class, typeClass = TipoTelefoneUserType.class),
    @TypeDef(name = "valor", defaultForType = Valor.class, typeClass = ValorUserType.class)})
package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app;

import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.conta.*;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.conta.formapagamento.FormaPagamento;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.conta.formapagamento.FormaPagamentoUserType;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.conta.parcela.SituacaoParcela;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.conta.parcela.SituacaoParcelaUserType;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.conta.valor.Valor;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.conta.valor.ValorUserType;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa.NomeRazaoSocial;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa.NomeRazaoSocialUserType;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa.TipoPessoa;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa.TipoPessoaUserType;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa.contato.TipoOperadora;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa.contato.TipoOperadoraUserType;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa.contato.TipoTelefone;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa.contato.TipoTelefoneUserType;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa.endereco.TipoEndereco;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa.endereco.TipoEnderecoUserType;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa.endereco.TipoLogradouro;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa.endereco.TipoLogradouroUserType;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa.enderecoeletronico.TipoEmail;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa.enderecoeletronico.TipoEmailUserType;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa.enderecoeletronico.TipoEnderecoEletronico;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa.enderecoeletronico.TipoEnderecoEletronicoUserType;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
