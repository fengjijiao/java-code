package test5;

public class test2 {
    private static int SYN = 0;
    public static void main(String[] args) {
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                if(SYN%3 == 0) {
                    System.out.println('A');
                    SYN++;
                }
            }
        });
        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    A.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(SYN%3 == 1) {
                    System.out.println('B');
                    SYN++;
                }
            }
        });
        Thread C = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    B.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(SYN%3 == 2) {
                    System.out.println('C');
                    SYN++;
                }
            }
        });
        A.start();
        B.start();
        C.start();
    }
}
