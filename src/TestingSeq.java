
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gracelyn
 */
public class TestingSeq {
    public static void main(String[] args) {
        Sequencer sequencer;
        Sequence sequence;
        ShortMessage shortMessage = new ShortMessage();
        
        try {
            sequencer = MidiSystem.getSequencer();
            if( sequencer == null ){
                System.out.println("Couldn't Obtain Sequencer");
            } else{
                sequencer.open();
                sequence = new Sequence( Sequence.PPQ, 10 );
                sequence.createTrack();
                Track track00 = sequence.getTracks()[0];
                
                for( int i = 0; i < 10; i++ ){
                    shortMessage.setMessage( ShortMessage.NOTE_ON, 0, 60+i, 90 );
                    track00.add( new MidiEvent( shortMessage, 1 ) );
                    
                }
                
                //playing the sequence
                sequencer.startRecording();
                sequencer.setSequence( sequence );
                
                
            }
        } catch (InvalidMidiDataException | MidiUnavailableException e) {
            e.printStackTrace();
        }
    }
    
}
