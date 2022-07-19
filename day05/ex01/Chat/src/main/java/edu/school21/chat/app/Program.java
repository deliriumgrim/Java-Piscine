package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a message ID");
        long id = scanner.nextLong();
        try {
            if (messagesRepository.findById(id).isPresent()) {
                System.out.println(messagesRepository.findById(id).get());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        scanner.close();
        ds.close();
    }
}
