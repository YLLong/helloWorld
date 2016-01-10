package Test;

/**
 * Created by YLL on 2015/6/13.
 */
/*public class TestScore {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        System.out.println("请输入学生的成绩（以负数结束输入）：");
        Vector v=new Vector();
        int maxScore=0;
        for(;;){
            int score=s.nextInt();
            if(score<0)
                break;
            if(maxScore<score)
                maxScore=score;
            Integer score1=new Integer(score);
            v.addElement(score1);
        }
        for(int i=0;i<v.size();i++){
            Integer score=(Integer)v.elementAt(i);
            char level;
            if(maxScore-score<=10){
                level='A';
            }else if(maxScore-score<=20){
                level='B';
            }else if(maxScore-score<=30){
                level='C';
            }else{
                level='D';
            }
            System.out.println("学生成绩为："+score+",等级为："+level);
        }
        System.out.println("最高分为："+maxScore);
    }
}*/

/*public class TestScore implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("TestScore 线程在运行！");
        }
    }
    public static void main(String[] args){
        TestScore demo=new TestScore();
        new Thread(demo).start();
        for(int i=0;i<10;i++){
            System.out.println("main 线程在运行！");
        }
    }
}*/

public class TestScore{
    public static void main(String[] args){
   //     Manager m=new Manager();
     //   m.work();
       // Employee e=new CommonEmployee();
        //e.work();
        new SubTemplate().spendTime();
    }
}
/*abstract class Employee{
    private String name;
    private int id;
    private double salary;
    public  abstract void work();
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
class Manager extends Employee{
    private double bonus;
    public void work(){
        System.out.println("监督员工工作！");
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
class CommonEmployee extends Employee{
    public void work(){
        System.out.println("在流水线上工作！");
    }
}*/
abstract class Template{
    abstract void code();
    public void spendTime(){
        long start=System.currentTimeMillis();
        this.code();
        long end=System.currentTimeMillis();
        System.out.println("话费时间为："+(end-start));
    }
}
class SubTemplate extends Template{
    public void code(){
        boolean flag=false;
        for(int i=2;i<10000;i++){
            for(int j=2;j<=Math.sqrt(i);j++){
                if(i%j==0){
                    flag=true;
                    break;
                }
            }
            if(!flag){
                System.out.println(i);
            }
            flag=false;
        }
    }
}