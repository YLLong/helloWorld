package com.maze;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by YLL on 2015/9/20.
 */
public class GameMap extends JPanel {

    private BufferedImage wall;
    private BufferedImage[] up = new BufferedImage[4];
    private BufferedImage[] down = new BufferedImage[4];
    private BufferedImage[] right = new BufferedImage[4];
    private BufferedImage[] left = new BufferedImage[4];
    private int direc = 0;      //初始化方向
    private int index = 0;      //人物数组脚标
    private int row = 0;        //行 列
    private int col = 0;

    public GameMap() {
        super();
        setSize(GameForm.SWIDTH, GameForm.SHEIGTH);
        setVisible(true);
        initImage();
    }

    //初始化人物数组
    public void initImage() {
        try {
//            System.out.print("123");
            wall = ImageIO.read(this.getClass().getResource("/com/maze/Photo/wall.bmp"));
//            System.out.print("123");
            for(int i=1; i<up.length+1; i++) {
                up[i - 1] = ImageIO.read(this.getClass().getResource("/com/maze/Photo/4." + i + ".bmp"));
            }
            for(int i=1; i<down.length+1; i++) {
                down[i - 1] = ImageIO.read(this.getClass().getResource("/com/maze/Photo/1." + i + ".bmp"));
            }
            for(int i=1; i<right.length+1; i++) {
                right[i - 1] = ImageIO.read(this.getClass().getResource("/com/maze/Photo/3." + i + ".bmp"));
            }
            for(int i=1; i<left.length+1; i++) {
                left[i - 1] = ImageIO.read(this.getClass().getResource("/com/maze/Photo/2."+ i +".bmp"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //初始化地图
    public void drawMap(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, GameForm.SWIDTH, GameForm.SHEIGTH);
        for(int i=0; i<GameForm.map.length; i++) {
            for(int j=0; j<GameForm.map[i].length; j++) {
                if(GameForm.map[i][j]==GameForm.ENTRY) {
                    row = i;
                    col = j;
                }
                if(GameForm.map[i][j]==GameForm.EXIT) {
                    g.setColor(Color.red);
                    g.fillRect(j*GameForm.SIDE, i*GameForm.SIDE, GameForm.SIDE, GameForm.SIDE);
                    g.setColor(Color.yellow);
                    g.fillOval(j*GameForm.SIDE+15, i*GameForm.SIDE+20, 10, 10);
                    g.fillOval(j*GameForm.SIDE+35, i*GameForm.SIDE+20, 10, 10);
                }
                if(GameForm.map[i][j]==GameForm.WALL) {
                    g.drawImage(wall, j*GameForm.SIDE, i*GameForm.SIDE, null);
                }
            }
        }
        initEntry(g);
    }

    public void initEntry(Graphics g) {
        if(GameForm.map[row][col]==GameForm.ENTRY) {
            if(col-1>0 && GameForm.map[row][col-1]==GameForm.ROAD) {
                direc = GameForm.LEFT;
                g.drawImage(left[0], GameForm.SIDE*col, GameForm.SIDE*row, null);
            }
            else if(col+1<GameForm.map[row].length && GameForm.map[row][col+1]==GameForm.ROAD) {
                direc = GameForm.RIGHT;
                g.drawImage(right[0], GameForm.SIDE*col, GameForm.SIDE*row, null);
            }
            else if(row-1>0 && GameForm.map[row-1][col]==GameForm.ROAD) {
                direc = GameForm.UP;
                g.drawImage(up[0], GameForm.SIDE*col, GameForm.SIDE*row, null);
            }
            else if(row+1<GameForm.map.length &&GameForm.map[row+1][col]==GameForm.ROAD) {
                direc = GameForm.DOWN;
                g.drawImage(down[0], GameForm.SIDE*col, GameForm.SIDE*row, null);
            }
        }
    }
    public void  isWin(int i, int j) {
        if(i>=0 && j<10 && j>=0 && i<10 && GameForm.map[i][j]==GameForm.EXIT) {
            int re = JOptionPane.showConfirmDialog(null, "恭喜过关！");
            if(re==JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }

    public void playGame() {
        Graphics g = this.getGraphics();
        if(index==3) {
            index=0;
        }
        if(direc==GameForm.UP) {
            isWin(row-1, col);
            if(row-1>=0 && GameForm.map[row-1][col]==GameForm.ROAD) {
                g.drawImage(up[index], col*GameForm.SIDE, (row-1)*GameForm.SIDE, null);
                fillBlock(g);
                index++;
                row--;
            }
        }
        else if(direc==GameForm.DOWN) {
            isWin(row+1, col);
            if(row+1<10 && GameForm.map[row+1][col]==GameForm.ROAD) {
                g.drawImage(down[index], col*GameForm.SIDE, (row+1)*GameForm.SIDE, null);
                fillBlock(g);
                index++;
                row++;
            }
        }
        else if(direc==GameForm.RIGHT) {
            isWin(row, col+1);
            if(col+1<10 && GameForm.map[row][col+1]==GameForm.ROAD) {
                g.drawImage(right[index], (col+1)*GameForm.SIDE, row*GameForm.SIDE, null);
                fillBlock(g);
                index++;
                col++;
            }
        }
        else if(direc==GameForm.LEFT) {
            isWin(row, col-1);
            if(col-1>=0 && GameForm.map[row][col-1]==GameForm.ROAD) {
                g.drawImage(left[index], (col-1)*GameForm.SIDE, row*GameForm.SIDE, null);
                fillBlock(g);
                index++;
                col--;
            }
        }
    }

    public void fillBlock(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(col*GameForm.SIDE, row*GameForm.SIDE, GameForm.SIDE, GameForm.SIDE);
    }

    @Override
    public void paint(Graphics g) {
        this.drawMap(g);
    }

//    public Dimension setPreferredSize() {
//        return new Dimension(GameForm.SIDE, GameForm.SIDE);
//    }

//    public int getDirec() {
//        return direc;
//    }
    public void setDirec(int direc) {
        this.direc = direc;
    }
}
