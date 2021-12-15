package images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;

public class GIFCreation {
    
    public static void main(String[] args) throws IOException {
        BufferedImage firstImageInSequence = new BufferedImage(40, 40, BufferedImage.TYPE_INT_ARGB);
        
        try (ImageOutputStream imageOutputStream = new FileImageOutputStream( new File("./src/images/newlycreatedGIF1.gif"))) {
            File[] imageFileArray = new File[]{
                new File("./src/images/recordimage.png"),
            };
            
            
            
            GifSequenceWriter gifSequenceWriter = new GifSequenceWriter( imageOutputStream,
                    firstImageInSequence.getType(),
                    500,
                    true);
            
            gifSequenceWriter.writeToSequence(firstImageInSequence);
            
            BufferedImage nextBufferedImage;
            int i = 0;
            for (File imageFileArray1 : imageFileArray) {
                i++;
                System.out.println(i);
                nextBufferedImage = ImageIO.read(imageFileArray1);
                gifSequenceWriter.writeToSequence(nextBufferedImage);
            }
            
            gifSequenceWriter.close();
        }
    }
}
