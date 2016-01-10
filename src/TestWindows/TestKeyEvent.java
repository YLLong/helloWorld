package TestWindows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by YLL on 2015/10/9.
 */
public class TestKeyEvent  extends JFrame {
    public static void main(String[] args) {
        new TestKeyEvent();
    }

    public TestKeyEvent() {
        super("键盘事件");
        setBounds(100, 100, 400, 400);

        final JLabel label = new JLabel();
        label.setText("备注：");
        getContentPane().add(label, BorderLayout.WEST);
        final JScrollPane jScrollPane = new JScrollPane();
        getContentPane().add(jScrollPane);
        JTextArea textArea = new JTextArea();
        textArea.addKeyListener(new KeyAdapter() {
            /**
             * Invoked when a key has been typed.
             * This event occurs when a key press is followed by a key release.
             *
             * @param e
             */
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("此次输入的是”" + e.getKeyChar() + "“");
            }

            /**
             * Invoked when a key has been pressed.
             *
             * @param e
             */
            @Override
            public void keyPressed(KeyEvent e) {
                String keytext = KeyEvent.getKeyText(e.getKeyCode());
                if (e.isActionKey()) {
                    System.out.println("你按下的是动作键”" + keytext + "“");
                } else {
                    System.out.println("你按下的是非动作键”" + keytext + "“");
                    int keyCode = e.getKeyCode();
                    switch (keyCode) {
                        case KeyEvent.VK_CONTROL:
                            System.out.println("，Ctrl 键被按下");
                        case KeyEvent.VK_ALT:
                            System.out.println("，Alt 键被按下");
                        case KeyEvent.VK_SHIFT:
                            System.out.println("，Shift 键被按下");
                    }
                    System.out.println();
                }
            }

            /**
             * Invoked when a key has been released.
             *
             * @param e
             */
            @Override
            public void keyReleased(KeyEvent e) {
                String keyText = KeyEvent.getKeyText(e.getKeyCode());
                System.out.println("你释放的是”" + keyText + "键");
                System.out.println();
            }
        });
        textArea.setLineWrap(true);
        textArea.setRows(3);
        textArea.setColumns(15);
        jScrollPane.setViewportView(textArea);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
