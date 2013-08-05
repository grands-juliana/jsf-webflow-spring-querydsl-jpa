package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.conta.documento;

import com.google.common.base.Objects;
import javax.persistence.Entity;

@Entity
public class DocumentoConta extends Documento {

    private static final long serialVersionUID = 1L;

    protected DocumentoConta() {
    }

    public static DocumentoConta newInstance() {
        return new DocumentoConta();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof DocumentoConta) {
            DocumentoConta other = ((DocumentoConta) obj);
            return Objects.equal(this, other);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).toString();
    }
}
