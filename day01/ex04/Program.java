package ex04;

import java.util.UUID;

public class Program {
    public static void main(String[] args) throws IllegalTransactionException, UserNotFoundException, TransactionNotFoundException {

        TransactionsService service = new TransactionsService();
        User a = new User("A", 10000);
        User b = new User("B", 10000);
        User c = new User("C", 10000);
        service.addingUser(a);
        service.addingUser(b);
        service.addingUser(c);
        service.performingTransferTransaction(a.getIdentifier(), b.getIdentifier(), 500);
        service.performingTransferTransaction(a.getIdentifier(), b.getIdentifier(), 100);
        service.performingTransferTransaction(a.getIdentifier(), c.getIdentifier(), 10);
        service.performingTransferTransaction(b.getIdentifier(), c.getIdentifier(), 1000);
        service.performingTransferTransaction(c.getIdentifier(), a.getIdentifier(), 250);
        System.out.println("Balance A " + service.retrieveUserBalance(a.getIdentifier()));
        System.out.println("Balance B " + service.retrieveUserBalance(b.getIdentifier()));
        System.out.println("Balance C " + service.retrieveUserBalance(c.getIdentifier()));
        System.out.println("");
        System.out.println("A transactions");
        printArr(service.getTransactionsOfUser(a.getIdentifier()));
        System.out.println("");
        System.out.println("B transactions");
        printArr(service.getTransactionsOfUser(b.getIdentifier()));
        System.out.println("");
        System.out.println("C transactions");
        printArr(service.getTransactionsOfUser(c.getIdentifier()));
        System.out.println("");
        Transaction[] mass = a.getTransactionsList().transformIntoArray();
        UUID id_trans = mass[0].getIdentifier();
        a.getTransactionsList().removeTransaction(id_trans);
        System.out.println("Removed trans ID from A " + id_trans);
        mass = c.getTransactionsList().transformIntoArray();
        id_trans = mass[0].getIdentifier();
        c.getTransactionsList().removeTransaction(id_trans);
        System.out.println("Removed trans ID from C " + id_trans);
        System.out.println("");
        System.out.println("Unpair transactions");
        printArr(service.getUnpairTransactions());
    }
    public static void printArr(Transaction[] arr)
    {
       for (Integer i = 0; i < arr.length; i++){
           System.out.print("ID " + arr[i].getIdentifier());
           System.out.print(" Sender " + arr[i].getSender().getName() + " ");
           System.out.print("Recipient " + arr[i].getRecipient().getName());
           System.out.print(" Category " + arr[i].getCategory());
           System.out.println(" Amount " + arr[i].getAmount());
       }
    }
}