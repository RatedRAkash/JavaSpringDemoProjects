package MultiThread.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DemoExecutorService {
    public static void main(String[] args) {
        int coreCount = Runtime.getRuntime().availableProcessors();
//        ExecutorService service = Executors.newFixedThreadPool(11); // Number of Threads 11 dilam, so 11 ta Thread Create hobe
        ExecutorService service = Executors.newFixedThreadPool(coreCount); // Number of Core er soman Thread Creae korlam
        for (int i = 0; i < 100; i++) {
            service.execute(new SimpleTask());
        }
        System.out.println("Current Thread Name: " + Thread.currentThread().getName());
    }
}
