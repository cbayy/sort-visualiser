package sortVisualiser;

import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class SVPanel extends JPanel {

    static int COL_X = 10;
    static int BARS = VisualiserDriver.WINDOW_X / COL_X;
    private final int[] arr;
    private int[] colours;

    public SVPanel(){
        setBackground(Color.black);
        //Sorted placeholder array
        arr = new int[BARS];
        colours = new int[BARS];
        for(int i = 0; i< arr.length; i++){
            arr[i] = new Random().nextInt(100)+1;
            colours[i] = 0;
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

    public int get(int index){
        return arr[index];
    }

    public int getLength(){
        return arr.length;
    }

    public void update(int index, int value) {
        arr[index] = value;
        colours[index] = 1;
        repaint();
        long timeElapsed;

        final long startTime = System.nanoTime();
        do{
            timeElapsed = System.nanoTime() - startTime;
        }while(timeElapsed < 5000000);
        colours[index] = 0;
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2D = (Graphics2D) g;
        super.paintComponent(g2D);
        for(int i = 0; i < arr.length; i++){

            if(colours[i] > 0){
                g2D.setColor(new Color(10,150,10));
            }else{
                g2D.setColor(Color.white);
            }

            g2D.fillRect(i + COL_X * i + 20, VisualiserDriver.WINDOW_Y-arr[i]-300,COL_X,arr[i]);

        }

    }
}
