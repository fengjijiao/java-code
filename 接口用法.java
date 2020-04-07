public class MyClass {
    /*
    *测试
    */
    public static void main(String args[]) {
      ST st1 = new ST();
      st1.play();
      st1.pause();
      st1.skip();
      st1.cook();
    }
}
/*
*实现类(既是歌手也是厨师)
*/
class ST implements Singer, Chef {
    int music_num = 0;
    public void play() {
        System.out.println("play " + music[music_num]);
    }
    public void pause() {
        System.out.println("pause " + music[music_num]);
    }
    public void skip() {
        System.out.println("skip " + music[music_num]);
        music_num = (music_num + 1) % music.length;
        play();
    }
    public void cook() {
        System.out.println("cook " + count);
    }
}
//接口中的变量均为常量(final),方法为抽象方法
/*
*歌手接口
*/
interface Singer {
    String[] music = {"sot?", "tom", "gray"};
    public void play();
    public void pause();
    public void skip();
}
/*
*厨师接口
*/
interface Chef {
    int count = 3;
    public void cook();
}
