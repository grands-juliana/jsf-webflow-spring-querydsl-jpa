package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.conta;

import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.AbstractEntity;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.conta.documento.Documento;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.conta.parcela.ParcelaConta;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa.Pessoa;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(uniqueConstraints =
        @UniqueConstraint(columnNames = {"id"}))
public class Conta extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataQuitacao;

    @ManyToOne
    @JoinColumn(nullable = false, name = "pessoa_fk")
    private Pessoa pessoa;

    @OneToMany(mappedBy = "conta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ParcelaConta> parcelaContas = new LinkedList<>();

    @NotNull
    private OrigemConta origemConta = OrigemConta.MANUAL;

    @NotNull
    private SituacaoConta situacaoConta = SituacaoConta.ABERTA;

    @NotNull
    private Movimento movimento;

    @OneToOne
    private Documento documento;

    private String observacao;

    private BigDecimal valorTotal;

    protected Conta() {
    }

    public static Conta newInstance() {
        return new Conta();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj instanceof Conta) {
            Conta other = ((Conta) obj);
            return Objects.equal(this.documento, other.documento)
                    && Objects.equal(this.origemConta, other.origemConta)
                    && Objects.equal(this.pessoa, other.pessoa)
                    && Objects.equal(this.movimento, other.movimento)
                    && Objects.equal(this.valorTotal, other.valorTotal)
                    && Objects.equal(this.parcelaContas, other.parcelaContas);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.documento, this.origemConta, this.pessoa,
                this.movimento, this.valorTotal/*, this.parcelaContas*/);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("documento", documento)
                .add("origemConta", origemConta).add("pessoa", pessoa)/*.add("parcelaContas", parcelaContas)*/
                .add("movimento", movimento).add("valorTotal", valorTotal).toString();
    }

    public List<ParcelaConta> getParcelaContas() {
        return parcelaContas;
    }

    public void addParcela(ParcelaConta parcela) {
        Preconditions.checkNotNull(parcela, "Parcela não pode ser nulo.");
        if (!parcelaContas.contains(parcela)) {
            parcelaContas.add(parcela);
        }
    }

    public void removeParcela(ParcelaConta parcela) {
        Preconditions.checkNotNull(parcela, "Parcela não pode ser nulo.");
        parcelaContas.remove(parcela);
    }

    public Date getDataQuitacao() {
        return dataQuitacao;
    }

    public void setDataQuitacao(Date dataQuitacao) {
        this.dataQuitacao = dataQuitacao;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public OrigemConta getOrigemConta() {
        return origemConta;
    }

    public void setOrigemConta(OrigemConta origemConta) {
        this.origemConta = origemConta;
    }

    public SituacaoConta getSituacaoConta() {
        return situacaoConta;
    }

    public void setSituacaoConta(SituacaoConta situacaoConta) {
        this.situacaoConta = situacaoConta;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }
}
