package sortVisualiser;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public class SVPanel extends JPanel {

    static int COL_X = 10;
    static int BARS = visualiserDriver.WINDOW_X / COL_X;
    public int[] arr;

    public SVPanel(){
        //Sorted placeholder array
        arr = new int[BARS];
        for(int i = 0; i< arr.length; i++){
            arr[i] = i;
        }
        arrayRandom();
    }

    public void arrayRandom(){
        Random r = new Random();
        for(int i = 0; i < BARS; i++){
            int index = r.nextInt(BARS-1);
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] =  temp;
        }
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2D = (Graphics2D) g;
        super.paintComponent(g2D);
        for(int i = 0; i < arr.length; i++){
            g2D.fillRect(i + COL_X * i,visualiserDriver.WINDOW_Y-arr[i]-100,COL_X,arr[i]);
        }

    }
}
