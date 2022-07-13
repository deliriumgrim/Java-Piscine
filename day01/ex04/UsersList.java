package ex04;

public interface UsersList {
    void addUser(User user);

    User retrieveUserById(Integer id) throws UserNotFoundException;

    User retrieveUserByIndex(Integer Index);

    Integer retrieveNumbersOfUsers();
}
