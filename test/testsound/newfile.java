/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsound;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author gracelyn
 */
public class newfile {
    
    public static void main(String[] args) throws IOException {
        
        File file;
        
        String filename;
        
        for( int i = 0; i < 10; i++ ){
            filename = String.format("%d", System.nanoTime() );
            file = new File("./test/testsound/"+filename+".dvd");
            file.createNewFile();
            System.out.println(filename);
        }
    }
    
}
