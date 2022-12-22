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
public class Line {

    int xStart, yStart, xEnd, yEnd, color;
    Stroke stroke;

    public Line() {
        xStart = yStart = xEnd = yEnd = color = 0;
    }

    public Line(int xStart, int yStart, int xEnd, int yEnd, int color, Stroke stroke) {
        this.xStart = xStart;
        this.yStart = yStart;
        this.xEnd = xEnd;
        this.yEnd = yEnd;
        this.color = color;
        this.stroke = stroke;
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

    public int getxEnd() {
        return xEnd;
    }

    public int getyEnd() {
        return yEnd;
    }

    public int getColor() {
        return color;
    }

}
