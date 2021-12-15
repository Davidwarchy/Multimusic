package jmusic;



import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author gracelyn
 */
public class MusicImages {
        public static Color themeColor = Color.MAGENTA;
    
    public static BufferedImage createPlayBufferedImage( int width, int height, String filepath ){
        BufferedImage bufferedImage = new BufferedImage( width, height, BufferedImage.TYPE_INT_ARGB );
        Graphics2D g2d = bufferedImage.createGraphics();
        //gets coordinates of all (x, y) coordinates.
        int[] xPoints = { (int)(width/4),   width/4,                    (int)(width - width/4) };
        int[] yPoints = { (int)(height/4),  (int)(height - height/4),    height/2 };
        //setColor of graphics context
        g2d.setColor(themeColor);
        g2d.setStroke( new BasicStroke(4));
        //draws a closed polygon from xpoints and ypoints to the buffered Image
        g2d.drawPolygon(xPoints, yPoints, xPoints.length );
        
        //now that bufferedImage is drawn on, write image to a file.
        try {
            ImageIO.write(bufferedImage, "png", new File( filepath+"playimage.png" ));
        } catch (IOException ex) {
            Logger.getLogger(MusicImages.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("<<MusicImages>>:: Failed to create play image file");
        }
        
        return bufferedImage;
    }
    public static BufferedImage createPlayBufferedImage( int width, int height ){
        return createPlayBufferedImage( width, height, "./src/images/");
    }
    
    public static BufferedImage createPauseBufferedImage( int width, int height, String filepath ){
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        
        //setColor of graphics context
        g2d.setColor(themeColor);
        g2d.setStroke( new BasicStroke(4) );
        
        //actual drawing of two vertical lines to represent the pause symbol
        g2d.drawLine( (int)(width*3/8),  (int)(height/4), (int)(width*3/8),     (int)(height - height/4) );
        g2d.drawLine( (int)(width*5/8),  (int)(height/4),   (int)(width*5/8),   (int)(height - height/4) );
        
        //writing the buffered image to an external file
        try {
            ImageIO.write( bufferedImage, "png", new File(filepath+"pauseimage.png") );
        } catch (IOException ex) {
            Logger.getLogger(MusicImages.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("<<MusicImages>>:: Failed to create play image file");
        }
        
        return bufferedImage;
    }
    public static BufferedImage createPauseBufferedImage( int width, int height ){
        return createPauseBufferedImage( width, height, "./src/images/");
    }
    
    public static BufferedImage createRecordBufferedImage( int width, int height, String filepath ){
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bufferedImage.createGraphics();

        //setColor of graphics context
        g2d.setColor( Color.RED );
        g2d.setStroke(new BasicStroke(4));

        //actual drawing of two vertical lines to represent the pause symbol
        g2d.fillOval( (int)(width/4), (int)(height/4), (int)(width/2), (int)(height/2) );

        //writing the buffered image to an external file
        try {
            ImageIO.write(bufferedImage, "png", new File(filepath + "recordimage.png"));
        } catch (IOException ex) {
            Logger.getLogger(MusicImages.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("<<MusicImages>>:: Failed to create record image file");
        }

        return bufferedImage;
    }
    public static BufferedImage createRecordBufferedImage( int width, int height ){
        return createRecordBufferedImage( width, height, "./src/images/" );
    }
    
    private static BufferedImage createStopBufferedImage( int width, int height, String filepath ){
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bufferedImage.createGraphics();

        //setColor of graphics context
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(4));

        //actual drawing of two vertical lines to represent the pause symbol
        g2d.fillRect((int) (width / 4), (int) (height / 4), (int) (width / 2), (int) (height / 2));

        try {
            ImageIO.write(bufferedImage, "png", new File(filepath + "stop.png"));
        } catch (IOException ex) {
            Logger.getLogger(MusicImages.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("<<MusicImages>>:: Failed to create stop image file");
        }

        return bufferedImage;
    }
        public static BufferedImage createStopBufferedImage( int width, int height ){
        return createStopBufferedImage( width, height, "./src/images/" );
    }
    
    public static void main(String[] args) {
        int squareSize = 40;
        
//        MusicImages.createPlayBufferedImage( squareSize, squareSize );
//        MusicImages.createPauseBufferedImage( squareSize, squareSize );
//        MusicImages.createRecordBufferedImage( squareSize, squareSize );
        MusicImages.createStopBufferedImage( squareSize, squareSize );
    }
}
