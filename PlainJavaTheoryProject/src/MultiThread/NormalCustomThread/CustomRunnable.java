package MultiThread.NormalCustomThread;

public class CustomRunnable implements Runnable{

    private String threadName;
    public CustomRunnable(String threadName) {
        this.threadName = threadName;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 6; i++) {
            System.out.println("Thread Name: " + threadName + "---> count: " + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                //
            }
        }
    }
}
