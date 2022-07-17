public class SummatorThread implements Runnable {

    private int partOfSum;

    private int from;

    private int to;

    private int id;

    private static int count;

    public SummatorThread(int from, int to) {
        this.from = from;
        if (to > Program.arraySize) {
            this.to = Program.arraySize;
        } else {
            this.to = to;
        }
        this.partOfSum = 0;
        this.id = count;
        count++;
    }

    @Override
    public void run() {
        for (int i = from; i < to; i++) {
            partOfSum += Program.arrayInt[i];
        }
        synchronized (Program.class) {
            Program.finalSum += partOfSum;
        }
        System.out.printf("Thread %d: from %d to %d is %d\n", id, from, to - 1, partOfSum);
    }
}
