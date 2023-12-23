package MultiThread;

public class CustomThread extends Thread {
    private String threadName;

    public CustomThread(String threadName) {
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
