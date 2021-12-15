package testsound;

import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.InvalidMidiDataException;
import javax.swing.JFrame;

public class MusicalJPanelTest {

        public static void main(String[] args) {
        // TODO code application logic here
        JFrame jFrame = new JFrame("MusicJPanel Test");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            try {
                jFrame.add( new MusicalJPanel(), "South" );
            } catch (InvalidMidiDataException ex) {
                Logger.getLogger(MusicalJPanelTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        jFrame.setPreferredSize( new Dimension( 600, 370 ) );
        jFrame.pack();  
        jFrame.setLocationRelativeTo( null );
        jFrame.setVisible(true);
    
    }
    
}
