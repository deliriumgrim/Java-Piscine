public class Program {
    public static void main(String[] args) {
        User userFirst = new User("Fist", 500);
        System.out.print("Name: " + userFirst.getName() + " balance " + userFirst.getBalance());
        System.out.println(" ID: " + userFirst.getIdentifier());
        User userSecond = new User("Secoond", 1500);
        System.out.print("Name: " + userSecond.getName() + " balance " + userSecond.getBalance());
        System.out.println(" ID: " + userSecond.getIdentifier());
        User userThird =  new User("Third", 2500);
        System.out.print("Name: " + userThird.getName() + " balance " + userThird.getBalance());
        System.out.println(" ID: " + userThird.getIdentifier());
    }
}
