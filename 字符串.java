//https://www.runoob.com/manual/jdk1.6/java/lang/String.html
public class StringDemo{
   public static void main(String args[]){
   	//创建字符串
   	  String greeting = "hello";
   	  //或者
      char[] helloArray = { 'r', 'u', 'n', 'o', 'o', 'b'};
      String helloString = new String(helloArray);  
      System.out.println( helloString );
    //连接字符串
      String a = greeting.concat(helloString);
      //或者
      String a = greeting+helloString;
    //创建格式化字符串
    /*
    我们知道输出格式化数字可以使用 printf() 和 format() 方法。
    String 类使用静态方法 format() 返回一个String 对象而不是 PrintStream 对象。
    String 类的静态方法 format() 能用来创建可复用的格式化字符串，而不仅仅是用于一次打印输出。
     */
    String fs;
    fs = String.format("浮点型变量的值为 " +
                       "%f, 整型变量的值为 " +
                       " %d, 字符串变量的值为 " +
                       " %s", floatVar, intVar, stringVar);

   }
}