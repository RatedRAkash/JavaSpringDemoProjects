package MultiThread.ExecutorService;

import java.util.concurrent.*;

public class AdvanceExecutorService {
    public static void main(String[] args) {
        ExecutorService service = new ThreadPoolExecutor(
                10,
                100,
                120, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(300),
                new CustomRejectionHandler()
        );

        try {
            service.execute(new SimpleTask());
        } catch (RejectedExecutionException e){
            System.out.println("Task Rejected: " + e.getMessage());
        }
    }

    private static class CustomRejectionHandler implements RejectedExecutionHandler{

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("Task Rejected & Handled by Akash's Custom CallBack");
        }
    }
}
