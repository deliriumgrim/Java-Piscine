public class User {
    private String name;

    private final Integer identifier;

    private static Integer id = 0;

    private Integer balance;

    public User(String name, Integer balance) {
        setName(name);
        id++;
        identifier = id;
        if (balance > 0) {
            this.balance = balance;
        } else {
            this.balance = 0;
        }
    }

    public void setName(String name) {
        if (name.length() == 0) {
            this.name = "NameNotFound";
        } else {
            this.name = name;
        }
    }

    public void setBalance(Integer balance) {
        if (balance >= 0) {
            this.balance = balance;
        }
    }

    public Integer getIdentifier() {
        return identifier;
    }

    public Integer getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }
}

