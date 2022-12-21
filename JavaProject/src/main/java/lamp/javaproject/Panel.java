/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lamp.javaproject;

import pkg1.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Mohammad
 */
public class Panel extends JPanel implements ActionListener {

    private int x1, y1, x2, y2;
    private Vector<Rectangle> recVect;
    private Vector<Rectangle> fillRecVect;
    private Vector<Rectangle> earserVect;
    private Vector<Line> lineVect;
    private Vector<Circle> circleVect;
    private Vector<Circle> fillCircleVect;
    private Vector<Circle> freeHandVect;
    boolean checkrec, checkcir, checkline, checkclear, checkfill, checkearser,checkfreehand;
    JRadioButton rec, circle, line,earser,freehand;
    
    JButton red, green, blue, clear;
    JCheckBox fill;
    int color;//to hold color value when user press color button and store it in shapes objects

    public Panel() {

        checkrec = checkcir = checkline = checkfill =checkfreehand= false; //to know which radiobuttom checked
        x1 = y1 = x2 = y2 = 0;

        recVect = new Vector<Rectangle>();
        fillRecVect = new Vector<Rectangle>();
        earserVect=new Vector<Rectangle>();
        lineVect = new Vector<Line>();
        circleVect = new Vector<Circle>();
        fillCircleVect = new Vector<Circle>();
        freeHandVect=new Vector<Circle>();
        // create radiobutton for shapes
        rec = new JRadioButton("Rectangle", false);
        circle = new JRadioButton("circle", false);
        line = new JRadioButton("line", false);
        earser = new JRadioButton("earser", false);
        freehand=new JRadioButton("Free Hand",false);
//create button for color
        red = new JButton("Red");
        green = new JButton("Green");
        blue = new JButton("Blue");
        clear = new JButton("Clear");
        //create check box for fill shape
        fill = new JCheckBox("Fill");
//create a buttongroup for radio buttons to make sure that only one radio button is checked        
        ButtonGroup group = new ButtonGroup();

//add radiobutton to the buttongroup
        group.add(rec);
        group.add(circle);
        group.add(line);
        group.add(earser);
        group.add(freehand);
        //to make action when click on radio button
        rec.addActionListener(this);
        circle.addActionListener(this);
        line.addActionListener(this);
        earser.addActionListener(this);
        freehand.addActionListener(this);
        //to make action when click on the color
        red.addActionListener(this);
        green.addActionListener(this);
        blue.addActionListener(this);
        clear.addActionListener(this);
        //to make action when choose fill
        fill.addActionListener(this);
        // to display the radiobutton on the panel
        this.add(rec);
        this.add(circle);
        this.add(line);
        this.add(earser);
        this.add(freehand);
        //to display the color buttons on the panel
        this.add(red);
        this.add(green);
        this.add(blue);
        this.add(clear);
        //to display Fill checkbox on the panel
        this.add(fill);
        this.setBackground(Color.white);

        this.setFocusable(true);

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                x1 = e.getX();
                y1 = e.getY();
                 if(checkearser==true){    
                earserVect.add(new Rectangle(x1, y1, 5, 5, color));
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                x2 = e.getX();
                y2 = e.getY();
                //to check user choice befor saving point in the vector

                if (checkrec == true) {
                    if (checkfill == true) {
                        int width = Math.abs(x1 - x2);
                        int height = Math.abs(y1 - y2);
                        fillRecVect.add(new Rectangle(x1, y1, width, height, color));
                    } else {
                        int width = Math.abs(x1 - x2);
                        int height = Math.abs(y1 - y2);
                        recVect.add(new Rectangle(x1, y1, width, height, color));
                    }
                } else if (checkline == true) {
                    lineVect.add(new Line(x1, y1, x2, y2, color));
                } else if (checkcir == true) {
                    if (checkfill == true) {
                        int width = Math.abs(x1 - x2);
                        int height = Math.abs(y1 - y2);
                        fillCircleVect.add(new Circle(x1, y1, width, height, color));
                    } else {
                        int width = Math.abs(x1 - x2);
                        int height = Math.abs(y1 - y2);
                        circleVect.add(new Circle(x1, y1, width, height, color));
                    }
                }
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        });
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
               Graphics g=getGraphics();
                x2 = e.getX();
                y2 = e.getY();
               if(checkearser==true){
                   g.setColor(Color.WHITE);
               g.fillRect(e.getX(), e.getY(), 15,15);
               earserVect.add(new Rectangle(e.getX(), e.getY(), 15, 15, color));
               }
               else if(checkfreehand==true)
                {
                g.fillOval(e.getX(), e.getY(), 5, 5);
                freeHandVect.add(new Circle(e.getX(), e.getY(), 5, 5, color));
                }
                updateUI();
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//draw rectangle for first time
        if (checkrec == true) {
            switch (color) {
                case 1 ->
                    g.setColor(Color.RED);
                case 2 ->
                    g.setColor(Color.GREEN);
                case 3 ->
                    g.setColor(Color.BLUE);
                default ->
                    g.setColor(Color.BLACK);
            }//check if fill checkedin and draw line
            if (checkfill == true) {
                int width = Math.abs(x1 - x2);
                int height = Math.abs(y1 - y2);
                g.fillRect(x1, y1, width, height);   // Draw current last line 
            } else {
                int width = Math.abs(x1 - x2);
                int height = Math.abs(y1 - y2);

                g.drawRect(x1, y1, width, height);   // Draw current last line 
            }

        } else if (checkline == true) {
            switch (color) {
                case 1 ->
                    g.setColor(Color.RED);
                case 2 ->
                    g.setColor(Color.GREEN);
                case 3 ->
                    g.setColor(Color.BLUE);
                default ->
                    g.setColor(Color.BLACK);
            }
            g.drawLine(x1, y1, x2, y2);
        } else if (checkcir == true) {

            switch (color) {
                case 1 ->
                    g.setColor(Color.RED);
                case 2 ->
                    g.setColor(Color.GREEN);
                case 3 ->
                    g.setColor(Color.BLUE);
                default ->
                    g.setColor(Color.BLACK);
            }
            if (checkfill == true) {
                int width = Math.abs(x1 - x2);
                int height = Math.abs(y1 - y2);
                g.fillOval(x1, y1, width, height);
            } else {
                int width = Math.abs(x1 - x2);
                int height = Math.abs(y1 - y2);
                g.drawOval(x1, y1, width, height);
            }

        }else if(checkearser==true){
         g.setColor(Color.WHITE);
         g.fillRect(x1, y1, 15, 15);
         
        }
        else if(checkfreehand==true){
        switch (color) {
                case 1 ->
                    g.setColor(Color.RED);
                case 2 ->
                    g.setColor(Color.GREEN);
                case 3 ->
                    g.setColor(Color.BLUE);
                default ->
                    g.setColor(Color.BLACK);
            }
        g.fillOval(x1, y1, 5, 5);
        }

