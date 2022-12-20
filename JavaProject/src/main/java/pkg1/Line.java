/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg1;

/**
 *
 * @author Mohammad
 */
public class Line {

    int xStart, yStart, xEnd, yEnd;
int color;

    
    public Line() {
        xStart = yStart = xEnd = yEnd = color=0;
    }
     public Line(int xStart, int yStart, int xEnd, int yEnd,int color) {
        this.xStart = xStart;
        this.yStart = yStart;
        this.xEnd = xEnd;
        this.yEnd = yEnd;
        this.color=color;
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
