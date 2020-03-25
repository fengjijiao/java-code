public class Test{
  public static void main(String args[]){
    StringBuffer sBuffer = new StringBuffer("哈哈哈哈哈：");
    sBuffer.append("sssssss");
    sBuffer.append(".dddgggggg");
    sBuffer.append(".ddddddm");
    System.out.println(sBuffer);  
    System.out.println(sBuffer.reverse());//将sBuffer用其反转形式取代 
    System.out.println(sBuffer); 
    System.out.println(sBuffer.delete(2,3));  
    System.out.println(sBuffer);  
    System.out.println(sBuffer.insert(3,"s97"));  
    System.out.println(sBuffer);  
    System.out.println(sBuffer.replace(3,9,"666666"));  
    System.out.println(sBuffer);  
  }
}
/*
哈哈哈哈哈：sssssss.dddgggggg.ddddddm
mdddddd.ggggggddd.sssssss：哈哈哈哈哈
mdddddd.ggggggddd.sssssss：哈哈哈哈哈
mddddd.ggggggddd.sssssss：哈哈哈哈哈
mddddd.ggggggddd.sssssss：哈哈哈哈哈
mdds97ddd.ggggggddd.sssssss：哈哈哈哈哈
mdds97ddd.ggggggddd.sssssss：哈哈哈哈哈
mdd666666.ggggggddd.sssssss：哈哈哈哈哈
mdd666666.ggggggddd.sssssss：哈哈哈哈哈
 */