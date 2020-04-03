public class MyClass {
    public static void main(String args[]) {
      int x=0x0f;
      int y=25;
      int z=x+y;
      byte a = (byte)x;
      System.out.println("int cover to byte = " + Integer.toBinaryString(a));
      int b = byteToInt(a);
      System.out.println("byte cover to int = " + Integer.toBinaryString(b));
       byte c = (byte)b;
      System.out.println("int cover to byte = " + Integer.toBinaryString(c));
    }
    public static int byteToInt(byte b) {
        return b&0xff;
    }
    //public static 
}
