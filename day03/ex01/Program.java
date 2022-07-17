public class Program {
    public static int input;

    public static void main(String[] args) throws InterruptedException {
        if (args.length != 1 || !args[0].startsWith("--count=")) {
            System.out.println("Wrong arguments");
            System.exit(-1);
        }
        input = Integer.parseInt(args[0].substring(8));
        input *= 2;
        Thread egg = new Thread(new PrintMessage("Egg"));
        Thread hen = new Thread(new PrintMessage("Hen"));
        egg.start();
        hen.start();
    }
}