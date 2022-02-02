package sortVisualiser;

import java.util.ArrayList;
import javax.sound.midi.*;

//Sound player for the sorting algorithm
public class MidiPlayer {

    private Synthesizer synth;
    private final MidiChannel chan;

    //Contains which note is associated with each index
    private final ArrayList<Integer> notes;

    //Includes set up for the sound player
    public MidiPlayer(){
        try {
            synth = MidiSystem.getSynthesizer();
            synth.open();
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }

        chan = synth.getChannels()[0];

        Instrument[] instruments = synth.getDefaultSoundbank().getInstruments();

        //Loops through each of the instruments adds them to an array and prints the name
        for (int index = 0; index < instruments.length; index++) {
            Instrument i = instruments[index];
            //System.out.println(index + ": " + i.getName());
        }

        //Good ones include: 139, 151 (laser gun),

        chan.programChange(instruments[151].getPatch().getProgram());

        //Sets up the note to be played for each index value of the array
        notes = new ArrayList<>();
        for (int i = 50; i <= 1000; i += 1) {
            notes.add(i);
        }
    }

    //Method which plays the note through the midiplayer
    public void play(int value) {
        int index = (int)((float)value/1000 * (float) notes.size());
        int note = notes.get(index);
        chan.noteOn(note, 25);
    }
}