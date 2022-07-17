import java.util.UUID;

public class Program {
    public static void main(String[] args) throws TransactionNotFoundException {
        TransactionsLinkedList list = new TransactionsLinkedList();

        User a = new User("a", 540);
        User b = new User("b", 270);
        User c = new User("c", 2000);
        Transaction one = new Transaction(a, b, 120);
        Transaction two = new Transaction(c, b, -40);
        Transaction three = new Transaction(b, a, 210);
        Transaction four = new Transaction(c, a, 330);
        Transaction five = new Transaction(c, b, 580);
        Transaction six = new Transaction(a, c, 3324235);
        a.getTransactionsList().removeTransaction(one.getIdentifier());
        Transaction[] arrA = a.getTransactionsList().transformIntoArray();
        Transaction[] arrB = b.getTransactionsList().transformIntoArray();
        Transaction[] arrC = c.getTransactionsList().transformIntoArray();
        System.out.println("list of transactions a:");
        printTransactions(arrA);
        System.out.println("list of transactions b:");
        printTransactions(arrB);
        System.out.println("list of transactions c:");
        printTransactions(arrC);
    }
    public static void printTransactions(Transaction[] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("UUID: " + arr[i].getIdentifier() + ", ");
            System.out.printf("sender: %s, recipient: %s, amount: %d",
                    arr[i].getSender().getName(),
                    arr[i].getRecipient().getName(),
                    arr[i].getAmount());
            System.out.println();
        }
    }
}
