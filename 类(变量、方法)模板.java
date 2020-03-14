/*
一个源文件仅能有一个public 类
 */
public class Dog {
    public int age;//成员变量，可被类中的方法、构造方法以及特定类的语句块访问
    public static String name="door";//类变量,属于整个类，可通过对象名或类名来调用
    public Dog(String name, int age) {
        //这个构造器仅有一个参数：name
        this.name = name;
        this.age = age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public static void main(String[] args) {
        // 下面的语句将创建一个Puppy对象
        Dog myDog = new Dog( "tommy", 9 );
        System.out.println("默认名称："+Dog.name + ";第一只小狗的名字是 : " + myDog.name + ",年龄是：" + myDog.age + "岁" );
        myDog.setAge(10);
        myDog.setName("alyssa");
        System.out.println("默认名称："+Dog.name + ";第一只小狗的名字是 : " + myDog.name + ",年龄是：" + myDog.age + "岁" );
        Dog myDog2 = new Dog( "root", 8 );
        System.out.println("默认名称："+Dog.name + ";第二只小狗的名字是 : " + myDog2.name + ",年龄是：" + myDog2.age + "岁" );
        System.out.println("默认名称："+Dog.name + ";第一只小狗的名字是 : " + myDog.name + ",年龄是：" + myDog.age + "岁" );//由于在myDog2中修改了类变量name，使得整个类的name全都被修改（类变量是全部继承实例公用的数据），进而导致其他Dog的名称全部改变
    }
}
/*output
默认名称：tommy;第一只小狗的名字是 : tommy,年龄是：9岁
默认名称：alyssa;第一只小狗的名字是 : alyssa,年龄是：10岁
默认名称：root;第二只小狗的名字是 : root,年龄是：8岁
默认名称：root;第一只小狗的名字是 : root,年龄是：10岁
*/
/*
成员变量和类变量的区别：

 1、两个变量的生命周期不同

      成员变量随着对象的创建而存在，随着对象的回收而释放。

      静态变量随着类的加载而存在，随着类的消失而消失。

   2、调用方式不同

      成员变量只能被对象调用。

      静态变量可以被对象调用，还可以被类名调用。

   3、别名不同

      成员变量也称为实例变量。

      静态变量也称为类变量。

   4、数据存储位置不同

      成员变量存储在堆内存的对象中，所以也叫对象的特有数据。

      静态变量数据存储在方法区（共享数据区）的静态区，所以也叫对象的共享数据。
*/