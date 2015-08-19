package be.ordina.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * @author Ken Coenen
 */
public class Example1_JDBC {
    private static final Logger logger = LoggerFactory.getLogger(Example1_JDBC.class);

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:mem:", "sa", "");
            stmt = conn.createStatement();
            stmt.execute("create table message(id integer, message varchar(1024), recipient varchar(128))");
            stmt.execute("insert into message values (1, 'Hello Ordina!', 'info@ordina.be')");
            stmt.execute("insert into message values (2, 'Hello again, anybody there?', 'info@ordina.be')");
            stmt.execute("insert into message values (3, 'Never mind...', 'info@ordina.be')");

            ResultSet rset = stmt.executeQuery("select message, recipient from message");
            while (rset.next()) {
                logger.info("Message = {}", rset.getString(1));
            }

            try (PreparedStatement ps = conn.prepareStatement("select * from message where id = ?")) {
                ps.setLong(1, 2L);
                rset = ps.executeQuery();
                while (rset.next()) {
                    logger.info("Message = {}, recipient = {}", rset.getString("message"), rset.getString("recipient"));
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
