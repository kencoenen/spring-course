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
        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:mem:", "sa", "");
            Statement st = conn.createStatement();
            st.execute("create table message(id integer, message varchar(1024), recipient varchar(128))");
            st.execute("insert into message values (1, 'Hello Ordina!', 'info@ordina.be')");
            st.execute("insert into message values (2, 'Hello again, anybody there?', 'info@ordina.be')");
            st.execute("insert into message values (3, 'Never mind...', 'info@ordina.be')");

            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("select message, recipient from message");
            while (rset.next()) {
                logger.info("Message = {}", rset.getString(1));
            }

            PreparedStatement preparedStatement = conn.prepareStatement("select * from message where id = ?");
            preparedStatement.setLong(1, 2L);
            rset = preparedStatement.executeQuery();
            while (rset.next()) {
                logger.info("Message = {}, recipient = {}", rset.getString("message"), rset.getString("recipient"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
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
    }
}
