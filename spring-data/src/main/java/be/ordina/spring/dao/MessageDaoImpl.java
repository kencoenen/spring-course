package be.ordina.spring.dao;

import be.ordina.spring.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Ken Coenen
 */
@Component
public class MessageDaoImpl implements MessageDao {
    @Autowired
    private DataSource ds;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Message getMessage(Long id) {
        Connection conn = null;
        try {
            // Don't ask a connection from the DriverManager, but from the already configured DataSource
            conn = ds.getConnection();

            PreparedStatement preparedStatement = conn.prepareStatement("select * from message where id = ?");
            preparedStatement.setLong(1, 2L);
            ResultSet rset = preparedStatement.executeQuery();
            if (rset.next()) {
                return new Message(rset.getLong("id"), rset.getString("message"), rset.getString("recipient"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public int getCount() {
        return jdbcTemplate.queryForObject("select count(*) from message", Integer.class);
    }
}
