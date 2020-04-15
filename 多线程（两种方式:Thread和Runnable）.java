package test2;

public class test10 {
    public static void main(String[] args) {
        //通过继承Thread类实现多线程
        Thread thread = new TestThread();
        thread.start();
        //通过实现Runnable接口实现多线程
        Thread thread1 = new Thread(new TestRunnable(), "t-1");//第二参数为线程名
        thread1.start();
    }
}
class TestThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread多线程开始运行");
        for(int i=0;i<10;i++) {
            System.out.println("Thread这是多线程测试" + i);
        }
    }
}
class TestRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":Runnable多线程开始运行");
        for(int i=0;i<10;i++) {
            System.out.println(Thread.currentThread().getName() + ":Runnable这是多线程测试" + i);
        }
    }
}