        // to repaint the saved shapes in the vectors
        for (int i = 0; i < recVect.size(); i++) // Draw all prevoius lines stored in the Vector
        {
            switch (recVect.get(i).getColor()) {
                case 1 ->
                    g.setColor(Color.RED);
                case 2 ->
                    g.setColor(Color.GREEN);
                case 3 ->
                    g.setColor(Color.BLUE);
                default ->
                    g.setColor(Color.BLACK);
            }
            g.drawRect(recVect.get(i).getxStart(), recVect.get(i).getyStart(), recVect.get(i).getWidth(), recVect.get(i).getHight());
        }
        for (int i = 0; i < lineVect.size(); i++) {
            switch (lineVect.get(i).getColor()) {
                case 1 ->
                    g.setColor(Color.RED);
                case 2 ->
                    g.setColor(Color.GREEN);
                case 3 ->
                    g.setColor(Color.BLUE);
                default ->
                    g.setColor(Color.BLACK);
            }
            g.drawLine(lineVect.get(i).getxStart(), lineVect.get(i).getyStart(), lineVect.get(i).getxEnd(), lineVect.get(i).getyEnd());
        }
        for (int i = 0; i < circleVect.size(); i++) {
            switch (circleVect.get(i).getColor()) {
                case 1 ->
                    g.setColor(Color.RED);
                case 2 ->
                    g.setColor(Color.GREEN);
                case 3 ->
                    g.setColor(Color.BLUE);
                default ->
                    g.setColor(Color.BLACK);
            }
            g.drawOval(circleVect.get(i).getX(), circleVect.get(i).getY(), circleVect.get(i).getWidth(), circleVect.get(i).getHeight());
        }

