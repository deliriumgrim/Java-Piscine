import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        int week = 1;
        int count = 1;
        long grades = 0;
        long finalGrade;
        int minValueWeek;

        String stop = "42";
        String weekText = "Week ";
        Scanner scanner = new Scanner(System.in);
        String stringWeek = scanner.nextLine();

        while (week <= 18 && !stringWeek.equals(stop)) {
            if(!stringWeek.equals(weekText + week)) {
                error();
            }
            minValueWeek = getMin(scanner);
            grades = collectGrade(minValueWeek, grades, week);
            week++;
            if (week == 19) {
                System.out.println();
                break ;
            }
            stringWeek = scanner.nextLine();
            if (stringWeek.equals(stop)) {
                System.out.println();
            }
        }
        while (count < week) {
            finalGrade = unpackGrade(grades, count);
            drawGrade(finalGrade, count);
            count++;
        }
        System.exit(0);
    }
    private static void drawGrade(long finalGrade, int week) {
        int count = 0;

        System.out.println("Week " + week);
        while (count < finalGrade) {
            System.out.print("=");
            count++;
        }
        System.out.println(">");
    }
    private static long unpackGrade(long grades, int week) {
        long res;
        long tmp;
        int count = 1;

        tmp = grades;
        while (count < week) {
            tmp /= 10;
            count++;
        }
        res = tmp % 10;
        return (res);
    }
    private static long collectGrade(int minValueGrade, long grades, int week) {
        long res;
        long pow = 1;
        int count = 1;

        while (count < week) {
            pow *= 10;
            count++;
        }
        res = grades + (minValueGrade * pow);
        return (res);
    }
    private static int  getMin(Scanner scanner) {
        int min = scanner.nextInt();
        int current;
        int count = 0;

        if (min > 9 || min < 1) {
            error();
        }
        while (count < 4) {
            current = scanner.nextInt();
            if (current > 9 || current < 1) {
                error();
            }
            if (min > current) {
                min = current;
            }
            count++;
        }
        scanner.nextLine();
        return (min);
    }
    private static void error() {
        System.err.println("Illegal argument");
        System.exit(-1);
    }
}
