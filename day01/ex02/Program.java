public class Program {
    public static void main(String[] args) throws UserNotFoundException {
        UsersArrayList list = new UsersArrayList();

        System.out.println("num of users: " + list.retrieveNumbersOfUsers());
        System.out.println("Capacity " + list.getCapacity());
        list.addUser(new User("Tom", 50000));
        list.addUser(new User("Sam", 25000));
        list.addUser(new User("Paul", 98000));
        list.addUser(new User("Lee", 36000));
        list.addUser(new User("Tedd", 29000));
        list.addUser(new User("Lisa", 33000));
        System.out.println("num of users: " + list.retrieveNumbersOfUsers());
        list.addUser(new User("Estela", 123000));
        list.addUser(new User("Akira", 110000));
        list.addUser(new User("Julian", 9000));
        list.addUser(new User("Chad", 150000));
        list.addUser(new User("Virgil", 2000));
        list.addUser(new User("Mike", 200));
        System.out.println("num of users: " + list.retrieveNumbersOfUsers());
        System.out.println("Capacity " + list.getCapacity());
        System.out.println(list.retrieveUserByIndex(-10).getName());
        System.out.println(list.retrieveUserById(3).getName());

    }
}
