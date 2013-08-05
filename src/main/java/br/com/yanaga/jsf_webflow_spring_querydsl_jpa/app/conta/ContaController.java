package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.conta;

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
public class ContaController {

    @Autowired
    ContaRepository contaRepository;

    @Autowired
    PessoaRepository pessoaRepository;

    public Filtro newFiltro() {
        return new Filtro();
    }

    public void salvar(Conta conta) {
        contaRepository.save(conta);
    }

    public Conta newConta() {
        return Conta.newInstance();
    }

    public List<Conta> filtrar(Filtro filtro) {
        return contaRepository.findAll();
    }

    public List<Pessoa> complete(String value) {
        return pessoaRepository.consultaCnpjRazao(value);
    }

    public static class Filtro implements Serializable {

        private static final long serialVersionUID = 1L;

        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Predicate toPredicate() {
            BooleanBuilder builder = new BooleanBuilder();
            if (!Strings.isNullOrEmpty(value)) {
                QConta qConta = QConta.conta;
                builder.and(qConta.observacao.containsIgnoreCase("%%%"));
            }
            return builder;
        }
    }
}
