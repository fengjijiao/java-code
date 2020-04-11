package test;

public class test12 {
    public static void main(String[] args) {
        CP<String> cp1 = new CP<String>() {
            @Override
            public boolean isMoreThen(String t1, String t2) {
                if(t1.hashCode() > t2.hashCode()) {
                    return true;
                }
                return false;
            }
        };
        System.out.println(cp1.isMoreThen("c", "a"));
        /*
        true
         */
        CP<Integer> cp2 = new CP<Integer>() {
            @Override
            public boolean isMoreThen(Integer t1, Integer t2) {
                if(t1 > t2) {
                    return true;
                }
                return false;
            }
        };
        System.out.println(cp2.isMoreThen(232, 555));
        /*
        false
         */
        CPH cph = new CPH();
        cph.isMoreThen(35.76f, 76.44f);
        /*
        false
         */
    }
}
class CPH implements CP<Float> {
    @Override
    public boolean isMoreThen(Float t1, Float t2) {
        if(t1 > t2) {
            return true;
        }
        return false;
    }
}
interface CP<T> {
    boolean isMoreThen(T t1, T t2);
}
