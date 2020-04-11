package test;

public class test11 {
    public static void main(String[] args) {
        /*
        默认为Obeject
         */
        Q q = new Q();
        q.setVal(199999999999999l);
        System.out.println(q.getVal());
        /*
        199999999999999
         */
        Q<String> q1 = new Q();
        q1.setVal("WQ");
        System.out.println(q1.getVal());
        /*
        WQ
         */
        Q<Float> q2 = new Q();
        q2.setVal(28.07f);
        System.out.println(q2.getVal());
        /*
        28.07
         */
    }
}
class Q<T> {
    T t;
    T getVal() {
        return t;
    }
    void setVal(T t) {
        this.t = t;
    }
}
