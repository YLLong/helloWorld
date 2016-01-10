package Test;

import org.testng.annotations.Test;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by YLL on 2015/9/17.
 */
public class TestAlgorithm {
    public static void main(String[] args){

    }
    @Test
    public void test1() {
        int N = 10;
        int i;
        int f = -1;
        int[] arr = new int[N];
        System.out.println("下面是随机生成的10个数字：");
        Random s= new Random();
        for(i=0; i<N; i++) {
            arr[i] = s.nextInt(100);
            System.out.print(arr[i] +" ");
        }
        for(i=0; i<N; i++) {
            System.out.print(arr[i] +" ");
        }
        System.out.println();
        System.out.print("请输入你要找的数字：");
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        for(i=0; i<N; i++) {
            if(x==arr[i]) {
                f = i;
                break;
            }
        }
        if(f < 0) {
            System.out.println("木有找到数据！");
        }
        else {
            System.out.println("你要找的数:" + x + "在数列的第" + (f+1) + "个");
        }
        input.close();
    }
}
