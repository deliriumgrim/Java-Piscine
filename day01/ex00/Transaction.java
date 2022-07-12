package ex00;


import java.util.UUID;
public class Transaction {

    private UUID identifier;

    private User recipient;

    private User sender;

    private enum Category {
        DEBIT,
        CREDIT
    }

    private Transaction.Category type;

    private Integer amount;

    public Transaction(User sender, User recipient, Integer amount) {
        setRecipient(recipient);
        setSender(sender);
        setAmount(amount);
        this.identifier = UUID.randomUUID();
        if (amount >= 0) {
            this.type = Category.DEBIT;
        }
        else {
            this.type = Category.CREDIT;
        }
        if (amount >= 0) {
            if (recipient.getBalance() >= amount) {
                sender.setBalance(sender.getBalance() + amount);
                recipient.setBalance(recipient.getBalance() - amount);
            }
        } else {
            if (sender.getBalance() >= amount * -1) {
                recipient.setBalance(recipient.getBalance() - amount);
                sender.setBalance(sender.getBalance() + amount);
            }
        }
    }

    public UUID getIdentifier() {
        return identifier;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public Category getType() {
        return type;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
