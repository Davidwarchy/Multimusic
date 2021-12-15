package jmusic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import javax.swing.JButton;
import javax.swing.Timer;

public class ClockButton extends JButton implements ActionListener {
    final int timeDelay = 100;
    Timer timer = new Timer( timeDelay, this );
    int milliseconds;

    public ClockButton(){
        milliseconds = 0;
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        milliseconds += timeDelay;
        this.setText(formatTime( milliseconds ));
        
    }
    private static String formatTime( int ms ){
        double hours = TimeUnit.MILLISECONDS.toHours( ms );
        double minutes = TimeUnit.MILLISECONDS.toMinutes( ms )%60;
        double seconds = TimeUnit.MILLISECONDS.toSeconds(ms)%60;
        double millis = ms%1000;
        return String.format("%02.0f:%02.0f:%02.0f:%03.0f:", hours, minutes, seconds, millis );
    }
    
    public void startTimer(){
        this.timer.start();
    }
    public void resetTimer(){
        this.timer.restart();
        this.timer.stop();
        this.milliseconds = 0;
        this.setText(formatTime( milliseconds ));
    }
    public void pauseTimer(){
        this.timer.stop();
    }
}