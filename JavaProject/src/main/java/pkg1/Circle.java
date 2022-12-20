/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg1;

/**
 *
 * @author Mohammad
 */
public class Circle {
    int width;
    int height;
    int x;
    int y;
    int color;

   

    public void setColor(int color) {
        this.color = color;
    }
    

    public Circle() {
        x=y=width=height=color=0;
    }

    public Circle(int x, int y,int width,int height,int color ) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.color=color;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
 public int getColor() {
        return color;
    }
    
}
