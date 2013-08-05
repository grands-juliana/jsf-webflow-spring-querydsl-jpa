package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@MappedSuperclass
public class AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Version
    Integer version;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataCadastro = new Date();

    public Long getId() {
        return id;
    }

    public Integer getVersion() {
        return version;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
