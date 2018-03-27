package gui;

import gaudrophone.Gaudrophone;
import logique.GaudrophoneController;
import java.awt.FlowLayout;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import logique.GaudrophoneController.Modes;
import logique.generator.GeneratorGuitarStrategy;
import logique.generator.GeneratorInstrumentStrategy;
import logique.generator.GeneratorPianoStrategy;
import logique.Key;
import utils.Converter;

public class MainWindow extends javax.swing.JFrame {

    protected final GaudrophoneController controller;
    private GeneratorInstrumentStrategy generator;

    private Boolean displayKeyName = false;
    private Boolean displayNoteOctave = false;
    private Boolean displayFrequency = false;
    private Key keyClicked;
    private long lastKeyTime;

    public GaudrophoneController getController() {
        return controller;
    }

    public Modes mode;

    public MainWindow(GaudrophoneController controller) {
        this.controller = controller;
        this.lastKeyTime = 0;
        initComponents();
        nameLabel.setText(controller.getInstrument().getName());
        drawingPanel.requestFocus();
        ImageIcon img = new ImageIcon(Gaudrophone.class.getResource("resources/sirpat.png"));
        this.setIconImage(img.getImage());
        editPanel.setController(controller);
        learnPanel.setController(controller);
        playPanel.setController(controller);

        searchTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent de) {
                controller.search(searchTextField.getText());
                repaint();
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                controller.search(searchTextField.getText());
                repaint();
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                controller.search(searchTextField.getText());
                repaint();
            }
        });
        instrumentNameTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent de) {
                controller.getInstrument().setName(instrumentNameTextField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                controller.getInstrument().setName(instrumentNameTextField.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                controller.getInstrument().setName(instrumentNameTextField.getText());
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        resizeButtonGroup = new javax.swing.ButtonGroup();
        drawingPanel = new DrawingPanel(this);
        footerPanel = new javax.swing.JPanel(new FlowLayout(FlowLayout.LEFT));
        allPanel = new javax.swing.JPanel();
        metronomePanel = new javax.swing.JPanel();
        bpmLabel = new javax.swing.JLabel();
        bpmSpinner = new javax.swing.JSpinner();
        ActivateMetronome = new javax.swing.JButton();
        StopMetronomeButton = new javax.swing.JButton();
        scalePanel = new javax.swing.JPanel();
        addSpaceRadioButton = new javax.swing.JRadioButton();
        keepProportionRadioButton = new javax.swing.JRadioButton();
        modeTabbedPane = new javax.swing.JTabbedPane();
        playPanel = new gui.PlayPanel();
        editPanel = new gui.EditPanel();
        learnPanel = new gui.LearnPanel();
        instrumentPanel = new javax.swing.JPanel();
        instrumentNamePanel = new javax.swing.JPanel();
        instrumentLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        instrumentNameTextField = new javax.swing.JTextField();
        searchPanel = new javax.swing.JPanel();
        searchLabel = new javax.swing.JLabel();
        searchTextField = new javax.swing.JTextField();
        topMenuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        quitMenuItem = new javax.swing.JMenuItem();
        viewMenuItem = new javax.swing.JMenu();
        keyNameCheckBoxMenuItem = new javax.swing.JCheckBoxMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        noteOctaveCheckBoxMenuItem = new javax.swing.JCheckBoxMenuItem();
        frequencyCheckBoxMenuItem = new javax.swing.JCheckBoxMenuItem();
        generateMenuItem = new javax.swing.JMenu();
        generateGuitarItem = new javax.swing.JMenuItem();
        generatePianoItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        helpItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gaudrophone");
        setMinimumSize(new java.awt.Dimension(1100, 500));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        drawingPanel.setBackground(new java.awt.Color(200, 200, 200));
        drawingPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        drawingPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        drawingPanel.setPreferredSize(new java.awt.Dimension(800, 400));
        drawingPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                drawingPanelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                drawingPanelMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                drawingPanelMouseClicked(evt);
            }
        });
        drawingPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                drawingPanelComponentResized(evt);
            }
        });
        drawingPanel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                drawingPanelKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout drawingPanelLayout = new javax.swing.GroupLayout(drawingPanel);
        drawingPanel.setLayout(drawingPanelLayout);
        drawingPanelLayout.setHorizontalGroup(
            drawingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1152, Short.MAX_VALUE)
        );
        drawingPanelLayout.setVerticalGroup(
            drawingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );

        getContentPane().add(drawingPanel, java.awt.BorderLayout.CENTER);

        footerPanel.setMinimumSize(new java.awt.Dimension(100, 290));
        footerPanel.setPreferredSize(new java.awt.Dimension(100, 290));

        allPanel.setMinimumSize(new java.awt.Dimension(100, 100));
        allPanel.setPreferredSize(new java.awt.Dimension(100, 100));
        allPanel.setLayout(new java.awt.GridLayout(2, 1));

        metronomePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Metronome"));
        metronomePanel.setMaximumSize(new java.awt.Dimension(100, 100));
        metronomePanel.setMinimumSize(new java.awt.Dimension(100, 100));
        metronomePanel.setPreferredSize(new java.awt.Dimension(100, 90));

        bpmLabel.setText("BPM");

        bpmSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 300, 1));
        bpmSpinner.setPreferredSize(new java.awt.Dimension(50, 20));

        ActivateMetronome.setText("\u25B6");
        ActivateMetronome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActivateMetronomeActionPerformed(evt);
            }
        });

        StopMetronomeButton.setText("Stop");
        StopMetronomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopMetronomeButtonActionPerformed(evt);
            }
        });
        StopMetronomeButton.setText("\u25A0");

        javax.swing.GroupLayout metronomePanelLayout = new javax.swing.GroupLayout(metronomePanel);
        metronomePanel.setLayout(metronomePanelLayout);
        metronomePanelLayout.setHorizontalGroup(
            metronomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(metronomePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(metronomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(metronomePanelLayout.createSequentialGroup()
                        .addComponent(bpmLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bpmSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(metronomePanelLayout.createSequentialGroup()
                        .addComponent(ActivateMetronome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(StopMetronomeButton)))
                .addContainerGap())
        );
        metronomePanelLayout.setVerticalGroup(
            metronomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(metronomePanelLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(metronomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bpmLabel)
                    .addComponent(bpmSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(metronomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ActivateMetronome)
                    .addComponent(StopMetronomeButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        allPanel.add(metronomePanel);

        scalePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Scale"));
        scalePanel.setMaximumSize(new java.awt.Dimension(100, 999999));
        scalePanel.setMinimumSize(new java.awt.Dimension(100, 90));
        scalePanel.setPreferredSize(new java.awt.Dimension(100, 90));

        resizeButtonGroup.add(addSpaceRadioButton);
        addSpaceRadioButton.setSelected(true);
        addSpaceRadioButton.setText("Add space");
        addSpaceRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSpaceRadioButtonActionPerformed(evt);
            }
        });

        resizeButtonGroup.add(keepProportionRadioButton);
        keepProportionRadioButton.setText("Keep proportion");
        keepProportionRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keepProportionRadioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout scalePanelLayout = new javax.swing.GroupLayout(scalePanel);
        scalePanel.setLayout(scalePanelLayout);
        scalePanelLayout.setHorizontalGroup(
            scalePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scalePanelLayout.createSequentialGroup()
                .addGroup(scalePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addSpaceRadioButton)
                    .addComponent(keepProportionRadioButton))
                .addContainerGap())
        );
        scalePanelLayout.setVerticalGroup(
            scalePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scalePanelLayout.createSequentialGroup()
                .addComponent(addSpaceRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(keepProportionRadioButton)
                .addContainerGap())
        );

        allPanel.add(scalePanel);

        modeTabbedPane.setMinimumSize(new java.awt.Dimension(825, 273));
        modeTabbedPane.setName(""); // NOI18N
        modeTabbedPane.setPreferredSize(new java.awt.Dimension(930, 600));
        modeTabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                modeTabbedPaneStateChanged(evt);
            }
        });
        modeTabbedPane.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                modeTabbedPaneKeyPressed(evt);
            }
        });

        playPanel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                playPanelKeyPressed(evt);
            }
        });
        modeTabbedPane.addTab("Play", playPanel);

        editPanel.setPreferredSize(null);
        editPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                editPanelMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editPanelMouseClicked(evt);
            }
        });
        modeTabbedPane.addTab("Edit", editPanel);

        learnPanel.setMinimumSize(new java.awt.Dimension(832, 220));
        modeTabbedPane.addTab("Learn", learnPanel);

        modeTabbedPane.setSelectedIndex(1);

        javax.swing.GroupLayout footerPanelLayout = new javax.swing.GroupLayout(footerPanel);
        footerPanel.setLayout(footerPanelLayout);
        footerPanelLayout.setHorizontalGroup(
            footerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(allPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modeTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1001, Short.MAX_VALUE)
                .addContainerGap())
        );
        footerPanelLayout.setVerticalGroup(
            footerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(allPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(modeTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        modeTabbedPane.getAccessibleContext().setAccessibleName("");

        getContentPane().add(footerPanel, java.awt.BorderLayout.SOUTH);

        instrumentPanel.setLayout(new java.awt.BorderLayout());

        instrumentLabel.setText("Instrument Name :");
        instrumentNamePanel.add(instrumentLabel);

        nameLabel.setText("jLabel1");
        instrumentNamePanel.add(nameLabel);
        nameLabel.getAccessibleContext().setAccessibleName("nameLabel");

        instrumentNameTextField.setText("New Instrument");
        instrumentNameTextField.setPreferredSize(new java.awt.Dimension(200, 24));
        instrumentNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instrumentNameTextFieldActionPerformed(evt);
            }
        });
        instrumentNamePanel.add(instrumentNameTextField);

        instrumentPanel.add(instrumentNamePanel, java.awt.BorderLayout.LINE_START);

        searchLabel.setText("Search Notes :");
        searchPanel.add(searchLabel);

        searchTextField.setPreferredSize(new java.awt.Dimension(200, 24));
        searchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextFieldActionPerformed(evt);
            }
        });
        searchTextField.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                searchTextFieldPropertyChange(evt);
            }
        });
        searchPanel.add(searchTextField);

        instrumentPanel.add(searchPanel, java.awt.BorderLayout.EAST);

        getContentPane().add(instrumentPanel, java.awt.BorderLayout.NORTH);

        fileMenu.setText("File");

        openMenuItem.setText("Open Instrument");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);

        saveMenuItem.setText("Save Instrument");
        saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveMenuItem);

        quitMenuItem.setText("Quit");
        quitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(quitMenuItem);

        topMenuBar.add(fileMenu);

        viewMenuItem.setText("View");

        keyNameCheckBoxMenuItem.setText("Key Name");
        keyNameCheckBoxMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyNameCheckBoxMenuItemActionPerformed(evt);
            }
        });
        viewMenuItem.add(keyNameCheckBoxMenuItem);
        viewMenuItem.add(jSeparator1);

        noteOctaveCheckBoxMenuItem.setText("Note and Octave");
        noteOctaveCheckBoxMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noteOctaveCheckBoxMenuItemActionPerformed(evt);
            }
        });
        viewMenuItem.add(noteOctaveCheckBoxMenuItem);

        frequencyCheckBoxMenuItem.setText("Note Frequence");
        frequencyCheckBoxMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frequencyCheckBoxMenuItemActionPerformed(evt);
            }
        });
        viewMenuItem.add(frequencyCheckBoxMenuItem);

        topMenuBar.add(viewMenuItem);

        generateMenuItem.setText("Generate");

        generateGuitarItem.setText("Guitar");
        generateGuitarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateGuitarItemActionPerformed(evt);
            }
        });
        generateMenuItem.add(generateGuitarItem);

        generatePianoItem.setText("Piano");
        generatePianoItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generatePianoItemActionPerformed(evt);
            }
        });
        generateMenuItem.add(generatePianoItem);

        topMenuBar.add(generateMenuItem);

        helpMenu.setText("Help");

        helpItem.setText("Help");
        helpItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpItemActionPerformed(evt);
            }
        });
        helpMenu.add(helpItem);

        topMenuBar.add(helpMenu);

        setJMenuBar(topMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void quitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_quitMenuItemActionPerformed

    private void drawingPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drawingPanelMousePressed
        if (controller.getGaudrophoneMode() == GaudrophoneController.Modes.PLAY) {
            keyClicked = controller.checkKeyClickToPlay(evt.getPoint());
            // System.out.println("drawingPanelMousePressed");
            if (keyClicked != null) {
                keyClicked.setKeyPressed(true);
                drawingPanel.repaint();
                controller.startKey(keyClicked);
                if (controller.isRecording()) {
                    this.lastKeyTime = System.currentTimeMillis();
                }
            }
        }
    }//GEN-LAST:event_drawingPanelMousePressed

    private void drawingPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drawingPanelMouseClicked
        drawingPanel.requestFocus();
        Point mousePoint = evt.getPoint();

        drawingPanel.repaint();

        if (controller.getGaudrophoneMode() == GaudrophoneController.Modes.LEARN) {
            if (learnPanel.getModeComboBox().getSelectedIndex() == 0) {
                //MODE AUTO
            } else {
                if (controller.getTraining() != null) {
                    keyClicked = controller.checkKeyClickToPlay(evt.getPoint());
                    if (keyClicked != null) {
                        keyClicked.setKeyPressed(true);
                        drawingPanel.repaint();
                        controller.startKey(keyClicked);
                        controller.compareKey(keyClicked);

                        keyClicked.setKeyPressed(false);
                        learnPanel.score.setText(String.format("%d", controller.getTraining().getScore()));
                        drawingPanel.repaint();
                    }
                }
            }
        }

        if (controller.getGaudrophoneMode() == GaudrophoneController.Modes.EDIT) {

            if (editPanel.getIsBeingCreated()) {
                editPanel.getKeyBeingCreated().setPosition(mousePoint);
                controller.addKey(editPanel.getKeyBeingCreated(), mousePoint);
                editPanel.setIsBeingCreated(false);
            }

            Key keyClicked = controller.checkKeyClick(mousePoint);
            controller.setSelectedKey(keyClicked);
            if (controller.getInstrument().getSelectedKey() != null) {
                editPanel.getPlayButton().setEnabled(true);
                editPanel.getDeleteButton().setEnabled(true);
                editPanel.getMoveDownButton().setEnabled(true);
                editPanel.getMoveUpButton().setEnabled(true);
                editPanel.getMoveLeftButton().setEnabled(true);
                editPanel.getMoveRightButton().setEnabled(true);
                editPanel.getSendTopButton().setEnabled(true);
                editPanel.getSendBottomButton().setEnabled(true);
                editPanel.getModifyButton().setEnabled(true);
                editPanel.getNameTextField().setText(keyClicked.getName());
                editPanel.getShapeComboBox().setSelectedItem(keyClicked.getBaseShape().getName());
                editPanel.getColorComboBox().setSelectedItem(keyClicked.getBaseShape().getBackgroundColor().toString());
                editPanel.getXSpinner().setValue(keyClicked.getBaseShape().getWidth());
                editPanel.getYSpinner().setValue(keyClicked.getBaseShape().getHeigth());
                editPanel.getBorderColorComboBox().setSelectedItem(keyClicked.getBorder().getColor());
                editPanel.getBorderTopSpinner().setValue(keyClicked.getBorder().getTop());
                editPanel.getBorderBottomSpinner().setValue(keyClicked.getBorder().getBottom());
                editPanel.getBorderLeftSpinner().setValue(keyClicked.getBorder().getLeft());
                editPanel.getBorderRightSpinner().setValue(keyClicked.getBorder().getRight());
                editPanel.getPlayable().setSelected(keyClicked.getIsPlayable());
                editPanel.getToneComboBox().setSelectedItem(keyClicked.getNote().getInstrumentName());
                editPanel.getTimeSpinner().setValue(keyClicked.getNote().getPersistance());
                editPanel.getFrequencyLabel().setText(keyClicked.getFrequency());
                editPanel.getNoteComboBox().setSelectedItem(keyClicked.getNoteName());
                editPanel.getOctaveComboBox().setSelectedItem(keyClicked.getOctave());
            } else {
                editPanel.getPlayButton().setEnabled(false);
                editPanel.getDeleteButton().setEnabled(false);
                editPanel.getMoveDownButton().setEnabled(false);
                editPanel.getMoveUpButton().setEnabled(false);
                editPanel.getMoveLeftButton().setEnabled(false);
                editPanel.getMoveRightButton().setEnabled(false);
                editPanel.getSendTopButton().setEnabled(false);
                editPanel.getSendBottomButton().setEnabled(false);
                editPanel.getModifyButton().setEnabled(false);
            }
            drawingPanel.repaint();
        }

    }//GEN-LAST:event_drawingPanelMouseClicked

    private void modeTabbedPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_modeTabbedPaneStateChanged
        if (learnPanel != null && learnPanel.SearchTimer != null && learnPanel.SearchTimer.isRunning()) {
            learnPanel.SearchTimer.stop();
        }

        int selectedTab = this.modeTabbedPane.getSelectedIndex();
        controller.setGaudrophoneMode(selectedTab);
        controller.setSelectedKey(null);
        editPanel.getPlayButton().setEnabled(false);
        editPanel.getDeleteButton().setEnabled(false);
        editPanel.getMoveDownButton().setEnabled(false);
        editPanel.getMoveUpButton().setEnabled(false);
        editPanel.getMoveLeftButton().setEnabled(false);
        editPanel.getMoveRightButton().setEnabled(false);
        editPanel.getSendTopButton().setEnabled(false);
        editPanel.getSendBottomButton().setEnabled(false);
        editPanel.getModifyButton().setEnabled(false);
        drawingPanel.repaint();

        if (selectedTab == 1) {
            generateMenuItem.setEnabled(true);
            nameLabel.setVisible(false);
            instrumentNameTextField.setVisible(true);
        } else {
            generateMenuItem.setEnabled(false);
            instrumentNameTextField.setVisible(false);
            nameLabel.setText(controller.getInstrument().getName());
            nameLabel.setVisible(true);
        }
    }//GEN-LAST:event_modeTabbedPaneStateChanged

    private void generateGuitarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateGuitarItemActionPerformed
        this.generator = new GeneratorGuitarStrategy();
        controller.setInstrument(generator.generateInstrument());
        instrumentNameTextField.setText(controller.getInstrument().getName());
        drawingPanel.repaint();
    }//GEN-LAST:event_generateGuitarItemActionPerformed

    private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuItemActionPerformed
        controller.saveFile();
    }//GEN-LAST:event_saveMenuItemActionPerformed

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        try {
            controller.loadFile();
            nameLabel.setText(controller.getInstrument().getName());
            instrumentNameTextField.setText(controller.getInstrument().getName());
            drawingPanel.repaint();
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void generatePianoItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generatePianoItemActionPerformed
        this.generator = new GeneratorPianoStrategy();
        controller.setInstrument(generator.generateInstrument());
        instrumentNameTextField.setText(controller.getInstrument().getName());
        drawingPanel.repaint();
    }//GEN-LAST:event_generatePianoItemActionPerformed

    private void helpItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpItemActionPerformed

        JDialog d1 = new JDialog(this, "Help Page", true);
        javax.swing.JLabel j1 = new javax.swing.JLabel();
        javax.swing.JTextPane jtp1 = new javax.swing.JTextPane();
        j1.setText("<html> <font size = +1>Bienvenue sur le Gaudrophone de GLOrious.</font>"
                + "<br/>"
                + "<br/>"
                + "<font size = +1>Métronome</font>"
                + "<br/>"
                + "Le métronome permet de jouer un son avec une pulsation par minute précise."
                + "<br/>"
                + "<br/>"
                + "<font size = +1> Mode Play</font>"
                + "<br/>"
                + "Dans ce mode, il est possible de jouer d'un instrument généré ou d'un instrument créé. Il suffit de cliquer sur une touche."
                + "Il est également possible de faire du live Looping. Il suffit de cliquer sur une pédale, jouer certaines notes, et recliquer sur la pédale. Le live Looping partira à ce moment."
                + "Quand on désire arrêter la séquence, il suffit de recliquer sur la même pédale."
                + "<br/>"
                + "<br/>"
                + "<font size = +1>Mode Edit</font>"
                + "<br/>"
                + "Ce mode permet de créer un instrument. On peut créer des touches avec différentes formes,couleurs,bordures,fréquence et bien d'autres. On peut également modifier une touche déjà créée.On peut également associer un fichier wav à une touche."
                + "<br/>"
                + "<br/>"
                + "<font size = +1> Mode Learn</font>"
                + "<br/>"
                + "Ce mode permet d'apprendre une chanson et d'en jouer une. On peut également arrêter et mettre en pause une chanson."
                + "<br/>"
                + "<br/>"
                + "<font size = +1>Sauvegarde d'un instrument</font>"
                + "<br/>"
                + "Il est possible de sauvegarder un instrument créé et de l'importer également.</html>");
        j1.setHorizontalAlignment(JLabel.CENTER);
        jtp1.getSelectedText();

        d1.setSize(500, 500);
        d1.add(j1);
        j1.setAlignmentX(500);
        d1.setVisible(true);

    }//GEN-LAST:event_helpItemActionPerformed

    private void drawingPanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drawingPanelMouseReleased
        if (controller.getGaudrophoneMode() == GaudrophoneController.Modes.PLAY) {
            Key keyClicked = controller.checkKeyClickToPlay(evt.getPoint());
            if (keyClicked != null) {
                keyClicked.setKeyPressed(false);
                drawingPanel.repaint();
                controller.stopKey(keyClicked);
                if (controller.isRecording()) {
                    if (this.lastKeyTime + keyClicked.getNote().getPersistance() < System.currentTimeMillis()) {
                        //Key keyLengthModified = keyClicked;
                        //keyLengthModified.getNote().setPersistance(System.currentTimeMillis() - this.lastKeyTime);
                        //controller.addKeyLooping(keyLengthModified);
                        keyClicked.getNote().setPersistance(System.currentTimeMillis() - this.lastKeyTime);
                        controller.addKeyLooping(keyClicked);
                    } else {
                        controller.addKeyLooping(keyClicked);
                    }
                }
            }
        }
    }//GEN-LAST:event_drawingPanelMouseReleased

    private void editPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editPanelMouseClicked
        // TODO
    }//GEN-LAST:event_editPanelMouseClicked

    private void editPanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editPanelMouseReleased
        //drawingPanel.repaint();
    }//GEN-LAST:event_editPanelMouseReleased

    private void drawingPanelComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_drawingPanelComponentResized
        controller.resize(drawingPanel.getWidth(), drawingPanel.getHeight());
        drawingPanel.repaint();

    }//GEN-LAST:event_drawingPanelComponentResized

    private void keyNameCheckBoxMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyNameCheckBoxMenuItemActionPerformed
        this.displayKeyName = this.keyNameCheckBoxMenuItem.isSelected();
        controller.getInstrument().setShowNames(keyNameCheckBoxMenuItem.isSelected());
        drawingPanel.repaint();
    }//GEN-LAST:event_keyNameCheckBoxMenuItemActionPerformed

    private void noteOctaveCheckBoxMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noteOctaveCheckBoxMenuItemActionPerformed
        this.displayNoteOctave = this.noteOctaveCheckBoxMenuItem.isSelected();
        controller.getInstrument().setShowNote(noteOctaveCheckBoxMenuItem.isSelected());
        drawingPanel.repaint();
    }//GEN-LAST:event_noteOctaveCheckBoxMenuItemActionPerformed

    private void frequencyCheckBoxMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_frequencyCheckBoxMenuItemActionPerformed
        this.displayFrequency = this.frequencyCheckBoxMenuItem.isSelected();
        controller.getInstrument().setShowFreq(frequencyCheckBoxMenuItem.isSelected());
        drawingPanel.repaint();
    }//GEN-LAST:event_frequencyCheckBoxMenuItemActionPerformed

    private void instrumentNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instrumentNameTextFieldActionPerformed
        controller.getInstrument().setName(instrumentNameTextField.getText());
    }//GEN-LAST:event_instrumentNameTextFieldActionPerformed

    private void ActivateMetronomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActivateMetronomeActionPerformed
        int bpmValue = (Integer) (bpmSpinner.getValue());
        controller.setBPM(bpmValue);
        controller.startMetronome();

    }//GEN-LAST:event_ActivateMetronomeActionPerformed

    private void StopMetronomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopMetronomeButtonActionPerformed
        controller.stopMetronome();
    }//GEN-LAST:event_StopMetronomeButtonActionPerformed

    private void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextFieldActionPerformed
        controller.search(searchTextField.getText());
        drawingPanel.repaint();
    }//GEN-LAST:event_searchTextFieldActionPerformed

    private void searchTextFieldPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_searchTextFieldPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextFieldPropertyChange

    private void keepProportionRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keepProportionRadioButtonActionPerformed
        controller.setResizeMode(2);
    }//GEN-LAST:event_keepProportionRadioButtonActionPerformed

    private void addSpaceRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSpaceRadioButtonActionPerformed
        controller.setResizeMode(1);
    }//GEN-LAST:event_addSpaceRadioButtonActionPerformed

    private void playPanelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_playPanelKeyPressed

    }//GEN-LAST:event_playPanelKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

    }//GEN-LAST:event_formKeyPressed

    private void modeTabbedPaneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_modeTabbedPaneKeyPressed

    }//GEN-LAST:event_modeTabbedPaneKeyPressed

    private void drawingPanelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_drawingPanelKeyPressed
        if ((int) evt.getKeyChar() > 57 || (int) evt.getKeyChar() < 48) {
            return;
        }
        controller.sendSignalToLoop((int) evt.getKeyChar() % 48);
        switch ((int) evt.getKeyChar() - 48) {
            case 0:
                playPanel.updateColor(0, playPanel.getButton0());
                break;
            case 1:
                playPanel.updateColor(1, playPanel.getButton1());
                break;
            case 2:
                playPanel.updateColor(2, playPanel.getButton2());
                break;
            case 3:
                playPanel.updateColor(3, playPanel.getButton3());
                break;
            case 4:
                playPanel.updateColor(4, playPanel.getButton4());
                break;
            case 5:
                playPanel.updateColor(5, playPanel.getButton5());
                break;
            case 6:
                playPanel.updateColor(6, playPanel.getButton6());
                break;
            case 7:
                playPanel.updateColor(7, playPanel.getButton7());
                break;
            case 8:
                playPanel.updateColor(8, playPanel.getButton8());
                break;
            case 9:
                playPanel.updateColor(9, playPanel.getButton9());
                break;
        }

    }//GEN-LAST:event_drawingPanelKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ActivateMetronome;
    private javax.swing.JButton StopMetronomeButton;
    private javax.swing.JRadioButton addSpaceRadioButton;
    private javax.swing.JPanel allPanel;
    private javax.swing.JLabel bpmLabel;
    private javax.swing.JSpinner bpmSpinner;
    private javax.swing.JPanel drawingPanel;
    private gui.EditPanel editPanel;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JPanel footerPanel;
    private javax.swing.JCheckBoxMenuItem frequencyCheckBoxMenuItem;
    private javax.swing.JMenuItem generateGuitarItem;
    private javax.swing.JMenu generateMenuItem;
    private javax.swing.JMenuItem generatePianoItem;
    private javax.swing.JMenuItem helpItem;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel instrumentLabel;
    private javax.swing.JPanel instrumentNamePanel;
    private javax.swing.JTextField instrumentNameTextField;
    private javax.swing.JPanel instrumentPanel;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JRadioButton keepProportionRadioButton;
    private javax.swing.JCheckBoxMenuItem keyNameCheckBoxMenuItem;
    private gui.LearnPanel learnPanel;
    private javax.swing.JPanel metronomePanel;
    private javax.swing.JTabbedPane modeTabbedPane;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JCheckBoxMenuItem noteOctaveCheckBoxMenuItem;
    private javax.swing.JMenuItem openMenuItem;
    private gui.PlayPanel playPanel;
    private javax.swing.JMenuItem quitMenuItem;
    private javax.swing.ButtonGroup resizeButtonGroup;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JPanel scalePanel;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JMenuBar topMenuBar;
    private javax.swing.JMenu viewMenuItem;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JPanel getDrawingPanel() {
        return drawingPanel;
    }

    public LearnPanel getLearnPanel() {
        return learnPanel;
    }

}
