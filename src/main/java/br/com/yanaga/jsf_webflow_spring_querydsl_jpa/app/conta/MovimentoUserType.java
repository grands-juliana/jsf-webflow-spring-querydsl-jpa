package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.conta;

import br.com.insula.opes.hibernate.usertype.ImmutableUserType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;

public class MovimentoUserType extends ImmutableUserType {

    private static final long serialVersionUID = 1L;

    @Override
    public int[] sqlTypes() {
        return new int[]{Types.VARCHAR};
    }

    @Override
    public Class<?> returnedClass() {
        return Movimento.class;
    }

    @Override
    public Object nullSafeGet(ResultSet rs,
            String[] strings,
            SessionImplementor si,
            Object o) throws HibernateException, SQLException {
        return Movimento.fromString(rs.getString(strings[0]));
    }

    @Override
    public void nullSafeSet(PreparedStatement ps,
            Object o,
            int i,
            SessionImplementor si) throws HibernateException, SQLException {
        ps.setString(i, ((Movimento) o).getDescricao());
    }
}