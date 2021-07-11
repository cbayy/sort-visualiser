package sortVisualiser;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class SVPanel extends JPanel {

    static int COL_X = 4;
    static int BARS = visualiserDriver.WINDOW_X / COL_X;
    public int[] arr = new int[100];

    public SVPanel(){
        //Sorted placeholder array
        arr = new int[100];
        for(int i = 0; i< arr.length; i++){
            arr[i] = i;
        }
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2D = (Graphics2D) g;
        super.paintComponent(g2D);
        for(int i = 0; i < arr.length; i++){
            g2D.fillRect(i + COL_X * i,visualiserDriver.WINDOW_Y-arr[i],COL_X,arr[i]);
        }

    }
}
