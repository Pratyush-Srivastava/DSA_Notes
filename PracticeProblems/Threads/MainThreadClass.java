package PracticeProblems.Threads;

public class MainThreadClass {
    public static void main(String[] args) {
        System.out.println("Current thread starts = " + Thread.currentThread().getName());

        ChildOfThreadClass thread1 = new ChildOfThreadClass("Thread1");
        System.out.println(thread1.getName() + " thread state from main =  " + thread1.getState());
        thread1.start();
        System.out.println(thread1.getName() + " thread state from main =  " + thread1.getState());

        ChildOfThreadClass thread2 = new ChildOfThreadClass("Thread2");
        thread2.start();

        try {
            System.out.println(thread1.getName() + " thread state from main =  " + thread1.getState());
            thread1.join();
            System.out.println(thread1.getName() + " thread state from main =  " + thread1.getState());
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Exception thrown while joining " + e);
        }

        System.out.println("Current thread ends = " + Thread.currentThread().getName());
    }
}
