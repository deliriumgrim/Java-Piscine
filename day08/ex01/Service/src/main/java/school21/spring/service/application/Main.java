package school21.spring.service.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import school21.spring.service.models.User;
import school21.spring.service.repositories.UsersRepository;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        System.out.println("JDBC:");
        UsersRepository usersRepository = context.getBean("usersRepositoryJdbc", UsersRepository.class);
        usersRepository.save(new User(1L, "Drink@mail.com"));
        usersRepository.save(new User(2L, "Walk@mail.com"));
        usersRepository.save(new User(3L, "Get@mail.com"));
        usersRepository.save(new User(4L, "Construct@mail.com"));
        usersRepository.save(new User(5L, "ioman@mail.com"));
        if (usersRepository.findById(1L).isPresent()) {
            System.out.println(usersRepository.findById(1L).get());
        }
        System.out.println(usersRepository.findAll());
        usersRepository.delete(5L);
        System.out.println(usersRepository.findAll());
        usersRepository.update(new User(2L, "Karim"));
        if (usersRepository.findById(2L).isPresent()) {
            System.out.println(usersRepository.findById(2L).get());
        }
        if(usersRepository.findByEmail("Get@mail.com").isPresent()) {
            System.out.println(usersRepository.findByEmail("Get@mail.com").get());
        }
        System.out.println("");
        System.out.println("JDBC TEMPLATE:");
        usersRepository = context.getBean("usersRepositoryJdbcTemplate", UsersRepository.class);
        usersRepository.save(new User(1L, "Drink@mail.com"));
        usersRepository.save(new User(2L, "Walk@mail.com"));
        usersRepository.save(new User(3L, "Get@mail.com"));
        usersRepository.save(new User(4L, "Construct@mail.com"));
        usersRepository.save(new User(5L, "ioman@mail.com"));
        if (usersRepository.findById(1L).isPresent()) {
            System.out.println(usersRepository.findById(1L).get());
        }
        System.out.println(usersRepository.findAll());
        usersRepository.delete(5L);
        System.out.println(usersRepository.findAll());
        usersRepository.update(new User(2L, "Karim"));
        if (usersRepository.findById(2L).isPresent()) {
            System.out.println(usersRepository.findById(2L).get());
        }
        if (usersRepository.findByEmail("Get@mail.com").isPresent()) {
            System.out.println(usersRepository.findByEmail("Get@mail.com").get());
        }
    }
}
