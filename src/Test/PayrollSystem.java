package Test;

import java.util.Scanner;

/**
 * Created by YLL on 2015/6/18.
 */
public class PayrollSystem {
    public static void main(String[] args){
        Employee[] ems=new Employee[2];
        ems[0]=new SalariedEmployee("1001",new MyDate(1998,12,18),"李磊",8000);
       // ems[0]=new SalariedEmployee("1002",new MyDate(1994,1,18),"晓玲",8800);
        ems[1]=new HourlyEmployee("1002",new MyDate(1994,12,18),"小丽",10000,2,100);
        Scanner s=new Scanner(System.in);
        System.out.print("请输入本月月份：");
        int month=s.nextInt();
        for(int i=0;i<ems.length;i++){
            if(month==ems[i].getBirthday().getMonth()){
                System.out.println("加工资，加100!");
            }
            System.out.println(ems[i]);
        }
    }
}
