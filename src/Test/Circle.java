package Test;

/**
 * Created by YLL on 2015/6/11.
 */
/*public class Circle extends GeometricObject{
    private double radius;
    public Circle(){
        this.radius=1.0;
    }
    public Circle(double radius){
        this.radius=radius;
    }
    public Circle(double radius,String color,double weight){
        super(color, weight);
        this.radius=radius;
    }
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double findArea(){
        return 3.14*radius*radius;
    }
    public boolean equals(Object obj){
        if(obj==this)
            return true;
        else if(obj instanceof Circle){
            Circle c1=(Circle)obj;
            return this.radius==c1.radius;
        }else{
            return false;
        }
    }
    public String toString(){
        return radius+"";
    }
}*/
//public class Circle{
//    public static void main(String[] args){
//        ComparableCircle c1=new ComparableCircle(2.1);
//        ComparableCircle c2=new ComparableCircle(2.3);
//        ComparableCircle c3=new ComparableCircle(2.1);
//        int i1=c1.compareTo(c3);
//        int i2=c2.compareTo(c3);
//        System.out.println(i1);
//        System.out.println(i2);
//    }
//}
//class Circle1{
//    private double r;
//
//    public double getR() {
//        return r;
//    }
//
//    public void setR(double r) {
//        this.r = r;
//    }
//
//    public Circle1(double r) {
//        super();
//        this.r = r;
//    }
//
//    public Circle1() {
//    }
//}
//class ComparableCircle extends Circle1 implements CompareObject{
//    public ComparableCircle(double r){
//        super(r);
//    }
//    @Override
//    public int compareTo(Object o) {
//        if(this==o)
//            return 0;
//        else if(o instanceof ComparableCircle){
//            ComparableCircle c=(ComparableCircle)o;
//            if(this.getR()>c.getR()){
//                return 1;
//            }else if(this.getR()<c.getR()){
//                return -1;
//            }else{
//                return 0;
//            }
//        }else{
//            return -2;
//        }
//    }
//}
//interface CompareObject{
//    public int compareTo(Object o);
//}

