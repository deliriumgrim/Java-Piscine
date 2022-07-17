public class PrintMessage implements Runnable {

    private String string;

    public PrintMessage(String string) {
        this.string = string;
    }
    @Override
    public void run() {
        synchronized (Program.class) {
            while (Program.input > 0) {
                System.out.println(string);
                Program.input--;
                Program.class.notify();
                try {
                    Program.class.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            Program.class.notify();
        }
    }
}