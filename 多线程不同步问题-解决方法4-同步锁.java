package test2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class test11 {
    public static void main(String[] args) {
        Account account = new Account();
        User user = new User(account, 3000);
        Thread thread = new Thread(user, "客户端1");
        User user1 = new User(account, 4000);
        Thread thread1 = new Thread(user1, "客户端2");
        thread.start();
        thread1.start();
        /*
        *客户端1已消费:3000
        *客户端1余额:2000
         *客户端2余额不足！
        */
    }
}
class User implements Runnable {
    static Thread thread;
    Account account;
    int m;
    User(Account account, int m) {
        this.account = account;
        this.m = m;
    }
    @Override
    public void run() {
        account.consume(Thread.currentThread().getName(), m);
    }
}
class Account {
    private Lock lock = new ReentrantLock();//true表示公平锁，false非公平锁
    static int money = 5000;//注意这里必须是类变量
    void consume(String name, int m) {
        lock.lock();//如果有其它线程已经获取锁，那么当前线程在此等待直到其它线程释放锁。
        try {
            if (money - m < 0) {
                System.out.println(name + "余额不足！");
                return;
            }
            System.out.println(name + "已消费:" + m);
            money -= m;
            System.out.println(name + "余额:" + money);
        }finally {
            lock.unlock();//释放锁资源，之所以加入try{}finally{}代码块，
            //是为了保证锁资源的释放，如果代码发生异常也可以保证锁资源的释放，
            //否则其它线程无法拿到锁资源执行业务逻辑，永远处于等待状态。
        }
    }
}
