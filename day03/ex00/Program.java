public class Program {
    public static void main(String[] args) throws InterruptedException {
        if (args.length != 1 || !args[0].startsWith("--count=")) {
            System.out.println("Wrong arguments");
            System.exit(-1);
        }
        int input = Integer.parseInt(args[0].substring(8));
        Egg egg = new Egg(input);
        Hen hen = new Hen(input);
        egg.start();
        hen.start();
        hen.join();
        egg.join();
        for (int i = 0; i < input; i++) {
            System.out.println("HUMAN");
        }
    }
}