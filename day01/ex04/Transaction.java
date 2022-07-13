package ex04;

import java.util.UUID;
public class Transaction {

    private UUID identifier;

    private User recipient;

    private User sender;

    private Category type;
    private enum Category {
        DEBIT,
        CREDIT,
        INVALID
    }

    private Integer amount;

    public Transaction(UUID identifier, User recipient, User sender, String category, Integer amount) {
        this.recipient = recipient;
        this.sender = sender;
        this.amount = amount;
        this.identifier = identifier;
        if (category.equals("DEBIT")) {
            this.type = Category.DEBIT;
        }
        else if (category.equals("CREDIT")) {
            this.type = Category.CREDIT;
        } else {
            this.type = Category.INVALID;
        }
    }

    public UUID getIdentifier() {
        return identifier;
    }

    public User getRecipient() {
        return recipient;
    }

    public User getSender() {
        return sender;
    }

    public String getCategory() {
        if (type.equals(Category.CREDIT)) {
            return "CREDIT";
        } else if (type.equals(Category.DEBIT)) {
            return "DEBIT";
        } else {
            return "INVALID";
        }
    }

    public Integer getAmount() {
        return amount;
    }

}