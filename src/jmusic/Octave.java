package jmusic;

public class Octave {
    public int C;
    public int C_SHARP;
    public int D;
    public int D_SHARP;
    public int E;
    public int F;
    public int F_SHARP;
    public int G;
    public int G_SHARP;
    public int A;
    public int A_SHARP;
    public int B;
    
    public int[] notes = { C, C_SHARP, D, D_SHARP, E, F, F_SHARP, G, G_SHARP, A, A_SHARP, B };
    
    public Octave( int octaveNumber ){
        initializeOctave( octaveNumber );
        
    }
    private void initializeOctave( int octaveNumber ){
        for( int j = 0; j < notes.length; j++ ){
            notes[j] = octaveNumber*12 + j;
        }
            this.C = notes[0];
            this.C_SHARP = notes[1];
            this.D = notes[2];
            this.D_SHARP = notes[3];
            this.E = notes[4];
            this.F = notes[5];
            this.F_SHARP = notes[6];
            this.G = notes[7];
            this.G_SHARP = notes[8];
            this.A = notes[9];
            this.A_SHARP = notes[10];
            this.B = notes[11];
    }
    public  Octave changeOctave( int octaveNumber ){
        
        Octave octavexx = new Octave(octaveNumber);
        
        return octavexx;
    }
    
}