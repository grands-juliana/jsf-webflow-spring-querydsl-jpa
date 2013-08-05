package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa;

import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa.enderecoeletronico.EnderecoEletronico;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa.contato.Contato;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa.endereco.Endereco;
import br.com.insula.opes.CpfCnpj;
import br.com.insula.opes.InscricaoEstadual;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.AbstractEntity;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Pessoa extends AbstractEntity{

	private static final long serialVersionUID = 1L;

	@NotNull
    private NomeRazaoSocial nomeRazaoSocial;

    @NotNull
    private CpfCnpj cpfCnpj;

    @NotNull
    private NomeRazaoSocial apelidoFantasia;

    @NotNull
    private InscricaoEstadual inscricaoEstadual;

    @Size(max = Integer.MAX_VALUE)
    private String observacao;

    @NotNull
    private TipoPessoa tipoPessoa = TipoPessoa.Juridica;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Endereco> enderecos = Lists.newLinkedList();

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contato> contatos = Lists.newLinkedList();

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EnderecoEletronico> enderecoEletronicos = Lists.newLinkedList();

    protected Pessoa(){
    }

    public static Pessoa newInstance(){
        return new Pessoa();
    }

    @Override
    public boolean equals(Object obj){
        if(obj == this) {
            return true;
        }
        if(obj instanceof Pessoa) {
            Pessoa other = (Pessoa) obj;
            return Objects.equal(this.nomeRazaoSocial, other.nomeRazaoSocial)
                    && Objects.equal(this.cpfCnpj, other.cpfCnpj);
        }
        return false;
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(this.nomeRazaoSocial, this.cpfCnpj);
    }

    @Override
    public String toString(){
        return Objects.toStringHelper(this).add("nomeRazaoSocial", nomeRazaoSocial).add("cpfCnpj", cpfCnpj)
                .add("nomeFantasia", apelidoFantasia).add("inscricaoEstadual", inscricaoEstadual)
                .add("observacao", observacao).add("tipoPessoa", tipoPessoa).toString();
    }

    public List<Endereco> getEnderecos(){
        return ImmutableList.copyOf(enderecos);
    }

    public void addEndereco(Endereco endereco){
        Preconditions.checkNotNull(endereco, "Endereço nao pode ser nulo.");
        if(!enderecos.contains(endereco)) {
            enderecos.add(endereco);
        }
    }

    public void removeEndereco(Endereco endereco){
        Preconditions.checkNotNull(endereco, "Endereço nao pode ser nulo.");
        enderecos.remove(endereco);
    }

    public List<Contato> getContatos(){
        return contatos;
    }

    public void addContato(Contato contato){
        Preconditions.checkNotNull(contato, "Contato não pode ser nulo.");
        if(!contatos.contains(contato)) {
            contatos.add(contato);
        }
    }

    public void removeContato(Contato contato){
        Preconditions.checkNotNull(contato, "Contato não pode ser nulo.");
        contatos.remove(contato);
    }

    public List<EnderecoEletronico> getEnderecoEletronicos(){
        return enderecoEletronicos;
    }

    public void addEnderecoEletronico(EnderecoEletronico eletronico){
        Preconditions.checkNotNull(eletronico, "Endereço eletronico não pode ser nulo.");
        if(!enderecoEletronicos.contains(eletronico)) {
            enderecoEletronicos.add(eletronico);
        }
    }

    public void removeEnderecoEletronico(EnderecoEletronico eletronico){
        Preconditions.checkNotNull(eletronico, "Endereço eletronico não pode ser nulo.");
        enderecoEletronicos.remove(eletronico);
    }

    public NomeRazaoSocial getNomeRazaoSocial() {
        return nomeRazaoSocial;
    }

    public void setNomeRazaoSocial(NomeRazaoSocial nomeRazaoSocial) {
        this.nomeRazaoSocial = nomeRazaoSocial;
    }


    public CpfCnpj getCpfCnpj(){
        return cpfCnpj;
    }

    public void setCpfCnpj(CpfCnpj cpfCnpj){
        this.cpfCnpj = cpfCnpj;
    }

    public NomeRazaoSocial getApelidoFantasia(){
        return apelidoFantasia;
    }

    public void setApelidoFantasia(NomeRazaoSocial apelidoFantasia){
        this.apelidoFantasia = apelidoFantasia;
    }

    public InscricaoEstadual getInscricaoEstadual(){
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(InscricaoEstadual inscricaoEstadual){
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getObservacao(){
        return observacao;
    }

    public void setObservacao(String observacao){
        this.observacao = observacao;
    }

    public TipoPessoa getTipoPessoa(){
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa){
        this.tipoPessoa = tipoPessoa;
    }
}
