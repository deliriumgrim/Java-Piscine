import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Program {

    public static int arraySize;

    public static int threadsCount;

    public static int[] arrayInt;

    public static int finalSum = 0;


    public static void main(String[] args) throws InterruptedException {
        int sum = 0;
        if (args.length != 2 || !args[0].startsWith("--arraySize=") || !args[1].startsWith("--threadsCount=")) {
            System.out.println("Wrong arguments");
            System.exit(-1);
        }
        arraySize = Integer.parseInt(args[0].substring(12));
        threadsCount = Integer.parseInt(args[1].substring(15));
        if (arraySize > 2000000 || threadsCount <= 0 || arraySize <= threadsCount) {
            System.out.println("Wrong argument");
            System.exit(-1);
        }
        List<Thread> threadList = new ArrayList<>(threadsCount);
        arrayInt = randomArray(arraySize);
        for (int i = 0; i < arraySize; i++) {
            sum += (arrayInt[i]);
        }
        System.out.println("Sum: " + sum);
        int range;
        int mod = arraySize % threadsCount;
        int from;
        int to = 0;
        for (int j = 0; j < threadsCount; j++) {
            from = to;
            if (mod != 0) {
                range = (arraySize - (threadsCount - 1)) / (threadsCount - 1);
                if (range == 0)
                    range = 1;
                to = (j + 1) * (range);
                if (j == threadsCount - 1) {
                    to = (j + 1) * (arraySize / threadsCount + 1);
                }
            } else {
                to = (j + 1) * (arraySize / threadsCount);
            }
            threadList.add(new Thread(new SummatorThread(from, to)));
            threadList.get(j).start();
        }
        for (int j = 0; j < threadsCount; j++){
            threadList.get(j).join();
        }
        System.out.println("Sum by threads = " + finalSum);
    }

    public static int[] randomArray(int arraySize) {
        int[] aInt = new int[arraySize];
        int tmp;
        Random random = new Random();
        for (int i = 0; i < arraySize; i++) {
            tmp = random.nextInt() % 1000;
            if (tmp < 0) {
                tmp*=-1;
            }
            aInt[i] = tmp;
        }
        return aInt;
    }
}