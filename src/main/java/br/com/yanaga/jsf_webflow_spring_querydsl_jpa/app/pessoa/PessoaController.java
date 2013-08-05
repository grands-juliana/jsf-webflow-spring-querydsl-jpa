package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa;

import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa.contato.Contato;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa.endereco.Endereco;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa.enderecoeletronico.EnderecoEletronico;
import com.google.common.base.Strings;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.Predicate;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PessoaController{

    @Autowired
    PessoaRepository pessoaRepository;

    public Filtro newFiltro(){
        return new Filtro();
    }

    public List<Pessoa> filtrar(Filtro filtro){
        return pessoaRepository.findAll();
    }

    public Pessoa newPessoa(){
        return Pessoa.newInstance();
    }

    public Endereco newEndereco(Pessoa pessoa){
        return Endereco.newInstance(pessoa);
    }

    public Contato newContato(Pessoa pessoa){
        return Contato.newInstance(pessoa);
    }

    public EnderecoEletronico newEnderecoEletronico(Pessoa pessoa){
        return EnderecoEletronico.newInstance(pessoa);
    }

    public void salvar(Pessoa pessoa){
        pessoaRepository.save(pessoa);
    }

    public static class Filtro implements Serializable{

		private static final long serialVersionUID = 1L;
		private String value;

        public String getValue(){
            return value;
        }

        public void setValue(String value){
            this.value = value;
        }

        public Predicate toPredicate(){
            BooleanBuilder builder = new BooleanBuilder();
            if(!Strings.isNullOrEmpty(value)) {
                QPessoa qPessoa = QPessoa.pessoa;
                builder.and(qPessoa.nomeRazaoSocial.containsIgnoreCase(value));                
            }
            return builder;
        }
    }
}
