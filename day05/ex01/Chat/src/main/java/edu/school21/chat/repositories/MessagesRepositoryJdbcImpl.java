package edu.school21.chat.repositories;

import edu.school21.chat.models.ChatRoom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {

    private final DataSource dataSource;

    public MessagesRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Optional<Message> findById(long id) throws SQLException {

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        String sqlRequest = "select * from chat.messages where id = " + id;
        ResultSet resultSet = statement.executeQuery(sqlRequest);
        resultSet.next();
        User user = new User(1L, "user", "user", null, null);
        ChatRoom chatRoom = new ChatRoom(1L, "chatroom", null, null);
        Optional<Message> optionalMessage = Optional.of(new Message((long) resultSet.getInt(1),
                user, chatRoom, resultSet.getString("message"), LocalDateTime.now()));
        connection.close();
        statement.close();
        resultSet.close();
        return optionalMessage;
    }
}
