package be.ordina.spring.dao;

import be.ordina.spring.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Ken Coenen
 */
@Repository
public class MessageDaoImpl implements MessageDao {
    @Autowired
    private DataSource ds;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Message> getMessages() {
        return jdbcTemplate.query("select * from message", new MessageMapper());
    }

    @Override
    public Message getMessage(Long id) {
        return queryMessageWithJdbcTemplate(id);
    }

    private Message queryMessageWithJdbcTemplate(Long id) {
        return jdbcTemplate.queryForObject("select * from message where id = ?", new Object[]{id}, new MessageMapper());
    }

    /**
     * Already uses a {@link javax.sql.DataSource}, but still with plain JDBC after obtaining the connection.
     */
    private Message queryMessageWithJdbc(Long id) {
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
    public List<Message> searchMessages(String text) {
        NamedParameterJdbcTemplate jdbcTemplate1 = new NamedParameterJdbcTemplate(ds);
        SqlParameterSource params = new MapSqlParameterSource("text", text);
        return jdbcTemplate1.query("select * from message where message like '%' || :text || '%'", params, new MessageMapper());
    }

    @Override
    public int getCount() {
        return jdbcTemplate.queryForObject("select count(*) from message", Integer.class);
    }
}
