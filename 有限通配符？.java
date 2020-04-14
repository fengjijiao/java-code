package test;

import java.util.ArrayList;
import java.util.List;

/*有限通配符?
 */
public class test14 {
    public static void main(String[] args) {
        OP op = new OP();
        //List<?> list
        List<AC> ac = new ArrayList<AC>();
        op.addR(ac);
        List<BC> bc = new ArrayList<BC>();
        op.addR(bc);
        List<CC> cc = new ArrayList<CC>();
        op.addR(cc);
        List<DC> dc = new ArrayList<DC>();
        op.addR(dc);
        List<EC> ec = new ArrayList<EC>();
        op.addR(ec);
        //List<? extends AC> list
        List<AC> ac1 = new ArrayList<AC>();
        //op.addR1(ac1);//报错
        List<BC> bc1 = new ArrayList<BC>();
        //op.addR1(bc1);//报错
        List<CC> cc1 = new ArrayList<CC>();
        op.addR1(cc1);
        List<DC> dc1 = new ArrayList<DC>();
        op.addR1(dc1);
        List<EC> ec1 = new ArrayList<EC>();
        op.addR1(ec1);
        //List<? super AC> list
        List<AC> ac2 = new ArrayList<AC>();
        op.addR2(ac2);
        List<BC> bc2 = new ArrayList<BC>();
        op.addR2(bc2);
        List<CC> cc2 = new ArrayList<CC>();
        op.addR2(cc2);
        List<DC> dc2 = new ArrayList<DC>();
        //op.addR2(dc2);//报错
        List<EC> ec2 = new ArrayList<EC>();
        //op.addR2(ec2);//报错
        BI bi = new BI();
        System.out.println(bi.a);
        List<BI> bi1 = new ArrayList<BI>();
        op.addR3(bi1);
    }
}
class OP {
    public void addR(List<?> list) {//都允许
    }
    public void addR1(List<? extends CC> list) {//只允许泛型为CC及子类的调用(CC,DC,EC)
    }
    public void addR2(List<? super CC> list) {//只允许泛型为CC及父类的调用(AC,BC,CC)
    }
    public void addR3(List<? extends Compl> list) {//只允许泛型为Compl接口的实现类的调用
    }
}
class AC {
    int a = 0;
}
class BC extends AC {
}
class CC extends BC {
}
class DC extends CC {
}
class EC extends DC {
}
interface Compl {
    int a = 0;
    void Run();
    void Init();
    void Stop();
    void Close();
}
class BI implements Compl {
    int a = 2;
    public void Run() {
        System.out.println("开始运行咯！");
    }
    public void Init() {
        System.out.println("初始化完成咯！");
    }
    public void Stop() {
        System.out.println("已经停止咯！");
    }
    public void Close() {
        System.out.println("已经关闭咯！");
    }
}
