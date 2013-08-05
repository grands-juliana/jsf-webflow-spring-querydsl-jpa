package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa;

import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa.Pessoa;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

@Component
public class PessoaValidator{

    public boolean validate(Pessoa pessoa,
                            MessageContext messages){
        if(pessoa.getEnderecos().isEmpty()) {
            messages.addMessage(new MessageBuilder().error().defaultText("É necessário informar um endereço!").build());
        }
        if(pessoa.getContatos().isEmpty()) {
            messages.addMessage(new MessageBuilder().error().defaultText("É necessário informar um contato!").build());
        }
        if(pessoa.getEnderecoEletronicos().isEmpty()) {
            messages.addMessage(new MessageBuilder().error().defaultText("É necessário informar um endereço eletronico!").build());
        }
        return !messages.hasErrorMessages();
    }
}
