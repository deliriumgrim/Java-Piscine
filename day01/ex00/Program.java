package ex00;

public class Program {
    public static void main(String[] args) {
        User userFirst = new User("First", 1000);
        User userSecond = new User("Second", 500);

        System.out.print("Balance: " + userFirst.getBalance());
        System.out.print(" Name: " + userFirst.getName());
        System.out.println(" ID: " + userFirst.getIdentifier());
        System.out.print("Balance: " + userSecond.getBalance());
        System.out.print(" Name: " + userSecond.getName());
        System.out.println(" ID: " + userSecond.getIdentifier());
        System.out.println("");
        Transaction trans1 = new Transaction(userFirst, userSecond,100);
        System.out.println("Type of transaction: " + trans1.getType());
        System.out.println("Amount: " + trans1.getAmount() + " ID " + trans1.getIdentifier());
        System.out.println("Sender: " + trans1.getSender().getName() + " Recipient: " + trans1.getRecipient().getName());
        System.out.println("");
        System.out.print("Balance: " + userFirst.getBalance());
        System.out.print(" Name: " + userFirst.getName());
        System.out.println(" ID: " + userFirst.getIdentifier());
        System.out.print("Balance: " + userSecond.getBalance());
        System.out.print(" Name: " + userSecond.getName());
        System.out.println(" ID: " + userSecond.getIdentifier());
    }
}