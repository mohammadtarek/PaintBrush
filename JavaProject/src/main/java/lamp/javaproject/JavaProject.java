/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package lamp.javaproject;

import javax.swing.JFrame;

/**
 *
 * @author Mohammad
 */
public class JavaProject {

    public static void main(String[] args) {
        JFrame myFrame = new JFrame();
        myFrame.setTitle("Draw Lines");
        myFrame.setSize(1200, 800);
        myFrame.setLocationRelativeTo(null);
        
        Panel myPanel = new Panel();
        myFrame.setContentPane(myPanel);
        
        myFrame.setVisible(true);
    }
}