        for (int i = 0; i < fillRecVect.size(); i++) // Draw all prevoius lines stored in the Vector
        {
            switch (fillRecVect.get(i).getColor()) {
                case 1 ->
                    g.setColor(Color.RED);
                case 2 ->
                    g.setColor(Color.GREEN);
                case 3 ->
                    g.setColor(Color.BLUE);
                default ->
                    g.setColor(Color.BLACK);
            }
            g.fillRect(fillRecVect.get(i).getxStart(), fillRecVect.get(i).getyStart(), fillRecVect.get(i).getWidth(), fillRecVect.get(i).getHight());
        }
        for (int i = 0; i < fillCircleVect.size(); i++) {
            switch (fillCircleVect.get(i).getColor()) {
                case 1 ->
                    g.setColor(Color.RED);
                case 2 ->
                    g.setColor(Color.GREEN);
                case 3 ->
                    g.setColor(Color.BLUE);
                default ->
                    g.setColor(Color.BLACK);
            }
            g.fillOval(fillCircleVect.get(i).getX(), fillCircleVect.get(i).getY(), fillCircleVect.get(i).getWidth(), fillCircleVect.get(i).getHeight());
        }
        
        for (int i = 0; i < earserVect.size(); i++) // Draw all prevoius lines stored in the Vector
        {
           g.setColor(Color.WHITE);
            
            g.fillRect(earserVect.get(i).getxStart(), earserVect.get(i).getyStart(), earserVect.get(i).getWidth(), earserVect.get(i).getHight());
        }
        
        for (int i = 0; i < freeHandVect.size(); i++) {
            switch (freeHandVect.get(i).getColor()) {
                case 1 ->
                    g.setColor(Color.RED);
                case 2 ->
                    g.setColor(Color.GREEN);
                case 3 ->
                    g.setColor(Color.BLUE);
                default ->
                    g.setColor(Color.BLACK);
            }
            g.fillOval(freeHandVect.get(i).getX(), freeHandVect.get(i).getY(), freeHandVect.get(i).getWidth(), freeHandVect.get(i).getHeight());
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == rec) {
            checkrec = true;
            checkline = false;
            checkcir = false;
            checkearser = false;
            checkfreehand=false;
        } else if (e.getSource() == line) {

            checkline = true;
            checkcir = false;
            checkrec = false;
            checkearser = false;
            checkfreehand=false;
        } else if (e.getSource() == circle) {

            checkcir = true;
            checkrec = false;
            checkline = false;
            checkearser = false;
            checkfreehand=false;
        } else if (e.getSource() == earser) {
            checkearser = true;
            checkcir = false;
            checkrec = false;
            checkline = false;
            checkfreehand=false;
        }else if(e.getSource()==freehand){
        checkfreehand=true;
        checkearser = false;
            checkcir = false;
            checkrec = false;
            checkline = false;
        }
        
        if (e.getSource() == red) {
            color = 1;

        } else if (e.getSource() == green) {
            color = 2;

        } else if (e.getSource() == blue) {
            color = 3;
        }

        if (e.getSource() == clear) {

            recVect.clear();
            lineVect.clear();
            circleVect.clear();
            fillCircleVect.clear();
            fillRecVect.clear();
            earserVect.clear();
            freeHandVect.clear();
            updateUI();

        }
        if (fill.isSelected()) {
            checkfill = true;
        }
        if (fill.isSelected() == false) {
            checkfill = false;
        }
        
    }

}
