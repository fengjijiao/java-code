/*抽象方法是一种没有任何实现的方法，该方法的的具体实现由子类提供。*/
public abstract class SuperClass{
    abstract void m(); //抽象方法
}
 
class SubClass extends SuperClass{
     //实现抽象方法
      void m(){
          .........
      }
}