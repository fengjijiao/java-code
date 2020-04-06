public class MyClass {
    public static void main(String args[]) {
        STemplate st1 = new STemplate(){
            void code() {
                for(int i=0;i<1000;i++)
                    for(int j=0;j<1000;j++)
                        for(int k=0;k<1000;k++);
            }
        };
      System.out.println("Time consuming: " + st1.getTime() + "ms");
    }
}
abstract class STemplate {
    final long getTime() {
        long oldTime = System.currentTimeMillis();
        code();
        long newTime = System.currentTimeMillis();
        return newTime - oldTime;
    }
    abstract void code();
}
