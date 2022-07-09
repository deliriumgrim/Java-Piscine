public class Program {
    public static void main(String[] args) {
        int sum = 479598;
        int result = 0;

        result += sum % 10;
        sum /= 10;
        result += sum % 10;
        sum /= 10;
        result += sum % 10;
        sum /= 10;
        result += sum % 10;
        sum /= 10;
        result += sum % 10;
        sum /= 10;
        result += sum % 10;
        System.out.println(result);
    }
}