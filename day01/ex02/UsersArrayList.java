package ex02;

public class UsersArrayList implements UsersList {

    private final Integer DEFAULT_CAPACITY = 10;

    private Integer numOfUsers;

    private Integer capacity;

    private User[] usersList;

    public Integer getCapacity() {
        return capacity;
    }

    public UsersArrayList() {
        numOfUsers = 0;
        capacity = DEFAULT_CAPACITY;
        usersList = new User[capacity];
    }

    @Override
    public void addUser(User user) {
        if (numOfUsers.equals(capacity)) {
            increaseCapacity();
        }
        usersList[numOfUsers] = user;
        numOfUsers++;
    }

    private void increaseCapacity() {
        User[] tmp = new User[capacity * 2];
        for (int i = 0; i < numOfUsers; i++) {
            tmp[i] = usersList[i];
        }
        capacity *= 2;
        usersList = tmp;
    }

    @Override
    public User retrieveUserById(Integer id) throws UserNotFoundException {
        for (Integer i = 0; i < numOfUsers; i++) {
            if (id.equals(usersList[i].getIdentifier()))
                return usersList[i];
            }
            throw new UserNotFoundException("User not found");
    }

    @Override
    public User retrieveUserByIndex(Integer index) {
        return usersList[index];
    }

    @Override
    public Integer retrieveNumbersOfUsers() {
        return numOfUsers;
    }
}
