package Test;

import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by YLL on 2015/6/22.
 */
//public class Test1 {
//    public static void main(String[] args){
       /* Scanner scan=new Scanner(System.in);
        System.out.println("请输入你要加密的字符串：");
        String st=scan.nextLine();
        char[] array=st.toCharArray();
        for(int i=0;i<array.length;i++){
            array[i]=(char)(array[i]^2000);
        }
        System.out.println("加密结果如下：");
        System.err.println(new String(array));*/

        /*Scanner scan=new Scanner(System.in);
        System.out.println("请输入一个数：");
        long num=scan.nextLong();
        String st=(num%2==0)?"这个数是偶数！":"这个数是奇数！";
        System.out.println(st);*/

        /*Scanner scan=new Scanner(System.in);
        System.out.println("请输入一个数：");
        long num=scan.nextLong();
        System.out.println("你输入的数是："+num);
        System.out.println("你输入的数乘以16得："+(num<<4));*/

        /*Sleeper sleeper1=new Sleeper("线程A sleeper1",1500);
        Sleeper sleeper2=new Sleeper("线程A sleeper2",1500);
        Joiner joiner=new Joiner("线程B",sleeper2);
        sleeper1.interrupt();*/

        /*Scanner scan=new Scanner(System.in);
        System.out.println("请输入你要判断的年份：");
        long year;
        try{
            year=scan.nextLong();
            if(year%4==0&&year%100!=0||year%400==0){
                System.out.println("你输入的"+year+"年是闰年！");
            }
            else{
                System.out.println("你输入的"+year+"年不是闰年！");
            }
        }catch (Exception e){
            System.out.println("你输入的不是有效年份！");
        }*/

        /*int yh[][]=new int[10][];
        System.out.println("以下就是十行杨辉三角形：");
        for(int i=0;i<yh.length;i++){
            yh[i]=new int[i+1];
            for(int j=0;j<i+1;j++){
                if(i==0||j==0||j==i){
                    yh[i][j]=1;
                }else{
                    yh[i][j]=yh[i-1][j]+yh[i-1][j-1];
                }
                System.out.print(yh[i][j]+" ");
            }
            System.out.println();
        }*/

        /*
        九九乘法表
         */
        /*System.out.println("以下是九九乘法表：");
        for(int i=1;i<10;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j + "*" + i + "=" + (i * j) + "\t");
            }
            System.out.println();
        }*/

        /*
        用bigdecimal计算阶乘
         */
        /*BigDecimal sum=new BigDecimal(0.0);
        BigDecimal fac=new BigDecimal(1.0);
        int i=1;
        while(i<=20){
            sum=sum.add(fac);
            i++;
            fac=fac.multiply(new BigDecimal(1.0/i));
        }
        System.out.println("阶乘为："+sum);*/

        /*
        打印菱形
         */
        /*Scanner scan=new Scanner(System.in);
        System.out.println("请输入菱形的大小：");
        int size=scan.nextInt();
        if(size%2==0){
            size++;
        }
        for(int i=0;i<size/2+1;i++){
            for(int j=size/2;j>i;j--){
                System.out.print(" ");
            }
            for(int j=0;j<2*i+1;j++){
                if(j==0||j==2*i){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for(int i=size/2+1;i<size;i++){
            for(int j=0;j<i-size/2;j++){
                System.out.print(" ");
            }
            for(int j=0;j<2*size-1-2*i;j++){
                if(j==0||j==2*(size-i-1)){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }*/

        /*
        数组排序(直接排序法、冒泡排序法)
         */
        /*Scanner scan=new Scanner(System.in);
        System.out.println("排序数组：");
        int[] array=new int[10];
        Random random=new Random();
        for(int i=0;i<array.length;i++){
            array[i]=random.nextInt(100);
            System.out.print(array[i]+"\t");
        }
        System.out.println();
        System.out.println("排序后的数组顺序：");
        for(int i=0;i<array.length-1;i++){
            int k=i;
            for(int j=i+1;j<array.length;j++){
                if(array[j]>array[k]){
                    k=j;
                }
            }
            int temp=array[k];
            array[k]=array[i];
            array[i]=temp;
        }
        for(int num:array){
            System.out.print(num+"\t");
        }
        //冒泡排序法
        System.out.println();
        System.out.println("冒泡排序法排序后的数组：");
        for(int i=0;i<array.length-1;i++){
            for(int j=0;j<array.length-i-1;j++){
                if(array[j]>array[j+1]){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
        for(int num:array){
            System.out.print(num+"\t");
        }*/

