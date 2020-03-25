import java.util.Arrays;
public class Test{
  public static void main(String args[]){
    double[] myList = {1.9, 2.9, 3.4, 3.5, 3.8, 3.9, 4.22};
    double[] myList2 = {1.9, 3.4, 2.9, 3.5, 3.8, 3.9, 4.22};
    int a = Arrays.binarySearch(myList,3.5);//二分查找，需已排序数组
    System.out.println(a);
    System.out.println(Arrays.equals(myList,myList2));//判断两数组是否相等，必须完全一样的数组（排序和数值）
    Arrays.fill(myList2,1.0);//将整个数组用某数填充
    System.out.printf("%f,%f\n",myList2[0],myList2[3]);
    Arrays.sort(myList);//将整个数组升序排序
    System.out.printf("%f,%f\n",myList[0],myList[3]);
  }
}
/*
3
false
1.000000,1.000000
1.900000,3.500000
 */