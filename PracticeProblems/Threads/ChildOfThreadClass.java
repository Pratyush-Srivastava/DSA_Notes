package PracticeProblems.Threads;

public class ChildOfThreadClass extends Thread {

    private static final int WAITING_TIME = 4;
    public ChildOfThreadClass(String name) {
        this.setName(name);
    }
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " thread state =  " + Thread.currentThread().getState());
            System.out.println("Thread name = " + Thread.currentThread().getName() + " waiting starts for " + WAITING_TIME + " seconds");

            for (int i = 1; i <= WAITING_TIME; i++) {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " wating for " + i + " seconds...");
            }

            System.out.println("Thread name = " + Thread.currentThread().getName() + " waiting ends for " + WAITING_TIME + " seconds");
            System.out.println(Thread.currentThread().getName() + " thread state =  " + Thread.currentThread().getState());

        } catch (InterruptedException e) {
            System.out.println("Exception thrown " + e);
        }
    }
}