//        System.out.println("创建一个对象：");
//        Emperor e1=new Emperor.getInstance();
//        e1.getName();

//        HanoiTower h=new HanoiTower();
//        int n=3;
//        h.moveDish(n,'A','B','C');

//        Person p1=new Person();
//        Person p2=new Person("鄢淋珑","男",21);
//        System.out.println("姓名："+p1.getName());
//        System.out.println("性别："+p1.getSex());
//        System.out.println("年龄："+p1.getAge());
//        System.out.println("姓名："+p2.getName());
//        System.out.println("性别："+p2.getSex());
//        System.out.println("年龄："+p2.getAge());
//    }
//}

/*
构造方法的应用
 */
/*class Person{
    private String name;
    private String sex;
    private int age;

    public Person() {
        System.out.println("使用无参的构造方法！");
    }

    public Person(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        System.out.println("使用有参的构造方法！");
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }
}
        /*
        汉诺塔求解问题
        */
/*class HanoiTower{
            public void moveDish(int level,char from,char inter,char to){
                if(level==1){
                    System.out.println("从"+from+"移动盘子"+level+"到"+to);
                }
                else{
                    moveDish(level-1,from,to,inter);
                    System.out.println("从"+from+"移动盘子"+level+"到"+to);
                    moveDish(level-1,inter,from,to);
                }
            }
}

class Emperor{
    private static Emperor emperor=null;
    private Emperor(){}
    public static Emperor getInstance(){
        if(emperor==null){
            emperor=new Emperor();
        }return emperor;
    }
    public void getName(){
        System.out.println("我是鄢淋珑，住12栋644！");
    }
}

/*class Sleeper extends Thread{
    private int sleeptime;

    public Sleeper(String name,int sleeptime) {
        super(name);
        this.sleeptime = sleeptime;
        start();
    }
    public void run(){
        try{
            for(int i=0;i<5;i++){
                System.out.println(getName()+"打印"+i);
                sleep(sleeptime);
            }
        }catch (InterruptedException e){
            System.out.println(getName()+"interrupted");
        }
        System.out.println(getName()+"执行完毕！");
    }
}
class Joiner extends Thread{
    private Sleeper sleeper;
    public Joiner(String name,Sleeper sleeper){
        super(name);
        this.sleeper=sleeper;
        start();
    }
    public void run(){
        try{
            System.out.println(getName()+"开始执行！");
            System.out.println(sleeper.getName()+"开始使用join()方法");
            sleeper.join();
            for(int i=5;i>0;i--){
                System.out.println(getName()+"打印"+i);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(getName()+"执行完毕");
    }
}*/

/*
计算几何图形的面积
 */
/*
abstract class Shape{
    public String getName(){
        return this.getClass().getSimpleName();
    }
    public abstract double getArea();
}
class Circle extends Shape{
    private double radius;
    public Circle(double radius){
        this.radius=radius;
    }

    @Override
    public double getArea() {
        return Math.PI*Math.pow(radius,2);
    }
}
class Rectangle extends Shape{
    private double length;
    private double width;
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double getArea() {
        return length*width;
    }
}
public class Test1{
    public static void main(String[] args){
        Circle C1=new Circle(1);
        System.out.println("图形的名称是："+C1.getName());
        System.out.println("图形的面积是："+C1.getArea());
        Rectangle C2=new Rectangle(3,4);
        System.out.println("图形的名称是："+C2.getName());
        System.out.println("图形的面积是："+C2.getArea());
    }
}*/


/*
简单的汽车销售商场
 */
/*
abstract class Car{
    public abstract String getInfo();
}
class BMW extends Car{
    @Override
    public String getInfo() {
        return "BMW";
    }
}
class Benz extends Car{
    @Override
    public String getInfo() {
        return "Benz";
    }
}
class CarFactory{
    public static Car getCar(String name){
        if(name.equalsIgnoreCase("BMW")){
            return new BMW();
        }else if(name.equalsIgnoreCase("Benz")){
            return new Benz();
        }else{
            return null;
        }
    }
}
public class Test1{
    public static void main(String[] args){
        System.out.println("顾客要购买BMW：");
        Car bmw=CarFactory.getCar("BMW");
        System.out.println("提取汽车：" + bmw.getInfo());
        System.out.println("顾客要购买Benz：");
        Car benz=CarFactory.getCar("Benz");
        System.out.println("提取汽车："+benz.getInfo());
    }
}*/