package Test;

/**
 * Created by YLL on 2015/6/18.
 */
public abstract class Employee {
    private String name;
    private String number;
    private MyDate birthday;
    public abstract double earnings();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    public Employee(String number, MyDate birthday, String name) {
        super();
        this.number = number;
        this.birthday = birthday;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", birthday=" + birthday.toDateString() +
                '}';
    }
}
class SalariedEmployee extends Employee{
    private double monthlySalary;//月工资

    public SalariedEmployee(String number, MyDate birthday, String name, double monthlySalary) {
        super(number, birthday, name);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double earnings() {
        return monthlySalary;
    }

    @Override
    public String toString() {
        return "SalariedEmployee["+super.toString()+"monthlySalary="+monthlySalary+"]";
    }
}
class HourlyEmployee extends SalariedEmployee {
    private double wage;
    private double hour;

    public double earnings() {
        return wage * hour;
    }

    public HourlyEmployee(String number, MyDate birthday, String name, double monthlySalary, double hour, double wage) {
        super(number, birthday, name, monthlySalary);
        this.hour = hour;
        this.wage = wage;
    }

    @Override
    public String toString() {
        return "HourlyEmployee{"+super.toString() +
                "wage=" + wage +
                ", hour=" + hour +
                '}';
    }
}
