
package jmusic;

import javax.swing.JFrame;

/**
 *
 * @author gracelyn
 */
public class InterfaceJPanelTest {
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame jFrame = new JFrame("InterfaceJPanel Test");
        
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(new InterfaceJPanel(), "South");
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);

    }
    
}
