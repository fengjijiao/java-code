public class MyClass {
    public static void main(String args[]) {
      /*
      *匿名类
      */
      P p1 = new P() {
          //匿名类中用代码块重写构造函数(因为匿名)
          {
              name = "王五";
              country = "cn";
          }
          @Override
          String getName() {
              return "张三";
          }
      };
      System.out.printf("p1的name:%s,country:%s,getName:%s\n ", p1.name, p1.country, p1.getName());
      /*
      *通常用法
      */
      P p2 = new P("李四", "uk");
      System.out.printf("p2的name:%s,country:%s,getName:%s\n ", p2.name, p2.country, p2.getName());
      
    }
    
    static class P {
        String name;
        String country;
        P() {
            //
        }
        P(String name, String country) {
            this.name = name;
            this.country = country;
        }
        String getName(){
            if(name != null && ! name.equals("")) {
                return name;
            }
            return "默认名字";
        }
    }
}
