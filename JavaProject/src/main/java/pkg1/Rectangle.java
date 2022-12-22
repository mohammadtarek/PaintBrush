/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg1;

import java.awt.Stroke;

/**
 *
 * @author Mohammad
 */
public class Rectangle {

    int xStart, yStart, width, height;
    int color;
    Stroke stroke;

    public int getColor() {
        return color;
    }
    public Rectangle() {
        xStart = yStart = width = height =color= 0;
    }

    public Rectangle(int xStart, int yStart, int width, int height,int color,Stroke stroke) {
        this.xStart = xStart;
        this.yStart = yStart;
        this.width = width;
        this.height = height;
        this.color=color;
        this.stroke=stroke;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Stroke getStroke() {
        return stroke;
    }

    public void setStroke(Stroke stroke) {
        this.stroke = stroke;
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
