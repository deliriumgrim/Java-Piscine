import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int week = 1;
        int count = 1;
        long grades = 0;
        int minValueWeek;

        String line = scanner.nextLine();
        while (week <= 18 && !line.equals("42")) {
            if (!line.equals("Week " + week)) {
                error(scanner);
            }
            minValueWeek = getMin(scanner);
            grades = collectGrades(minValueWeek, grades, week);
            week++;
            if (week == 19) {
                break;
            }
            line = scanner.nextLine();
        }
        while (count < week) {
            drawGrades(unpackGrade(grades, count), count);
            count++;
        }
        scanner.close();
    }

    private static long unpackGrade(long grades, int count) {
        while (count != 1) {
            grades /= 10;
            count--;
        }
        return grades % 10;
    }

    private static void drawGrades(long finalGrade, int week) {
        System.out.print("Week " + week + " ");
        while (finalGrade != 0) {
            System.out.print("=");
            finalGrade--;
        }
        System.out.println(">");
    }

    private static long collectGrades(int minValueWeek, long grades, int week) {
        long pow = 1;
        int count = 1;

        while (count < week) {
            pow *= 10;
            count++;
        }
        return (grades + minValueWeek * pow);
    }

    private static int getMin(Scanner scanner) {
        int current, min;
        int count = 0;

        min = 0;
        while (count < 5) {
            current = scanner.nextInt();
            if (current > 9 || current < 1) {
                error(scanner);
            }
            if (count == 0) {
                min = current;
            }
            else if (current < min) {
                min = current;
            }
            count++;
        }
        scanner.nextLine();
        return (min);
    }

    private static void error(Scanner scanner) {
        System.err.println("Illegal argument");
        scanner.close();
        System.exit(-1);
    }
}
