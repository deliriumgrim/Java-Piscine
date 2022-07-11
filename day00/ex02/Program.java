import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        int counter = 0;
        int stop = 42;
        int inputNumber;
        Scanner input;

        input = new Scanner(System.in);
        inputNumber = input.nextInt();
        if (inputNumber < 2) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
        while (inputNumber != stop) {
            if (isPrime(summ(inputNumber)))
                counter++;
            inputNumber = input.nextInt();
        }
        System.out.println("Count of coffee-request - " + counter);
        System.exit(0);
    }
    private static boolean isPrime(int summ) {
        for (int i = 2; i * i <= summ; i++) {
            if (summ % i == 0) {
                return (false);
            }
        }
        return (true);
    }
    private static int summ(int inputNumber) {
        int result = 0;

        while (inputNumber > 0) {
            result += inputNumber % 10;
            inputNumber /= 10;
        }
        return (result);
    }
}
