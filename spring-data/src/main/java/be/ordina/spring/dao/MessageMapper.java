package be.ordina.spring.dao;

import be.ordina.spring.domain.Message;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Map each {@link java.sql.ResultSet} row into a {@link be.ordina.spring.domain.Message} object.
 * Do this in a separate class so that we can reuse it.
 *
 * @author Ken Coenen
 */
public class MessageMapper implements RowMapper<Message> {
    @Override
    public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Message(rs.getLong("id"), rs.getString("message"), rs.getString("recipient"));
    }
}