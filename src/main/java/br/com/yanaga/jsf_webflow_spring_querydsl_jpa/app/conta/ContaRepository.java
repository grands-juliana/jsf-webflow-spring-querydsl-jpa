package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.conta;

import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.data.ListQueryDslJpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long>, ListQueryDslJpaRepository<Conta> {
}
