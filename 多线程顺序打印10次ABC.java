package test5;

public class test2 {
    private static int SYN = 0;
    public static void main(String[] args) {
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                do {
                    if (SYN % 3 == 0) {
                        System.out.println('A');
                        SYN++;
                    }
                } while (SYN < 30);
            }
        });
        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                do {
                    if (SYN % 3 == 1) {
                        System.out.println('B');
                        SYN++;
                    }
                } while (SYN < 30);
            }
        });
        Thread C = new Thread(new Runnable() {
            @Override
            public void run() {
                do {
                    if (SYN % 3 == 2) {
                        System.out.println('C');
                        SYN++;
                    }
                } while (SYN < 30);
            }
        });
        A.start();
        B.start();
        C.start();
    }
}
