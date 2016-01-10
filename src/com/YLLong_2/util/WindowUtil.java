package com.YLLong_2.util;

import javax.swing.*;
import java.awt.*;

/**
 * Created by YLL on 2015/10/31.
 */
public class WindowUtil {
    //得到窗口大小，封装到Dimension类中
    public static Dimension getsize() {
        return new Dimension(500, 309);
    }
    //得到窗口在显示器的位置(窗口左上角的位置)
    public static Point getLocation() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();//获得Toolkit实例
        Dimension screenSize = toolkit.getScreenSize();//获得当前显示屏的大小
        if((screenSize.height < getsize().height) || (screenSize.width <getsize().width)) {
            JOptionPane.showConfirmDialog(null, "显示器的分辨率至少为500*309", "", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }
        int x = (screenSize.width - getsize().width)/2;//窗口横坐标
        int y = (screenSize.height - getsize().height)/2;//窗口纵坐标
        return new Point(x, y);
    }
}