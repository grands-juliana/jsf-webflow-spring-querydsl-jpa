package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.funcionario;

import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.data.ListQueryDslJpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>, ListQueryDslJpaRepository<Funcionario>, FuncionarioRepositoryCustom{
}
