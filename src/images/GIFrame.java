/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package images;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author gracelyn
 */
public class GIFrame {
    public static void main(String[] args) throws IOException {
        /* Set the Nimbus look and feel */
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            System.out.println("Exception Occurred.");
        }
        //</editor-fold>
        
        File file = new File("./src/images/newlycreatedGIF.gif");
        URL url = file.toURI().toURL();
        System.out.println("url"+url);
        
        Icon icon = new ImageIcon(url);
        
        JButton jButton = new JButton(icon);
        jButton.setText("Woow");
        
        JFrame jFrame = new JFrame("GIF Test");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add( jButton );
        jFrame.setPreferredSize( new Dimension( 600, 370 ) );
        jFrame.pack();  
        jFrame.setLocationRelativeTo( null );
        jFrame.setVisible(true);
    }
}
