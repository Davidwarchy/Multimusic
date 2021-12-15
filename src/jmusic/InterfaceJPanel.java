//very enjoyable progressions
//;lkj;
//jklj
//asda
//;lkj;
//;l;;lk
//asa - acceptance/acquiescence
//amen - ;kj;
//;;llj;;
//kdda - to hell with you. i'm moving on
//d; - steep descent (into sadness)
//;;;lllk - i'm doing sth else
//ieija - you can't explain music
//;lk;lk - repeat that
//jjlk;l
//ffsdas
//;;;lllk   ffsdas
//akj - taruta (thuruari)
//djd
//d;d
//lkkkj - i told you so
//
/*
HARP
ASDF FDSA ;
ASDF J FDSA
;l;lkkj

SYNTH BASS 1
JJAC
;asjd
jlk;
;asjd - new idea
*/

//i think that if AI is going to make music, it's gonna make great discrete music
package jmusic;

import java.awt.event.ItemEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.MidiUnavailableException;

public class InterfaceJPanel extends javax.swing.JPanel {

    public InterfaceJPanel() {
        try {
            seqwencerJPanel = new jmusic.SeqwencerJPanel();
        } catch (javax.sound.midi.MidiUnavailableException e1) {
        }
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        volumeJSlider = new javax.swing.JSlider();
        volumeJButton = new javax.swing.JButton();
        instrumentJComboBox = new javax.swing.JComboBox<>();
        try{
            musicalJPanel = new MusicalJPanel( this.seqwencerJPanel.getSequencer().getReceiver());
        } catch(javax.sound.midi.MidiUnavailableException e1){

            System.out.println("Couldn't get sequencer receiver.");

        }
        jPanel = new javax.swing.JPanel();
        seqwencerJPanel = this.seqwencerJPanel;

        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), javax.swing.BorderFactory.createEtchedBorder()));

        volumeJSlider.setMaximum(127);
        volumeJSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                volumeJSliderStateChanged(evt);
            }
        });

        volumeJButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                volumeJButtonStateChanged(evt);
            }
        });
        volumeJButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                volumeJButtonMouseClicked(evt);
            }
        });

        javax.sound.midi.Instrument[] instrumentArray;

        instrumentArray = this.musicalJPanel.getInstrumentArray();

        for( int  i = 0; i < instrumentArray.length; i++ ){
            this.instrumentJComboBox.addItem( instrumentArray[i].getName() );
        }
        instrumentJComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                instrumentJComboBoxItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout musicalJPanelLayout = new javax.swing.GroupLayout(musicalJPanel);
        musicalJPanel.setLayout(musicalJPanelLayout);
        musicalJPanelLayout.setHorizontalGroup(
            musicalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        musicalJPanelLayout.setVerticalGroup(
            musicalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 219, Short.MAX_VALUE)
        );

        jPanel.setPreferredSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(seqwencerJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(seqwencerJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                    .addComponent(musicalJPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(instrumentJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volumeJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(volumeJSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(volumeJSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(volumeJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(instrumentJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(musicalJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void instrumentJComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_instrumentJComboBoxItemStateChanged
        // TODO add your handling code here:
        if( evt.getStateChange() == ItemEvent.SELECTED ){
            musicalJPanel.setCurrentInstrumentIndex( instrumentJComboBox.getSelectedIndex() );
        }

    }//GEN-LAST:event_instrumentJComboBoxItemStateChanged

    private void volumeJSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_volumeJSliderStateChanged
        // TODO add your handling code here:f
        this.musicalJPanel.setCurrentVolume( this.volumeJSlider.getValue() );
    }//GEN-LAST:event_volumeJSliderStateChanged

    private void volumeJButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_volumeJButtonStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_volumeJButtonStateChanged

    private void volumeJButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volumeJButtonMouseClicked
        // TODO add your handling code here:
        if( this.volumeJSlider.isEnabled() ){
            this.musicalJPanel.setCurrentVolume( 0 );
            this.volumeJSlider.setEnabled( false );
        }
        else{
            this.volumeJSlider.setEnabled(true);
            this.musicalJPanel.setCurrentVolume( this.volumeJSlider.getValue() );
        }
    }//GEN-LAST:event_volumeJButtonMouseClicked

    private void recordingStartSignal(){
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> instrumentJComboBox;
    private javax.swing.JPanel jPanel;
    private jmusic.MusicalJPanel musicalJPanel;
    private jmusic.SeqwencerJPanel seqwencerJPanel;
    private javax.swing.JButton volumeJButton;
    private javax.swing.JSlider volumeJSlider;
    // End of variables declaration//GEN-END:variables
}

