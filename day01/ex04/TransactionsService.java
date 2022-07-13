package ex04;

import java.util.UUID;

public class TransactionsService {

    private UsersList usersList;

    public TransactionsService() {
        this.usersList = new UsersArrayList();
    }

    public void addingUser(User user) {
        usersList.addUser(user);
    }

    public Integer retrieveUserBalance(Integer id) throws UserNotFoundException {
        return usersList.retrieveUserById(id).getBalance();
    }

    public void performingTransferTransaction(Integer senderId, Integer recipientId, Integer amount)
            throws IllegalTransactionException, UserNotFoundException {
        if (amount <= 0) {
            throw new IllegalTransactionException("Negative amount");
        }
        User sender = usersList.retrieveUserById(senderId);
        User recipient = usersList.retrieveUserById(recipientId);
        if (sender.getBalance() < amount) {
            throw new IllegalTransactionException("Amount is more than the sender's balance");
        }
        sender.setBalance(sender.getBalance() - amount);
        recipient.setBalance(recipient.getBalance() + amount);
        UUID id = UUID.randomUUID();
        Transaction credit = new Transaction(id, recipient, sender, "CREDIT", amount);
        sender.getTransactionsList().addTransaction(credit);
        Transaction debit = new Transaction(id, recipient, sender, "DEBIT", amount);
        recipient.getTransactionsList().addTransaction(debit);
    }

    public Transaction[] getTransactionsOfUser(Integer id) throws UserNotFoundException {
        User user = usersList.retrieveUserById(id);
        return user.getTransactionsList().transformIntoArray();
    }

    public void removingTransaction(Integer idUser, UUID idTransaction) throws UserNotFoundException, TransactionNotFoundException {
       usersList.retrieveUserById(idUser).getTransactionsList().removeTransaction(idTransaction);
    }

    public Transaction[] getUnpairTransactions() {
        Integer k;
        TransactionsList unpairedTransactions = new TransactionsLinkedList();
        for (Integer i = 0; i < usersList.retrieveNumbersOfUsers(); i++) {
            User usr = usersList.retrieveUserByIndex(i);
            Transaction[] usrTransactionArray = usr.getTransactionsList().transformIntoArray();
            for (Integer j = 0; j < usrTransactionArray.length; j++) {
                User usrRecipient = usrTransactionArray[j].getRecipient();
                User usrSender = usrTransactionArray[j].getSender();
                Transaction[] usrRecipientTransactionArray = usrRecipient.getTransactionsList().transformIntoArray();
                Transaction[] usrSenderTransactionArray = usrSender.getTransactionsList().transformIntoArray();
                for (k = 0; k < usrRecipientTransactionArray.length; k++){
                    if (usrRecipientTransactionArray[k].getIdentifier().equals(usrTransactionArray[j].getIdentifier())) {
                        break;
                    }
                }
                if (k == usrRecipientTransactionArray.length) {
                    unpairedTransactions.addTransaction(usrTransactionArray[j]);
                }
                for (k = 0; k < usrSenderTransactionArray.length; k++) {
                    if (usrSenderTransactionArray[k].getIdentifier().equals(usrTransactionArray[j].getIdentifier())) {
                        break;
                    }
                }
                if (k == usrSenderTransactionArray.length) {
                    unpairedTransactions.addTransaction(usrTransactionArray[j]);
                }
            }
        }
        return unpairedTransactions.transformIntoArray();
    }
}
