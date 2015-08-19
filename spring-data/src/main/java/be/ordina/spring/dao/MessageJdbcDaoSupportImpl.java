package be.ordina.spring.dao;

import be.ordina.spring.domain.Message;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Ken Coenen
 */
@Repository
public class MessageJdbcDaoSupportImpl extends NamedParameterJdbcDaoSupport implements MessageDao {
    @Override
    public List<Message> getMessages() {
        return getJdbcTemplate().query("select * from message", new MessageMapper());
    }

    @Override
    public Message getMessage(Long id) {
        return getJdbcTemplate().queryForObject("select * from message where id = ?", new Object[]{id}, new MessageMapper());
    }

    @Override
    public List<Message> searchMessages(String text) {
        SqlParameterSource params = new MapSqlParameterSource("text", text);
        return getNamedParameterJdbcTemplate().query("select * from message where message like '%' || :text || '%'", params, new MessageMapper());
    }

    @Override
    public int getCount() {
        return getJdbcTemplate().queryForObject("select count(*) from message", Integer.class);
    }
}
