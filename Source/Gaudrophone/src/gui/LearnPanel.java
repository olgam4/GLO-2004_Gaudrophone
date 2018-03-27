package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Timer;
import logique.GaudrophoneController;
import logique.GaudrophoneController.Modes;
import logique.Partition;

public class LearnPanel extends javax.swing.JPanel {

    private GaudrophoneController _controller;
    private int defaultInstrument = 24;
    private Timer timer;
    public Timer SearchTimer;

    public void setController(GaudrophoneController controller) {
        _controller = controller;
    }
    public Modes mode = GaudrophoneController.Modes.LEARN;

    /**
     * Creates new form LearnPanel
     */
    public LearnPanel() {
        initComponents();
        stopSongButton.setEnabled(false);
        this.timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                songSlider.setValue((int) _controller.getPartition().getMicrosecondPosition() / 1000);
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        songStatusPanel = new javax.swing.JPanel();
        stopSongButton = new javax.swing.JButton();
        startSongButton = new javax.swing.JButton();
        songScrollPane = new javax.swing.JScrollPane();
        songTextArea = new javax.swing.JTextArea();
        songSlider = new javax.swing.JSlider();
        jPanel1 = new javax.swing.JPanel();
        songLabel = new javax.swing.JLabel();
        importSongButton = new javax.swing.JButton();
        bpmLabel = new javax.swing.JLabel();
        modeLabel = new javax.swing.JLabel();
        modeComboBox = new javax.swing.JComboBox<>();
        scoreLabel = new javax.swing.JLabel();
        score = new javax.swing.JLabel();
        toneComboBox = new javax.swing.JComboBox<>();
        toneLabel = new javax.swing.JLabel();
        bpmSpinner = new javax.swing.JSpinner();
        SLASH = new javax.swing.JLabel();
        total = new javax.swing.JLabel();

        songStatusPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Title"));
        songStatusPanel.setMaximumSize(new java.awt.Dimension(32767, 200));
        songStatusPanel.setMinimumSize(new java.awt.Dimension(334, 200));

        stopSongButton.setText("\\u26B8");
        stopSongButton.setText("||");
        stopSongButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopSongButtonActionPerformed(evt);
            }
        });

        startSongButton.setText("Start");
        startSongButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startSongButtonActionPerformed(evt);
            }
        });

        songTextArea.setEditable(false);
        songTextArea.setColumns(20);
        songTextArea.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        songTextArea.setRows(5);
        songScrollPane.setViewportView(songTextArea);

        songSlider.setMinorTickSpacing(1);
        songSlider.setSnapToTicks(true);
        songSlider.setToolTipText("");
        songSlider.setValue(0);
        songSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                songSliderStateChanged(evt);
            }
        });
        songSlider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                songSliderMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout songStatusPanelLayout = new javax.swing.GroupLayout(songStatusPanel);
        songStatusPanel.setLayout(songStatusPanelLayout);
        songStatusPanelLayout.setHorizontalGroup(
            songStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(songStatusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(songStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(songScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
                    .addGroup(songStatusPanelLayout.createSequentialGroup()
                        .addComponent(startSongButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stopSongButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(songSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        songStatusPanelLayout.setVerticalGroup(
            songStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(songStatusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(songScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(songStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(songSlider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, songStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(startSongButton)
                        .addComponent(stopSongButton)))
                .addContainerGap())
        );

        jPanel1.setMaximumSize(new java.awt.Dimension(32767, 65));
        jPanel1.setMinimumSize(new java.awt.Dimension(820, 65));

        songLabel.setText("Song :");

        importSongButton.setText("Import");
        importSongButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importSongButtonActionPerformed(evt);
            }
        });

        bpmLabel.setText("BPM :");

        modeLabel.setText("Mode :");

        modeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Auto", "Manual" }));

        scoreLabel.setText("Score :");

        score.setText("0");
        score.setToolTipText("");

        toneComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Guitar", "Piano", "Marimba", "Organ", "Flute" }));
        toneComboBox.setSelectedIndex(0);
        toneComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toneComboBoxActionPerformed(evt);
            }
        });

        toneLabel.setText("Default tone :");

        bpmSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 800, 1));

        SLASH.setText("/");

        total.setText("-");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(songLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(importSongButton)
                .addGap(18, 18, 18)
                .addComponent(bpmLabel)
                .addGap(18, 18, 18)
                .addComponent(bpmSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toneLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toneComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scoreLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(score)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SLASH)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(total)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(songLabel)
                    .addComponent(importSongButton)
                    .addComponent(bpmLabel)
                    .addComponent(modeLabel)
                    .addComponent(modeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scoreLabel)
                    .addComponent(score)
                    .addComponent(toneComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toneLabel)
                    .addComponent(bpmSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SLASH)
                    .addComponent(total)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(songStatusPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(songStatusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public javax.swing.JComboBox getModeComboBox() {
        return modeComboBox;
    }

    public javax.swing.JLabel getScore() {
        return score;
    }

    public void setScore(String s) {
        score.setText(s);
    }

    private void startSongButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startSongButtonActionPerformed
        score.setText("0");
        try {
            if (modeComboBox.getSelectedIndex() == 0) {
                _controller.playPartition((int) bpmSpinner.getValue(), this.defaultInstrument, true);
            } else {
                _controller.playPartition((int) bpmSpinner.getValue(), this.defaultInstrument, false);
            }

            stopSongButton.setEnabled(true);
            if (_controller.getTraining() == null) {
                _controller.startTraining();
            }

            this.SearchTimer = new Timer(1, (ActionEvent ae) -> {
                final Partition partition = _controller.getPartition();
                int index = partition.getNoteIndexFromTick(partition.getCurrentTick());
                List<String> notes = partition.getPartitionNotes().get(index);
                String joinedNotes = String.join(" ", notes);
                _controller.search(joinedNotes);
                _controller.repaint();
            });
            
            this.SearchTimer.start();

            this.timer.start();
            songSlider.setMaximum((int) _controller.getPartition().getMicrosecondLength() / 1000);
        } catch (Exception e) {
            songTextArea.setText("Error while starting.");
        }
    }//GEN-LAST:event_startSongButtonActionPerformed

    private void stopSongButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopSongButtonActionPerformed
        if ("||".equals(stopSongButton.getText())) {
            stopSongButton.setText("\u25B6");
            //this.timerAfficher.stop();
        } else {
            stopSongButton.setText("||");
        }
        _controller.getPartition().pause();
    }//GEN-LAST:event_stopSongButtonActionPerformed

    private void songSliderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_songSliderMouseReleased
        _controller.getPartition().setMicrosecondPosition(songSlider.getValue() * 1000);
    }//GEN-LAST:event_songSliderMouseReleased

    private void songSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_songSliderStateChanged

    }//GEN-LAST:event_songSliderStateChanged

    private void toneComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toneComboBoxActionPerformed
        String instrument = (String) toneComboBox.getSelectedItem();
        switch (instrument) {
            case "Piano":
                this.defaultInstrument = 0;
                break;
            case "Guitar":
                this.defaultInstrument = 24;
                break;
            case "Marimba":
                this.defaultInstrument = 12;
                break;
            case "Organ":
                this.defaultInstrument = 19;
                break;
            case "Flute":
                this.defaultInstrument = 73;
                break;
        }
    }//GEN-LAST:event_toneComboBoxActionPerformed

    private void importSongButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importSongButtonActionPerformed
        _controller.importPartition();
    }//GEN-LAST:event_importSongButtonActionPerformed

    public javax.swing.JSpinner getBPMSpinner() {
        return bpmSpinner;
    }

    public void setBPMSpinner(int bpm) {
        bpmSpinner.setValue(bpm);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel SLASH;
    private javax.swing.JLabel bpmLabel;
    public javax.swing.JSpinner bpmSpinner;
    private javax.swing.JButton importSongButton;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JComboBox<String> modeComboBox;
    private javax.swing.JLabel modeLabel;
    public javax.swing.JLabel score;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JLabel songLabel;
    private javax.swing.JScrollPane songScrollPane;
    public javax.swing.JSlider songSlider;
    private javax.swing.JPanel songStatusPanel;
    public javax.swing.JTextArea songTextArea;
    private javax.swing.JButton startSongButton;
    public javax.swing.JButton stopSongButton;
    public javax.swing.JComboBox<String> toneComboBox;
    private javax.swing.JLabel toneLabel;
    public javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables

}
