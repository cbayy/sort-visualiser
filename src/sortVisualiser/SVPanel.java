package sortVisualiser;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import javax.sound.midi.*;

public class SVPanel extends JPanel {

    //Column width
    static int COL_X = 6;

    //The number of bars present
    static int BARS = VisualiserDriver.WINDOW_X / COL_X - 20;

    //Array of values to be sorted
    private final int[] arr;

    //Array containing the colour value of each bar
    private int[] colours;

    //Name of the current sort
    private String sortString;

    //Sort completion time
    private String elapsedTime;

    //Sound player
    MidiPlayer midiPlayer;

    public SVPanel(){
        setBackground(Color.black);
        midiPlayer = new MidiPlayer();

        //Sorted placeholder array
        arr = new int[BARS];
        colours = new int[BARS];

        //Fills array with random numbers
        for(int i = 0; i< arr.length; i++){
            arr[i] = new Random().nextInt(300)+1;
            colours[i] = 0;
        }

        //Sets default display strings
        sortString = "Select sort";
        elapsedTime = "N/A";
        //midiPlayer.setUpPlayer(0);
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

    //General method used to return value an array value to the sort
    public int get(int index){
        return arr[index];
    }

    //Sets the value from the sort
    public void set(int index, int value){
        arr[index] = value;
    }

    public int getLength(){
        return arr.length;
    }

    //Changes the sort representation displayed screen to the current sorted/ing array
    public void update(int index, int value) {
        arr[index] = value;

        //Briefly changes the colour of the current updated index
        colours[index] = 1;
        repaint();

        //PLays sound depending on the value of the index
        midiPlayer.play(value);

        //Small break between each sort (for viewing sake)
        long timeElapsed;
        final long startTime = System.nanoTime();
        do{
            timeElapsed = System.nanoTime() - startTime;
        }while(timeElapsed < 5000000);

        //Changes the colour back to the default
        colours[index] = 0;
    }

    public void setSortString(String sort){
        sortString = sort;
    }

    public void setElapsedTime(String time){ elapsedTime = time; repaint();}

    //Paints all the graphics to the screen
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2D = (Graphics2D) g;
        super.paintComponent(g2D);

        //Default colour is white
        g.setColor(Color.white);
        Font font = g.getFont().deriveFont( 30.0f );
        g.setFont(font);

        //Draws the information strings
        g2D.drawString(sortString, 40,40);
        g2D.drawString("Time taken : " + elapsedTime + " s", 400, 40);

        //Loops through array and created a visual bar for each index
        for(int i = 0; i < arr.length; i++){
            if(colours[i] > 0){
                g2D.setColor(new Color(10,150,10));
            }else{
                g2D.setColor(Color.white);
            }
            g2D.fillRect(i + COL_X * i + 50, VisualiserDriver.WINDOW_Y-arr[i]-300,COL_X,arr[i]);
        }
    }
}
