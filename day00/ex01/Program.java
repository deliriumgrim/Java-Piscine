import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean isPrime = true;
        int input = scan.nextInt();
        int count = 2;
        if (input < 2) {
            System.out.println("IllegalArgument");
            System.exit(-1);
        }
        if (input == 2) {
            System.out.println(true + " " + 1);
        }
        while (count * count <= input) {
            if (input % count == 0) {
                isPrime = false;
                break ;
            }
            count++;
        }
        System.out.println(isPrime + " " + (count - 1));
        System.exit(0);
    }
}