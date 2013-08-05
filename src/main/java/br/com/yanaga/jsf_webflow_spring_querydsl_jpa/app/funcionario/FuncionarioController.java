package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.funcionario;

import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa.Pessoa;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa.PessoaRepository;
import com.google.common.base.Strings;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.Predicate;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class FuncionarioController{

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public void salvar(Funcionario funcionario){
        pessoaRepository.save(funcionario.getPessoa());
        funcionarioRepository.save(funcionario);
    }

    public Funcionario newFuncionario(Pessoa pessoa){
        return Funcionario.newInstance(pessoa);
    }

    public Filtro newFiltro(){
        return new Filtro();
    }

    public List<Funcionario> filtrar(Filtro filtro){
        return funcionarioRepository.findAll();
    }

    public static class Filtro implements Serializable{

		private static final long serialVersionUID = 1L;
		private String values;

        public String getValues(){
            return values;
        }

        public void setValues(String values){
            this.values = values;
        }

        public Predicate toPredicate(){
            BooleanBuilder builder = new BooleanBuilder();
            if(!Strings.isNullOrEmpty(values)) {
                QFuncionario qFuncionario = QFuncionario.funcionario;
                builder.and(qFuncionario.discriminatorClass.containsIgnoreCase(values));
            }
            return builder;
        }
    }
}
