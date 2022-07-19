package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.ChatRoom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Program {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/mydb";
    private static final String DB_USER = "postgres";
    private static final String DB_PWD = "123";

    public static void main(String[] args) throws SQLException, FileNotFoundException {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(DB_URL);
        ds.setUsername(DB_USER);
        ds.setPassword(DB_PWD);
        MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(ds);
        User author = new User(1L, "User", "123", new ArrayList<>(), new ArrayList<>());
        ChatRoom room = new ChatRoom(1L, "chatroom", author, new ArrayList<>());
        Message message = new Message(null, author, room, "Hello World!", LocalDateTime.now());
        messagesRepository.save(message);
        System.out.println(message.getMessageId());
        ds.close();
    }
}
