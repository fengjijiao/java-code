package test;
//枚举类
public class test15 {
    public static void main(String[] args) {
        Season ss = Season.SPRING;
        ss.showInfo();
        Season ss1 = Season.SUMMER;
        ss1.showInfo();
        Season ss2 = Season.AUTUMN;
        ss2.showInfo();
        Season ss3 = Season.WINTER;
        ss3.showInfo();
        //用以检验是否为单例,故重建一次
        Season ss4 = Season.SPRING;
        ss4.showInfo();
        Season ss5 = Season.SUMMER;
        ss5.showInfo();
        Season ss6 = Season.AUTUMN;
        ss6.showInfo();
        Season ss7 = Season.WINTER;
        ss7.showInfo();
        /*
        春天，春暖花开
        夏天，烈日炎炎
        秋天，秋高气爽
        冬天，白雪皑皑
        春天，春暖花开
        夏天，烈日炎炎
        秋天，秋高气爽
        冬天，白雪皑皑
         */
        System.out.println(isEqual(ss, ss4));
        System.out.println(isEqual(ss1, ss5));
        System.out.println(isEqual(ss2, ss6));
        System.out.println(isEqual(ss3, ss7));
        /*
        true
        true
        true
        true
         */
    }
    public static boolean isEqual(Season ss1, Season ss2) {
        return ss1.getTimestamp() == ss2.getTimestamp();
    }
}
enum Season {
    //下4个为单例模式
    SPRING("春天", "春暖花开", System.currentTimeMillis()),
    SUMMER("夏天", "烈日炎炎", System.currentTimeMillis()),
    AUTUMN("秋天", "秋高气爽", System.currentTimeMillis()),
    WINTER("冬天", "白雪皑皑", System.currentTimeMillis());
    String name;
    String desc;
    long timestamp;
    Season(String name, String desc, long timestamp) {
        this.name = name;
        this.desc = desc;
        this.timestamp = timestamp;
    }
    void showInfo() {
        System.out.println(name + "，" + desc);
    }
    long getTimestamp() {
        return timestamp;
    }
}
