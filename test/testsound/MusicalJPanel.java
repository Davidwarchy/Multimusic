package testsound;

import jmusic.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.Instrument;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Patch;
import javax.sound.midi.Receiver;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Soundbank;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.Track;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

public class MusicalJPanel extends JPanel implements ActionListener {
    private Synthesizer synthesizer;
    private Soundbank soundbank;
    private Instrument[] instrumentArray;
    //configure interface with sequencer
    private Sequencer sequencer;
    private Receiver receiver;
    private Sequence sequence;
    private Track track;
    private ShortMessage shortMessage;
    private Timer timer;
    private int ticksLength;
    private int ticks;
    private long startTime;
    
    private Octave currentOctave;
    private int currentVolume;
    private int currentInstrumentIndex;
    private Patch currentPatch;
    
    
    public MusicalJPanel() throws InvalidMidiDataException{
        
        try {
            synthesizer = MidiSystem.getSynthesizer();
            synthesizer.open();
            
            sequencer = MidiSystem.getSequencer();
            this.receiver = sequencer.getReceiver();
        } catch (MidiUnavailableException ex) {
            Logger.getLogger(MusicalJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        //configure interface with sequencer
        sequence = new Sequence( Sequence.PPQ, 100 );//maintain constant
        track   = sequence.createTrack();
        this.shortMessage = new ShortMessage();
        this.timer = new Timer( 1, this );
        this.ticksLength = 0;
        
        
        soundbank = synthesizer.getDefaultSoundbank();
        instrumentArray = soundbank.getInstruments();
        
        this.currentInstrumentIndex = 0;
        this.currentOctave = new Octave(5);
        this.currentVolume = 60;
        this.currentPatch = new Patch( 0, 0 );
        
        initializeSynthesizer();
        initializeJPanel();
    }
    
    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    public ShortMessage getShortMessage() {
        return shortMessage;
    }

    public void setShortMessage(ShortMessage shortMessage) {
        this.shortMessage = shortMessage;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public int getTicksLength() {
        return ticksLength;
    }

    public void setTicksLength(int ticksLength) {
        this.ticksLength = ticksLength;
    }

    public Sequencer getSequencer() {
        return sequencer;
    }

    public void setSequencer(Sequencer sequencer) {
        this.sequencer = sequencer;
    }

    public Sequence getSequence() {
        return sequence;
    }

    public void setSequence(Sequence sequence) {
        this.sequence = sequence;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }
    
    private void initializeSynthesizer(){
         this.synthesizer.getChannels()[0].programChange( currentPatch.getBank(), currentPatch.getProgram() );
    }
    private void initializeJPanel(){
        this.addKeyListener( new KeyAdapter() );
        this.setVisible(true);
        this.setBackground(Color.yellow);
        this.setBorder( new LineBorder( Color.MAGENTA, 5 ));
        this.setFocusable(true);
        this.setPreferredSize( new Dimension( 600, 370 ));
        this.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent fe) {
                MusicalJPanel.this.setBackground( Color.GREEN );
                System.out.println("Focus Gained");
            }

            @Override
            public void focusLost(FocusEvent fe) {
                MusicalJPanel.this.setBackground( Color.RED );
                System.out.println("Focus Lost");
            }
            
        });
        
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.ticksLength+=1;
    }
    private void play( int noteNumber ){
        
//        try {
//            shortMessage.setMessage( ShortMessage.NOTE_ON, 0, noteNumber, this.currentVolume );
//        } catch (InvalidMidiDataException ex) {
//            Logger.getLogger(MusicalJPanel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        this.track.add( new MidiEvent( shortMessage, ticksLength ) );
//        this.synthesizer.getChannels()[0].noteOn( noteNumber , this.currentVolume );
//        System.out.println("Ticks length    ::  " + this.ticksLength);
        ShortMessage message = new ShortMessage();
        try {
            long millis = System.currentTimeMillis() - startTime;
            long tick = millis * sequence.getResolution() / 500;
            message.setMessage( ShortMessage.NOTE_ON, noteNumber, this.currentVolume ); 
            MidiEvent event = new MidiEvent(message, tick);
            track.add(event);
            this.synthesizer.getChannels()[0].noteOn( noteNumber , this.currentVolume );
        } catch (Exception ex) { ex.printStackTrace(); }

    }
    
