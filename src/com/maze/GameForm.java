package com.maze;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by YLL on 2015/9/20.
 */
public class GameForm extends JFrame {
    //游戏窗口
    private GameMap game = new GameMap();
    public GameForm() {
        super("迷宫游戏");
        this.setSize(SWIDTH+12, SHEIGTH+32);
        this.setLocation(100, 50);
        this.add(game);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(new KeyAdapter() {

            /**
             * Invoked when a key has been released.
             *
             * @param e
             */
            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        game.setDirec(GameForm.UP);
                        break;
                    case KeyEvent.VK_DOWN:
                        game.setDirec(GameForm.DOWN);
                        break;
                    case KeyEvent.VK_RIGHT:
                        game.setDirec(GameForm.RIGHT);
                        break;
                    case KeyEvent.VK_LEFT:
                        game.setDirec(GameForm.LEFT);
                        break;
                    default:
                        break;
                }
                game.playGame();
            }
        });
    }

    //游戏界面的长和宽 图片的边长
    public static int SWIDTH = 660;
    public static int SHEIGTH = 660;
    public static int SIDE = 66;

    //初始化方向
    public static int UP = 4;
    public static int DOWN = 1;
    public static int RIGHT = 3;
    public static int LEFT = 2;

    //路：0 墙：1 入口：2 出口：3
    public static int ROAD = 0;
    public static int WALL = 1;
    public static int ENTRY = 2;
    public static int EXIT = 3;

    //初始化地图
    public static int[][] map = new int[][]{
            {1, 1, 1, 0, 1, 1, 1, 1, 3, 1},
            {1, 1, 0, 0, 0, 0, 1, 0, 0, 1},
            {1, 1, 0, 1, 1, 0, 0, 0, 1, 1},
            {1, 1, 0, 0, 1, 0, 1, 1, 1, 1},
            {3, 0, 1, 0, 0, 1, 0, 0, 0, 0},
            {1, 0, 1, 1, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 1, 1, 0, 0, 3},
            {1, 0, 1, 0, 1, 0, 1, 0, 1, 1},
            {2, 0, 1, 0, 0, 0, 0, 0, 1, 1},
            {1, 1, 1, 1, 1, 1, 3, 1, 1, 1}
    };
}
