package school21.spring.service.repositories;

import school21.spring.service.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcImpl implements UsersRepository {

    private DataSource dataSource;

    private final String INIT_FIRST = "CREATE TABLE IF NOT EXISTS users (identifier int, email varchar)";
    private final String INIT_SECOND = "DROP TABLE IF EXISTS users";
    private final String FIND_BY_ID = "SELECT * FROM users WHERE identifier=?";
    private final String SAVE = "INSERT INTO users (identifier, email) VALUES (?, ?)";
    private final String UPDATE = "UPDATE users SET email=? WHERE identifier = ?";
    private final String DELETE = "DELETE FROM users WHERE identifier = ?";
    private final String FIND_ALL = "SELECT * FROM users";
    private final String FIND_BY_EMAIL = "SELECT * FROM users WHERE email=?";

    public UsersRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void init() {
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            statement.execute(INIT_SECOND);
            statement.execute(INIT_FIRST);
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println("Error: init failed");
        }
    }

    @Override
    public Optional<User> findById(Long id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Optional<User> user = Optional.empty();
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(FIND_BY_ID);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = Optional.of(new User(resultSet.getLong(1), resultSet.getString(2)));
            }
            connection.close();
            statement.close();
            resultSet.close();
        } catch (Exception e) {
            System.err.println("Error: finding user failed");
        }
        return (user);
    }

    @Override
    public List<User> findAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<User> users = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(FIND_ALL);
            resultSet = preparedStatement.executeQuery();
            users = new ArrayList<>();
            while (resultSet.next()) {
                users.add(new User(resultSet.getLong(1), resultSet.getString(2)));
            }
            connection.close();
            preparedStatement.close();
            resultSet.close();
        } catch (Exception e) {
            System.err.println("Error: finding all users failed");
        }
        return (users);
    }

    @Override
    public void save(User entity) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SAVE);
            statement.setLong(1, entity.getIdentifier());
            statement.setString(2, entity.getEmail());
            statement.execute();
            connection.close();
            statement.close();
        } catch (Exception e) {
            System.err.println("Error: saving user failed");
        }
    }

    @Override
    public void update(User entity) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setString(1, entity.getEmail());
            statement.setLong(2, entity.getIdentifier());
            statement.execute();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println("Error: updating user failed");
        }
    }

    @Override
    public void delete(Long id) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setLong(1, id);
            statement.execute();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println("Error: deleting user failed");
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Optional<User> user = Optional.empty();
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(FIND_BY_EMAIL);
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = Optional.of(new User(resultSet.getLong(1), resultSet.getString(2)));
            }
            connection.close();
            preparedStatement.close();
            resultSet.close();
        } catch (Exception e) {
            System.err.println("Error: finding by email failed");
        }
        return user;
    }
}
