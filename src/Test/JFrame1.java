package Test;

import javax.accessibility.AccessibleContext;
import javax.swing.*;
import java.awt.*;

/**
 * Created by YLL on 2015/7/22.
 */
public class JFrame1 extends JFrame{
    public void CreateJFrame(String title){
        JFrame jf=new JFrame(title);    //实例化一个JFrame对象
        Container container=jf.getContentPane();    //获取一个容器
        jf.setTitle("向JFrame窗口添加标签");
        JLabel label=new JLabel("明日图书培养明日英才！",JLabel.CENTER);
        label.setIcon(new ImageIcon("F:\\C盘移动\\Desktop\\1.JPG"));
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
//        label.setEnabled(false);
        label.setDisabledIcon(new ImageIcon("F:\\C盘移动\\Desktop\\2.JPG"));
        container.add(label);
//        JLabel jl=new JLabel("这是一个JFrame窗口！");  //创建一个JLabel标签
//        jl.setHorizontalAlignment(SwingConstants.CENTER);   //标签文字居中
//        container.add(jl);  //讲标签添加到容器
        container.setBackground(Color.white);   //设置背景颜色为白色
        jf.setVisible(true);    //使窗体可见
        jf.setSize(700,500);    //设置窗体大小
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);     //设置关闭方式
    }
    public static void main(String args[]){
        new JFrame1().CreateJFrame("创建一个JFrame窗体");
    }
}