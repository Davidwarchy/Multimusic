package jmusic;

import java.awt.Dimension;
import javax.swing.JFrame;

public class MusicalJPanelTest {

        public static void main(String[] args) {
        // TODO code application logic here
        JFrame jFrame = new JFrame("MusicJPanel Test");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add( new InterfaceJPanel(), "South" );
        jFrame.setPreferredSize( new Dimension( 600, 370 ) );
        jFrame.pack();  
        jFrame.setLocationRelativeTo( null );
        jFrame.setVisible(true);
    
    }
    
}
