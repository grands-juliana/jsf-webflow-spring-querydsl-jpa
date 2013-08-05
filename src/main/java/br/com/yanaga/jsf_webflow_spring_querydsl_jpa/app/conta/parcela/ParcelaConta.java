package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.conta.parcela;

import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.AbstractEntity;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.conta.Conta;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class ParcelaConta extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @NotNull
    private BigDecimal valorParcela;

    @NotNull
    private BigDecimal porcentagemJuros;

    @NotNull
    private BigDecimal juros;

    @NotNull
    private BigDecimal totalParcela;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name = "valoPago_fk")
    private List<ValorPagoParcela> valorPagoParcelas;

    private BigDecimal desconto;

    private BigDecimal multa;

    @Temporal(TemporalType.DATE)
    private Date dataVencimento;

    @Temporal(TemporalType.DATE)
    private Date dataQuitacao;

    @NotNull
    private SituacaoParcela situacaoParcela;

    @ManyToOne
    private Conta conta;

    protected ParcelaConta() {
    }

    public static ParcelaConta newInstance() {
        return new ParcelaConta();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("dataQuitacacao", dataQuitacao)
                .add("dataVencimento", dataVencimento).add("desconto", desconto).add("juros", juros)
                .add("multa", multa).add("porcentagemJuros", porcentagemJuros).add("situacaoParcela", situacaoParcela)
                .add("TotalParcelas", totalParcela).add("valorPagoParcelas", valorPagoParcelas).add("valorParcela", valorParcela)
                .toString();
    }

    public void addValorPagoParcela(ValorPagoParcela valorPagoParcela) {
        Preconditions.checkNotNull(valorPagoParcela, "Valor pago não pode ser nulo.");
        if (!valorPagoParcelas.contains(valorPagoParcela)) {
            valorPagoParcelas.add(valorPagoParcela);
        }
    }

    public List<ValorPagoParcela> getValorPagoParcelas() {
        return valorPagoParcelas;
    }

    public BigDecimal getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(BigDecimal valorParcela) {
        this.valorParcela = valorParcela;
    }

    public BigDecimal getPorcentagemJuros() {
        return porcentagemJuros;
    }

    public void setPorcentagemJuros(BigDecimal porcentagemJuros) {
        this.porcentagemJuros = porcentagemJuros;
    }

    public BigDecimal getJuros() {
        return juros;
    }

    public void setJuros(BigDecimal juros) {
        this.juros = juros;
    }

    public BigDecimal getTotalParcela() {
        return totalParcela;
    }

    public void setTotalParcela(BigDecimal totalParcela) {
        this.totalParcela = totalParcela;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public BigDecimal getMulta() {
        return multa;
    }

    public void setMulta(BigDecimal multa) {
        this.multa = multa;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataQuitacao() {
        return dataQuitacao;
    }

    public void setDataQuitacao(Date dataQuitacao) {
        this.dataQuitacao = dataQuitacao;
    }

    public SituacaoParcela getSituacaoParcela() {
        return situacaoParcela;
    }

    public void setSituacaoParcela(SituacaoParcela situacaoParcela) {
        this.situacaoParcela = situacaoParcela;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Conta getConta() {
        return conta;
    }
}
