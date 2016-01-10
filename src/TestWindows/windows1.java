package TestWindows;

import org.testng.annotations.Test;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created by YLL on 2015/8/1.
 */
public class windows1 {
    public static void main(String args[]){
        windows1 w1=new windows1();
//        w1.ButtonFrame();
//        w1.RadioButtonDemoFrame();
 //       w1.CheckBoxFrame();
 //       w1.JTextFieldFrame();
//        w1.JListDemoFrame();
        w1.CreateJFrame();
    }

    public void CreateJFrame() {
        JFrame jf = new JFrame("这是一个什么。。");
        JLabel jl = new JLabel("sm这是一个什么东西");
        jf.add(jl);
        jl.setHorizontalAlignment(SwingConstants.CENTER);
        jf.setSize(200, 200);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void ButtonFrame(){
        JFrame win1=new JFrame("第一个新窗口");       //窗口的题目
        win1.setDefaultCloseOperation(win1.EXIT_ON_CLOSE) ;        //窗口的关闭方式（结束窗口所在的应用程序、在窗口被关闭的时候会退出JVM）
        win1.setBounds(100,100,384,160);        //运行出来的窗口是以左上角在电脑的（100，100）处以长384，宽160显示
        JPanel ContentPane=new JPanel();        //定义面板容器
        ContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));        //设置边框，边框顶部5 底部5 左右各5
        win1.setContentPane(ContentPane);       //将面板添到窗体
        ContentPane.setLayout(null);        //设置面板为绝对布置（即后面的以改面板为参照）
        JPanel panel=new JPanel();         //定义一个面板容器
        panel.setBounds(0, 0, 368, 122);        //设置长宽
        ContentPane.add(panel);        //将容器加入到面板容器
        panel.setLayout(null);         //定义改容器为绝对布置
        JButton messageButton=new JButton("普通按键");      //按钮显示
        messageButton.setBounds(54,33,108,46);         //按钮显示位置
        panel.add(messageButton);          //将按钮加到容器内
        java.net.URL url=getClass().getResource("2.jpg");       //定义图片对象的地址
        ImageIcon icon=new ImageIcon(url);        //定义图片对象
        JButton imageButton=new JButton(icon);        //定义显示图片的按钮对象
        imageButton.setBounds(194,14,108,85);        //位置及大小
        panel.add(imageButton);         //就按钮显示在面板中
        win1.setVisible(true);      //窗体可视
    }
    public void RadioButtonDemoFrame(){
        JFrame JB=new JFrame("单选按钮窗体");
        JB.setDefaultCloseOperation(JB.EXIT_ON_CLOSE);
        JB.setBounds(100,300,271,161);
        JB.setVisible(true);
        JPanel contentPane=new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        JB.setContentPane(contentPane);
        contentPane.setLayout(null);
        JPanel JP1=new JPanel();
        JP1.setBounds(0,0,259,123);
        contentPane.add(JP1);
        JP1.setLayout(null);
        JRadioButton JRB1=new JRadioButton("旅游");
        JRB1.setBounds(45,29,73,23);
        JP1.add(JRB1);
        JRadioButton JRB2=new JRadioButton("看书");
        JRB2.setBounds(134,29,121,23);
        JP1.add(JRB2);
        JRadioButton JRB3=new JRadioButton("上网");
        JRB3.setBounds(45,74,73,23);
        JP1.add(JRB3);
        JRadioButton JRB4=new JRadioButton("看电视");
        JRB4.setBounds(134,74,121,23);
        JP1.add(JRB4);
        ButtonGroup BG=new ButtonGroup();
        BG.add(JRB1);
        BG.add(JRB2);
        BG.add(JRB3);
        BG.add(JRB4);
    }
    public void CheckBoxFrame(){
        JFrame jf=new JFrame("复选框窗体");
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
        jf.setBounds(100,100,263,178);
        jf.setVisible(true);
        JPanel contentPanel=new JPanel();
        contentPanel.setBorder(new EmptyBorder(5,5,5,5));
        jf.setContentPane(contentPanel);
        contentPanel.setLayout(null);
        JPanel jp=new JPanel();
        jp.setBounds(0,0,248,140);
        contentPanel.add(jp);
        jp.setLayout(null);
        JCheckBox jcb1=new JCheckBox("洗衣机");
        jcb1.setBounds(31,28,73,23);
        jp.add(jcb1);
        JCheckBox jcb2=new JCheckBox("电视机");
        jcb2.setBounds(132,28,73,23);
        jp.add(jcb2);
        JCheckBox jcb3=new JCheckBox("冰箱");
        jcb3.setBounds(31,75,54,23);
        jp.add(jcb3);
        JCheckBox jcb4=new JCheckBox("空调");
        jcb4.setBounds(132,75,54,23);
        jp.add(jcb4);
    }
    public void JTextFieldFrame(){
        JFrame jf=new JFrame("登入窗体");
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
        jf.setBounds(100,100,336,206);
        jf.setVisible(true);
        JPanel contentPane=new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        jf.setContentPane(contentPane);
        contentPane.setLayout(null);
        JPanel jp=new JPanel();
        jp.setBounds(0,0,323,171);
        contentPane.add(jp);
        jp.setLayout(null);         //布局管理器为null
        JLabel userNameLabel=new JLabel("用户名：");
        userNameLabel.setBounds(52,33,54,15);
        jp.add(userNameLabel);
        JTextField userTextField=new JTextField();
        userTextField.setBounds(116,30,139,21);
        jp.add(userTextField);
        userTextField.setColumns(10);
        JLabel passWordLabel=new JLabel("密 码：");
        passWordLabel.setBounds(52,74,54,15);
        jp.add(passWordLabel);
        JPasswordField jpw=new JPasswordField();        //加密框
        jpw.setBounds(116,71,139,21);
        jpw.setEchoChar('#');           //显示字符
        jp.add(jpw);
        jpw.setColumns(10);
//        JTextField passWordTextField=new JTextField();
//        passWordTextField.setBounds(116,71,139,21);
//        jp.add(passWordTextField);
//        passWordTextField.setColumns(10);
        JButton enterButton=new JButton("登录");
        enterButton.setBounds(64,116,69,23);
        jp.add(enterButton);
        JButton closeButton=new JButton("退出");
        closeButton.setBounds(174,116,69,23);
        jp.add(closeButton);
    }
    public void JListDemoFrame(){
        JFrame jf=new JFrame("列表框窗体");
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
        jf.setBounds(100,100,316,238);
        jf.setVisible(true);
        JPanel contentPane=new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        jf.setContentPane(contentPane);
        contentPane.setLayout(null);
        JPanel panel=new JPanel();
        panel.setBounds(0,0,300,200);
        contentPane.add(panel);
        panel.setLayout(null);
        JLabel messageLabel=new JLabel("请选择证件：");
        messageLabel.setBounds(31,25,78,15);
        panel.add(messageLabel);
        String[] card={"身份证","学生证","工作证","军人证"};
        JComboBox comboBox=new JComboBox(card);
        comboBox.setBounds(119,22,114,21);
        panel.add(comboBox);
    }
}