    public void createShortEvent(int type, int num) {
        ShortMessage message = new ShortMessage();
        try {
            long millis = System.currentTimeMillis() - startTime;
            long tick = millis * sequence.getResolution() / 500;
            message.setMessage( ShortMessage.NOTE_ON, num, this.currentVolume ); 
            MidiEvent event = new MidiEvent(message, tick);
            track.add(event);
        } catch (Exception ex) { ex.printStackTrace(); }
    }
    
    public void startRecordingToSequence() {
        try {
            startTime = System.currentTimeMillis();
            sequencer.open();
            sequencer.setSequence(sequence);
            sequencer.setTempoInBPM(720);
            sequencer.recordEnable(sequence.getTracks()[0], 0);
            sequencer.startRecording();

        } catch (MidiUnavailableException | InvalidMidiDataException ex) {
            Logger.getLogger(SeqwencerJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
        

    public void stopRecordingToSequence() {

        sequencer.stopRecording();
        sequencer.close();

        try {
            MidiSystem.write(sequence, 0, new File("./src/music/2018_02_22_.mid"));
            System.out.println("Write to newmidi.mid successful.");
        } catch (IOException ex) {
            Logger.getLogger(SeqwencerJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Synthesizer getSynthesizer() {
        return synthesizer;
    }

    public void setSynthesizer(Synthesizer synthesizer) {
        this.synthesizer = synthesizer;
    }

    public Soundbank getSoundbank() {
        return soundbank;
    }

    public void setSoundbank(Soundbank soundbank) {
        this.soundbank = soundbank;
    }

    public Instrument[] getInstrumentArray() {
        return instrumentArray;
    }

    public void setInstrumentArray(Instrument[] instrumentArray) {
        this.instrumentArray = instrumentArray;
    }

    public Octave getCurrentOctave() {
        return currentOctave;
    }

    public void setCurrentOctave(Octave currentOctave) {
        this.currentOctave = currentOctave;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int currentVolume) {
        this.currentVolume = currentVolume;
    }

    public int getCurrentInstrumentIndex() {
        return currentInstrumentIndex;
    }

    public void setCurrentInstrumentIndex(int currentInstrumentIndex) {
        
        this.currentInstrumentIndex = currentInstrumentIndex;
        this.currentPatch = this.instrumentArray[ currentInstrumentIndex ].getPatch(); 
        this.synthesizer.getChannels()[0].programChange( currentPatch.getBank(), currentPatch.getProgram() );
    }

    public Patch getCurrentPatch() {
        return currentPatch;
    }

    public void setCurrentPatch(Patch currentPatch) {
        this.currentPatch = currentPatch;
}


    private class KeyAdapter implements KeyListener{
        private HashMap< Character, Integer > keyMap = new HashMap<  >();
        private HashMap< Character, Integer > octaveMap = new HashMap< >();
        
        
        
        private final char[] octaveChangingCharacters = { 'Q','A','S','D','F','J','K','L',':','O','P' };
        
        public KeyAdapter(){
            
            for( int i = 0; i < octaveChangingCharacters.length; i++){
                octaveMap.put( octaveChangingCharacters[i], i );
            }
            initializeKeyMap();
        }
        
        public void initializeKeyMap() {
            char[] keyCharacters = {'a', 'w', 's', 'e', 'd', 'f', 'u', 'j', 'i', 'k', 'o', 'l', ';', 'c'};
            int[] keyNoteNumbers = {
                                    currentOctave.C,
                                    currentOctave.C_SHARP,
                                    currentOctave.D,
                                    currentOctave.D_SHARP,
                                    currentOctave.E,
                                    currentOctave.F,
                                    currentOctave.F_SHARP,
                                    currentOctave.G,
                                    currentOctave.G_SHARP,
                                    currentOctave.A,
                                    currentOctave.A_SHARP,
                                    currentOctave.B,
                                    currentOctave.C + 12,
                                    currentOctave.E + 12
                                };
            for (int i = 0; i < keyCharacters.length; i++) {
                keyMap.put(keyCharacters[i], keyNoteNumbers[i]);
            }
        }
        
        @Override
        public void keyTyped(KeyEvent ke) {
            char charxx = ke.getKeyChar();
            switch( charxx ){
                case('%'):
                MusicalJPanel.this.timer.start();
                MusicalJPanel.this.startRecordingToSequence();
                System.out.println("Started Recording To Sequence.");
                break;
                case('^'):
                    MusicalJPanel.this.stopRecordingToSequence();
                    break;
            } 
           
        }

        @Override
        public void keyPressed(KeyEvent ke) {
            
            char charxx = ke.getKeyChar();
            System.out.println(ke.isShiftDown());

            if (ke.isShiftDown()) {
                if (octaveMap.containsKey(charxx)) {
                    System.out.println("octaveMap Contains Key");
                    System.out.println("value " + octaveMap.get(charxx));
                    currentOctave = new Octave(octaveMap.get(charxx));
                    this.initializeKeyMap();
                }

            } else {
                System.out.println("<<JPanel>> Key pressed : " + charxx);

                if (keyMap.containsKey(charxx)) {
                    System.out.println("KeyMap Contains Key");
                    MusicalJPanel.this.play(keyMap.get(charxx));
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {
            int QUARTER_TIME = 250;
            int HALF_TIME = 500;
            
            if( ke.getKeyChar() == '&'){
                try {
                MusicalJPanel.this.play(currentOctave.E);
                Thread.sleep(QUARTER_TIME);
                MusicalJPanel.this.play(currentOctave.F);
                Thread.sleep(QUARTER_TIME);
                MusicalJPanel.this.play(currentOctave.G);
                Thread.sleep(QUARTER_TIME);
                MusicalJPanel.this.play(currentOctave.A);
                Thread.sleep(QUARTER_TIME);
                MusicalJPanel.this.play(currentOctave.B);
                Thread.sleep(HALF_TIME);
                MusicalJPanel.this.play(currentOctave.B);
                MusicalJPanel.this.play(currentOctave.G);
                MusicalJPanel.this.play(currentOctave.E);
                Thread.sleep(HALF_TIME);
                //2
                MusicalJPanel.this.play(currentOctave.A);
                MusicalJPanel.this.play(currentOctave.C + 12 );
                Thread.sleep(QUARTER_TIME);
                MusicalJPanel.this.play(currentOctave.B);
                Thread.sleep(QUARTER_TIME);
                MusicalJPanel.this.play(currentOctave.A);
                MusicalJPanel.this.play(currentOctave.C + 12 );
                Thread.sleep(QUARTER_TIME);
                MusicalJPanel.this.play(currentOctave.E + 12 );
                Thread.sleep(QUARTER_TIME);
                MusicalJPanel.this.play(currentOctave.B);
                MusicalJPanel.this.play(currentOctave.G);
                MusicalJPanel.this.play(currentOctave.E);
                Thread.sleep(HALF_TIME*2);
                //3
                MusicalJPanel.this.play(currentOctave.A);
                MusicalJPanel.this.play(currentOctave.E);
                Thread.sleep(HALF_TIME);
                MusicalJPanel.this.play(currentOctave.A);
                Thread.sleep(QUARTER_TIME);
                MusicalJPanel.this.play(currentOctave.A);
                Thread.sleep(QUARTER_TIME);
                MusicalJPanel.this.play(currentOctave.G);
                Thread.sleep(QUARTER_TIME);
                MusicalJPanel.this.play(currentOctave.F);
                Thread.sleep(QUARTER_TIME);
                MusicalJPanel.this.play(currentOctave.B);
                MusicalJPanel.this.play(currentOctave.G);
                MusicalJPanel.this.play(currentOctave.E);
                Thread.sleep(HALF_TIME);
                //4
                MusicalJPanel.this.play(currentOctave.C );
                MusicalJPanel.this.play(currentOctave.F);
                Thread.sleep(QUARTER_TIME);
                MusicalJPanel.this.play(currentOctave.E);
                Thread.sleep(QUARTER_TIME);
                MusicalJPanel.this.play(currentOctave.C );
                MusicalJPanel.this.play(currentOctave.F);
                Thread.sleep(QUARTER_TIME);
                MusicalJPanel.this.play(currentOctave.G);
                Thread.sleep(QUARTER_TIME);
                MusicalJPanel.this.play(currentOctave.B);
                MusicalJPanel.this.play(currentOctave.G);
                MusicalJPanel.this.play(currentOctave.E);
                Thread.sleep(HALF_TIME*2);
            } catch (InterruptedException ex) {
                Logger.getLogger(MusicalJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
        
    }
}
