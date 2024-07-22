package PracticeProblems.Threads;

public class ChildOfRunnableClass implements Runnable {
    private static final Integer WAITING_TIME = 4;
    private static int counter = 1;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " waiting starts for " + WAITING_TIME + " seconds");
        synchronized (WAITING_TIME) {
            for (int i = 1; i <= WAITING_TIME; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Exception thrown " + e);
                }
                System.out.println(Thread.currentThread().getName() + " waiting for " + i + " seconds... counter " + (counter++));
            }
        }
        System.out.println(Thread.currentThread().getName() + " waiting ends for " + WAITING_TIME + " seconds");
    }
}
