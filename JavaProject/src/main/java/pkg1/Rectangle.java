/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg1;

/**
 *
 * @author Mohammad
 */
public class Rectangle {

    int xStart, yStart, width, height;
    int color;

    public int getColor() {
        return color;
    }
    public Rectangle() {
        xStart = yStart = width = height =color= 0;
    }

    public Rectangle(int xStart, int yStart, int width, int height,int color) {
        this.xStart = xStart;
        this.yStart = yStart;
        this.width = width;
        this.height = height;
        this.color=color;
    }
        public int getxStart() {
        return xStart;
    }

    public int getyStart() {
        return yStart;
    }

    public int getWidth() {
        return width;
    }

    public int getHight() {
        return height;
    }

}
