package edu.school21.chat.repositories;

import edu.school21.chat.exeptions.NotSavedSubEntityException;
import edu.school21.chat.models.ChatRoom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import javax.sql.DataSource;
import java.sql.*;
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

    @Override
    public boolean save(Message message) throws SQLException {
        String sqlRequest = "insert into chat.messages (author, room_id, message, time) values (" +
                message.getAuthor().getUserId() + ", " + message.getRoomMessage().getRoomId() + ", " +
                "'" + message.getText() + "', " + "'" + message.getTime() + "');";
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlRequest, Statement.RETURN_GENERATED_KEYS);
            statement.execute();
            ResultSet key = statement.getGeneratedKeys();
            key.next();
            message.setMessageId(key.getLong(1));
            connection.close();
            statement.close();
            key.close();
        } catch (SQLException ex) {
            throw new NotSavedSubEntityException("Can't save message");
        }
        return true;
    }

    @Override
    public boolean update(Message message) {
        String sqlRequest = "update chat.messages set " +
                "author = ? , " +
                "room_id = ? , " +
                "message = ? , " +
                "time = ? " +
                "where id = ?;";
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlRequest);
            statement.setLong(1, message.getAuthor().getUserId());
            statement.setLong(2, message.getRoomMessage().getRoomId());
            statement.setString(3, message.getText());
            try {
                statement.setTimestamp(4, Timestamp.valueOf(message.getTime()));
            } catch (NullPointerException e) {
                statement.setTimestamp(4, null);
            }
            statement.setLong(5, message.getMessageId());
            try {
                statement.execute();
            } catch (SQLException e) {
                throw new NotSavedSubEntityException("Can't update message");
            }
            connection.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
