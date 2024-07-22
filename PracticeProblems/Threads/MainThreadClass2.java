package PracticeProblems.Threads;

public class MainThreadClass2 {
    public static void main(String[] args) {
        ChildOfRunnableClass runnableClass = new ChildOfRunnableClass();
        Thread thread1 = new Thread(runnableClass, "Thread1");
        thread1.start();
        Thread thread2 = new Thread(runnableClass, "Thread2");
        thread2.start();
    }
}
