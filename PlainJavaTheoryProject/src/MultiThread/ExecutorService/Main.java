package MultiThread.ExecutorService;


public class Main {
    public static void main(String[] args) {
        /*As you've read, availableProcessors() is a method that returns the number of processors available to the JVM. 4 means the number of processors currently available for JVM.
        These lines return the number of logical cores on Windows and in other operating systems.
        On a computer with a quad-core Core i7 supporting Hyper-Threading, it will return 8.
        On a computer with a quad-core Q6700, this method will return 4.*/

        System.out.println("Number of CPU Cores available: " + Runtime.getRuntime().availableProcessors()); //In this context, a "processor" is "hardware capable of independent execution", ie a cpu core.
    }
}