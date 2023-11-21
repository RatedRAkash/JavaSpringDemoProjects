import Generics.CustomPrinter;
import Generics.Dog;
import Generics.Lion;
import MultiThread.CustomRunnable;
import MultiThread.CustomThread;

public class Main {
    public static void main(String[] args) {
        CustomPrinter<Dog> d = new CustomPrinter<>(new Dog());
        CustomPrinter<Lion> l = new CustomPrinter<>(new Lion());

        d.printStatement();
        l.printStatement();

        CustomThread thread1 = new CustomThread("Thread1");
        CustomThread thread2 = new CustomThread("Thread2");

//        thread1.run() ---> eita dile Main Thread ei Run korbe... NEW Thread ee Run korte hobe amader thread.start() method use kora lagbe
        thread1.start();
        thread2.start();

//        CustomRunnable --> ei CLASS er Object ke PASS korbo Thread Class er Object Create er somoy
        CustomRunnable runnableThing = new CustomRunnable("Runnable Thread");
        Thread myRunnableThread = new Thread(runnableThing);
        myRunnableThread.start();

        try {
        // .JOIN() call dile jotokkon Nah ei Thread er kaaj Sesh hobe... nicher Code arr EXECEUTE hobe Nah
        // Orthat ei Thread er kaaj COMPLETE Nah howa porjonto Rest of the Threads will Not Start
        // eita MultiThreading er Concept ke jodio Nosto kore
        // JavaScript AWAIT Keyword er moto
            myRunnableThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}