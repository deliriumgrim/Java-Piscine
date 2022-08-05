package school21.spring.service.repositories;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import school21.spring.service.models.User;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository{

    JdbcTemplate jdbcTemplate;

    private final String INIT_FIRST = "CREATE TABLE IF NOT EXISTS users (identifier int, email varchar)";
    private final String INIT_SECOND = "DROP TABLE IF EXISTS users";
    private final String FIND_BY_ID = "SELECT * FROM users WHERE identifier=?";
    private final String SAVE = "INSERT INTO users (identifier, email) VALUES (?, ?)";
    private final String UPDATE = "UPDATE users SET email=? WHERE identifier = ?";
    private final String DELETE = "DELETE FROM users WHERE identifier = ?";
    private final String FIND_ALL = "SELECT * FROM users";
    private final String FIND_BY_EMAIL = "SELECT * FROM users WHERE email=?";

    public UsersRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void init() {
        try {
            jdbcTemplate.update(INIT_SECOND);
            jdbcTemplate.update(INIT_FIRST);
        } catch (Exception e) {
            System.err.println("Error: init failed");
        }
    }

    @Override
    public Optional<User> findById(Long id) {
        try {
            return jdbcTemplate.query(FIND_BY_ID, new BeanPropertyRowMapper<>(User.class), id).stream().findAny();
        } catch (Exception e) {
            System.err.println("Error: finding user failed");
            return Optional.empty();
        }
    }

    @Override
    public List<User> findAll() {
        try {
            return jdbcTemplate.query(FIND_ALL, new BeanPropertyRowMapper<>(User.class));
        } catch (Exception e) {
            System.err.println("Error: finding users failed");
            return null;
        }
    }

    @Override
    public void save(User entity) {
        try {
            jdbcTemplate.update(SAVE, entity.getIdentifier(), entity.getEmail());
        } catch (Exception e) {
            System.err.println("Error: save user failed");
        }
    }

    @Override
    public void update(User entity) {
        try {
            jdbcTemplate.update(UPDATE, entity.getEmail(), entity.getIdentifier());
        } catch (Exception e) {
            System.err.println("Error: user is not exists");
        }
    }

    @Override
    public void delete(Long id) {
        try {
            jdbcTemplate.update(DELETE, id);
        } catch (Exception e) {
            System.err.println("Error: removing user failed");
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try {
             return jdbcTemplate.query(FIND_BY_EMAIL, new BeanPropertyRowMapper<>(User.class), email).stream().findAny();
        } catch (Exception e) {
            System.err.println("Error: user is not exists");
            return Optional.empty();
        }
    }
}

