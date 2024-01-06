package MultiThread.ExecutorService;

public class SimpleTask implements Runnable{
    @Override
    public void run() {
        System.out.println("I am simple Task, Running in Thread: " + Thread.currentThread().getName());
    }
}
