package TestWindows;

        import javax.swing.*;
        import javax.swing.event.AncestorListener;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;

/**
 * Created by YLL on 2015/9/14.
 */
public class MyFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("MyFrame");
//        frame.setLayout(new FlowLayout(FlowLayout.LEFT,10,20));
//        frame.add(new JPanel(new GridLayout(3,2,5,5)));
        frame.setLayout(new GridLayout(4, 2, 5, 5));
        frame.add(new JLabel("First Name:"));
        frame.add(new JTextField(8));
        frame.add(new JLabel("MI"));
        frame.add(new JTextField(1));
        frame.add(new JLabel("Last Name:"));
        frame.add(new JTextField(8));
        JButton jButton = new JButton("OK");
        jButton.setBackground(Color.blue);
        jButton.setForeground(new Color(100, 55, 50));
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog jDialog = new JDialog();
                jDialog.setVisible(true);
                Container container = jDialog.getContentPane();
                container.add(new JLabel("这是一个对话框"));
                jDialog.setSize(100, 100);
            }
        });
        Font font = new Font("SansSerif", Font.ITALIC, 16);
        jButton.setFont(font);
        JPanel jPanel = new JPanel();
        jPanel.add(jButton);
        frame.add(jPanel);
//        frame.remove(jButton);
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}