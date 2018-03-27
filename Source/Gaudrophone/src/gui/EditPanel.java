package gui;

import logique.GaudrophoneController;
import logique.GaudrophoneController.Modes;
import logique.GaudrophoneController.Shapes;
import java.awt.Color;
import logique.Border;
import java.awt.Point;
import java.util.HashMap;
import logique.Key;
import logique.WavSound;
import java.awt.image.BufferedImage;

public class EditPanel extends javax.swing.JPanel {

    public Modes mode = Modes.EDIT;
    private String shapeSelected = "Rectangle";
    private String nameSelected = "keyName";
    private String colorSelected = "Red";
    private String colorBorderSelected = "Red";
    private String noteSelected;
    private int octaveSelected;
    private int heigthSelected = 100;
    private int widthSelected = 100;
    private Point point = new Point(0, 0);
    private int persistanceSelected;
    private int instrumentSelected = 24;
    private int frequencySelected;
    private boolean isBeingCreated;
    private Key keyBeingCreated;
    private boolean isBeingModified;
    private WavSound wavCreated = null;
    private BufferedImage imageCreated = null;

    private final HashMap<String, String> NoteToFreq;
    private final HashMap<String, Integer> NoteToMidi;
    private String imagePath;

    private GaudrophoneController _controller;

    public void setController(GaudrophoneController controller) {
        _controller = controller;
    }

    /**
     * Creates new form EditPanel
     */
    public EditPanel() {
        this.NoteToFreq = new HashMap<>();
        this.NoteToMidi = new HashMap<>();
        initComponents();
        playButton.setEnabled(false);
        deleteButton.setEnabled(false);
        moveDownButton.setEnabled(false);
        moveUpButton.setEnabled(false);
        moveLeftButton.setEnabled(false);
        moveRightButton.setEnabled(false);
        sendTopButton.setEnabled(false);
        sendBottomButton.setEnabled(false);
        modifyButton.setEnabled(false);
        NoteToFreq.put("C0", "8.18");
        NoteToFreq.put("Db0", "8.66");
        NoteToFreq.put("D0", "9.18");
        NoteToFreq.put("Eb0", "9.72");
        NoteToFreq.put("E0", "10.30");
        NoteToFreq.put("F0", "10.91");
        NoteToFreq.put("Gb0", "11.56");
        NoteToFreq.put("G0", "12.25");
        NoteToFreq.put("Ab0", "12.98");
        NoteToFreq.put("A0", "13.75");
        NoteToFreq.put("Bb0", "14.57");
        NoteToFreq.put("B0", "15.43");
        NoteToFreq.put("C1", "16.35");
        NoteToFreq.put("Db1", "17.32");
        NoteToFreq.put("D1", "18.35");
        NoteToFreq.put("Eb1", "19.45");
        NoteToFreq.put("E1", "20.60");
        NoteToFreq.put("F1", "21.83");
        NoteToFreq.put("Gb1", "23.12");
        NoteToFreq.put("G1", "24.50");
        NoteToFreq.put("Ab1", "25.96");
        NoteToFreq.put("A1", "27.50");
        NoteToFreq.put("Bb1", "29.14");
        NoteToFreq.put("B1", "30.87");
        NoteToFreq.put("C2", "32.70");
        NoteToFreq.put("Db2", "34.65");
        NoteToFreq.put("D2", "36.71");
        NoteToFreq.put("Eb2", "38.89");
        NoteToFreq.put("E2", "41.20");
        NoteToFreq.put("F2", "43.65");
        NoteToFreq.put("Gb2", "46.25");
        NoteToFreq.put("G2", "49.00");
        NoteToFreq.put("Ab2", "51.91");
        NoteToFreq.put("A2", "55.00");
        NoteToFreq.put("Bb2", "58.27");
        NoteToFreq.put("B2", "61.74");
        NoteToFreq.put("C3", "65.41");
        NoteToFreq.put("Db3", "69.30");
        NoteToFreq.put("D3", "73.42");
        NoteToFreq.put("Eb3", "77.78");
        NoteToFreq.put("E3", "82.41");
        NoteToFreq.put("F3", "87.31");
        NoteToFreq.put("Gb3", "92.50");
        NoteToFreq.put("G3", "98.00");
        NoteToFreq.put("Ab3", "103.83");
        NoteToFreq.put("A3", "110.00");
        NoteToFreq.put("Bb3", "116.54");
        NoteToFreq.put("B3", "123.47");
        NoteToFreq.put("C4", "130.81");
        NoteToFreq.put("Db4", "138.59");
        NoteToFreq.put("D4", "146.83");
        NoteToFreq.put("Eb4", "155.56");
        NoteToFreq.put("E4", "164.81");
        NoteToFreq.put("F4", "174.61");
        NoteToFreq.put("Gb4", "185.00");
        NoteToFreq.put("G4", "196.00");
        NoteToFreq.put("Ab4", "207.65");
        NoteToFreq.put("A4", "220.00");
        NoteToFreq.put("Bb4", "233.08");
        NoteToFreq.put("B4", "246.94");
        NoteToFreq.put("C5", "261.63");
        NoteToFreq.put("Db5", "277.18");
        NoteToFreq.put("D5", "293.66");
        NoteToFreq.put("Eb5", "311.13");
        NoteToFreq.put("E5", "329.63");
        NoteToFreq.put("F5", "349.23");
        NoteToFreq.put("Gb5", "369.99");
        NoteToFreq.put("G5", "392.00");
        NoteToFreq.put("Ab5", "415.30");
        NoteToFreq.put("A5", "440.00");
        NoteToFreq.put("Bb5", "466.16");
        NoteToFreq.put("B5", "493.88");
        NoteToFreq.put("C6", "523.25");
        NoteToFreq.put("Db6", "554.37");
        NoteToFreq.put("D6", "587.33");
        NoteToFreq.put("Eb6", "622.25");
        NoteToFreq.put("E6", "659.26");
        NoteToFreq.put("F6", "698.46");
        NoteToFreq.put("Gb6", "739.99");
        NoteToFreq.put("G6", "783.99");
        NoteToFreq.put("Ab6", "830.61");
        NoteToFreq.put("A6", "880.00");
        NoteToFreq.put("Bb6", "932.33");
        NoteToFreq.put("B6", "987.77");
        NoteToFreq.put("C7", "1046.50");
        NoteToFreq.put("Db7", "1108.73");
        NoteToFreq.put("D7", "1174.66");
        NoteToFreq.put("Eb7", "1244.51");
        NoteToFreq.put("E7", "1318.51");
        NoteToFreq.put("F7", "1396.91");
        NoteToFreq.put("Gb7", "1479.98");
        NoteToFreq.put("G7", "1567.98");
        NoteToFreq.put("Ab7", "1661.22");
        NoteToFreq.put("A7", "1760.00");
        NoteToFreq.put("Bb7", "1864.66");
        NoteToFreq.put("B7", "1975.53");
        NoteToFreq.put("C8", "2093.00");
        NoteToFreq.put("Db8", "2217.46");
        NoteToFreq.put("D8", "2349.32");
        NoteToFreq.put("Eb8", "2489.02");
        NoteToFreq.put("E8", "2637.02");
        NoteToFreq.put("F8", "2793.83");
        NoteToFreq.put("Gb8", "2959.96");
        NoteToFreq.put("G8", "3135.96");
        NoteToFreq.put("Ab8", "3322.44");
        NoteToFreq.put("A8", "3520.00");
        NoteToFreq.put("Bb8", "3729.31");
        NoteToFreq.put("B8", "3951.07");
        NoteToFreq.put("C9", "4186.01");
        NoteToFreq.put("Db9", "4434.92");
        NoteToFreq.put("D9", "4698.64");
        NoteToFreq.put("Eb9", "4978.03");
        NoteToFreq.put("E9", "5274.04");
        NoteToFreq.put("F9", "5587.65");
        NoteToFreq.put("Gb9", "5919.91");
        NoteToFreq.put("G9", "6271.93");
        NoteToFreq.put("Ab9", "6644.88");
        NoteToFreq.put("A9", "7040.00");
        NoteToFreq.put("Bb9", "7458.62");
        NoteToFreq.put("B9", "7902.13");

        NoteToMidi.put("C0", 0);
        NoteToMidi.put("Db0", 1);
        NoteToMidi.put("D0", 2);
        NoteToMidi.put("Eb0", 3);
        NoteToMidi.put("E0", 4);
        NoteToMidi.put("F0", 5);
        NoteToMidi.put("Gb0", 6);
        NoteToMidi.put("G0", 7);
        NoteToMidi.put("Ab0", 8);
        NoteToMidi.put("A0", 9);
        NoteToMidi.put("Bb0", 10);
        NoteToMidi.put("B0", 11);
        NoteToMidi.put("C1", 12);
        NoteToMidi.put("Db1", 13);
        NoteToMidi.put("D1", 14);
        NoteToMidi.put("Eb1", 15);
        NoteToMidi.put("E1", 16);
        NoteToMidi.put("F1", 17);
        NoteToMidi.put("Gb1", 18);
        NoteToMidi.put("G1", 19);
        NoteToMidi.put("Ab1", 20);
        NoteToMidi.put("A1", 21);
        NoteToMidi.put("Bb1", 22);
        NoteToMidi.put("B1", 23);
        NoteToMidi.put("C2", 24);
        NoteToMidi.put("Db2", 25);
        NoteToMidi.put("D2", 26);
        NoteToMidi.put("Eb2", 27);
        NoteToMidi.put("E2", 28);
        NoteToMidi.put("F2", 29);
        NoteToMidi.put("Gb2", 30);
        NoteToMidi.put("G2", 31);
        NoteToMidi.put("Ab2", 32);
        NoteToMidi.put("A2", 33);
        NoteToMidi.put("Bb2", 34);
        NoteToMidi.put("B2", 35);
        NoteToMidi.put("C3", 36);
        NoteToMidi.put("Db3", 37);
        NoteToMidi.put("D3", 38);
        NoteToMidi.put("Eb3", 39);
        NoteToMidi.put("E3", 40);
        NoteToMidi.put("F3", 41);
        NoteToMidi.put("Gb3", 42);
        NoteToMidi.put("G3", 43);
        NoteToMidi.put("Ab3", 44);
        NoteToMidi.put("A3", 45);
        NoteToMidi.put("Bb3", 46);
        NoteToMidi.put("B3", 47);
        NoteToMidi.put("C4", 48);
        NoteToMidi.put("Db4", 49);
        NoteToMidi.put("D4", 50);
        NoteToMidi.put("Eb4", 51);
        NoteToMidi.put("E4", 52);
        NoteToMidi.put("F4", 53);
        NoteToMidi.put("Gb4", 54);
        NoteToMidi.put("G4", 55);
        NoteToMidi.put("Ab4", 56);
        NoteToMidi.put("A4", 57);
        NoteToMidi.put("Bb4", 58);
        NoteToMidi.put("B4", 59);
        NoteToMidi.put("C5", 60);
        NoteToMidi.put("Db5", 61);
        NoteToMidi.put("D5", 62);
        NoteToMidi.put("Eb5", 63);
        NoteToMidi.put("E5", 64);
        NoteToMidi.put("F5", 65);
        NoteToMidi.put("Gb5", 66);
        NoteToMidi.put("G5", 67);
        NoteToMidi.put("Ab5", 68);
        NoteToMidi.put("A5", 69);
        NoteToMidi.put("Bb5", 70);
        NoteToMidi.put("B5", 71);
        NoteToMidi.put("C6", 72);
        NoteToMidi.put("Db6", 73);
        NoteToMidi.put("D6", 74);
        NoteToMidi.put("Eb6", 75);
        NoteToMidi.put("E6", 76);
        NoteToMidi.put("F6", 77);
        NoteToMidi.put("Gb6", 78);
        NoteToMidi.put("G6", 79);
        NoteToMidi.put("Ab6", 80);
        NoteToMidi.put("A6", 81);
        NoteToMidi.put("Bb6", 82);
        NoteToMidi.put("B6", 83);
        NoteToMidi.put("C7", 84);
        NoteToMidi.put("Db7", 85);
        NoteToMidi.put("D7", 86);
        NoteToMidi.put("Eb7", 87);
        NoteToMidi.put("E7", 88);
        NoteToMidi.put("F7", 89);
        NoteToMidi.put("Gb7", 90);
        NoteToMidi.put("G7", 91);
        NoteToMidi.put("Ab7", 92);
        NoteToMidi.put("A7", 93);
        NoteToMidi.put("Bb7", 94);
        NoteToMidi.put("B7", 95);
        NoteToMidi.put("C8", 96);
        NoteToMidi.put("Db8", 97);
        NoteToMidi.put("D8", 98);
        NoteToMidi.put("Eb8", 99);
        NoteToMidi.put("E8", 100);
        NoteToMidi.put("F8", 101);
        NoteToMidi.put("Gb8", 102);
        NoteToMidi.put("G8", 103);
        NoteToMidi.put("Ab8", 104);
        NoteToMidi.put("A8", 105);
        NoteToMidi.put("Bb8", 106);
        NoteToMidi.put("B8", 107);
        NoteToMidi.put("C9", 108);
        NoteToMidi.put("Db9", 109);
        NoteToMidi.put("D9", 110);
        NoteToMidi.put("Eb9", 111);
        NoteToMidi.put("E9", 112);
        NoteToMidi.put("F9", 113);
        NoteToMidi.put("Gb9", 114);
        NoteToMidi.put("G9", 115);
        NoteToMidi.put("Ab9", 116);
        NoteToMidi.put("A9", 117);
        NoteToMidi.put("Bb9", 118);
        NoteToMidi.put("B9", 119);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        namePanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        shapeLabel = new javax.swing.JLabel();
        shapeComboBox = new javax.swing.JComboBox<>();
        colorLabel = new javax.swing.JLabel();
        colorComboBox = new javax.swing.JComboBox<>();
        xLabel = new javax.swing.JLabel();
        xSpinner = new javax.swing.JSpinner();
        yLabel = new javax.swing.JLabel();
        ySpinner = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        importImageButton = new javax.swing.JButton();
        borderPanel = new javax.swing.JPanel();
        borderColorLabel = new javax.swing.JLabel();
        borderColorComboBox = new javax.swing.JComboBox<>();
        borderLabel1 = new javax.swing.JLabel();
        borderTopSpinner = new javax.swing.JSpinner();
        borderLabel2 = new javax.swing.JLabel();
        borderBottomSpinner = new javax.swing.JSpinner();
        borderLabel3 = new javax.swing.JLabel();
        borderLeftSpinner = new javax.swing.JSpinner();
        borderLabel4 = new javax.swing.JLabel();
        borderRightSpinner = new javax.swing.JSpinner();
        musicPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        playable = new javax.swing.JCheckBox();
        noteLabel = new javax.swing.JLabel();
        noteComboBox = new javax.swing.JComboBox<>();
        octaveLabel = new javax.swing.JLabel();
        octaveComboBox = new javax.swing.JComboBox<>();
        pitchLabel = new javax.swing.JLabel();
        frequencyLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        timeSpinner = new javax.swing.JSpinner();
        toneLabel = new javax.swing.JLabel();
        toneComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        importSoundButton = new javax.swing.JButton();
        keyEditPanel = new javax.swing.JPanel();
        deleteButton = new javax.swing.JButton();
        playButton = new javax.swing.JButton();
        moveLeftButton = new javax.swing.JButton();
        moveRightButton = new javax.swing.JButton();
        moveUpButton = new javax.swing.JButton();
        moveDownButton = new javax.swing.JButton();
        sendTopButton = new javax.swing.JButton();
        sendBottomButton = new javax.swing.JButton();
        createPanel = new javax.swing.JPanel();
        createButton = new javax.swing.JButton();
        modifyButton = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(1050, 500));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        namePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Key"));
        namePanel.setLayout(new javax.swing.BoxLayout(namePanel, javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setLayout(new java.awt.GridLayout(6, 2));

        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel.setText("Name :");
        jPanel1.add(nameLabel);

        nameTextField.setText("keyName");
        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(nameTextField);
        nameTextField.getAccessibleContext().setAccessibleName("nameField");

        shapeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        shapeLabel.setText("Shape :");
        jPanel1.add(shapeLabel);

        String[] shapesList = {"Rectangle", "Circle"};
        shapeComboBox.setModel(new javax.swing.DefaultComboBoxModel(shapesList));
        shapeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shapeComboBoxActionPerformed(evt);
            }
        });
        jPanel1.add(shapeComboBox);

        colorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        colorLabel.setText("Color :");
        jPanel1.add(colorLabel);

        String[] colorsList = {"Red", "Blue", "Yellow", "Orange", "Pink", "Black"};
        colorComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(colorsList));
        colorComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorComboBoxActionPerformed(evt);
            }
        });
        jPanel1.add(colorComboBox);

        xLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        xLabel.setText("Width :");
        jPanel1.add(xLabel);

        xSpinner.setModel(new javax.swing.SpinnerNumberModel(100, 10, null, 1));
        jPanel1.add(xSpinner);

        yLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yLabel.setText("Height :");
        jPanel1.add(yLabel);

        ySpinner.setModel(new javax.swing.SpinnerNumberModel(100, 10, null, 1));
        jPanel1.add(ySpinner);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Image :");
        jPanel1.add(jLabel3);

        importImageButton.setText("Import");
        importImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importImageButtonActionPerformed(evt);
            }
        });
        jPanel1.add(importImageButton);

        namePanel.add(jPanel1);

        add(namePanel);

        borderPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Border"));
        borderPanel.setLayout(new java.awt.GridLayout(5, 2));

        borderColorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        borderColorLabel.setText("Color : ");
        borderPanel.add(borderColorLabel);

        String[] colorsBorderList = {"Red", "Blue", "Yellow", "Orange", "Pink", "Black", "Plus"};
        borderColorComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Red", "Blue", "Yellow", "Orange", "Pink", "Black" }));
        borderColorComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borderColorComboBoxActionPerformed(evt);
            }
        });
        borderPanel.add(borderColorComboBox);

        borderLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        borderLabel1.setText("Top : ");
        borderPanel.add(borderLabel1);

        borderTopSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 3, 1));
        borderPanel.add(borderTopSpinner);

        borderLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        borderLabel2.setText("Bottom : ");
        borderPanel.add(borderLabel2);

        borderBottomSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 3, 1));
        borderPanel.add(borderBottomSpinner);

        borderLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        borderLabel3.setText("Left : ");
        borderPanel.add(borderLabel3);

        borderLeftSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 3, 1));
        borderPanel.add(borderLeftSpinner);

        borderLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        borderLabel4.setText("Right : ");
        borderPanel.add(borderLabel4);

        borderRightSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 3, 1));
        borderPanel.add(borderRightSpinner);

        add(borderPanel);

        musicPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Musicality"));
        musicPanel.setLayout(new java.awt.GridLayout(7, 1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Playable :");
        musicPanel.add(jLabel1);

        playable.setSelected(true);
        playable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playableActionPerformed(evt);
            }
        });
        musicPanel.add(playable);

        noteLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        noteLabel.setText("Note :");
        musicPanel.add(noteLabel);

        noteComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "C", "Db", "D", "Eb", "E", "F", "Gb", "G", "Ab", "A", "Bb", "B" }));
        noteComboBox.setSelectedIndex(9);
        noteComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noteComboBoxActionPerformed(evt);
            }
        });
        musicPanel.add(noteComboBox);

        octaveLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        octaveLabel.setText("Octave :");
        musicPanel.add(octaveLabel);

        octaveComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        octaveComboBox.setSelectedIndex(5);
        octaveComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                octaveComboBoxActionPerformed(evt);
            }
        });
        musicPanel.add(octaveComboBox);

        pitchLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pitchLabel.setText("Frequency :");
        musicPanel.add(pitchLabel);

        frequencyLabel.setText("440");
        frequencyLabel.setToolTipText("");
        musicPanel.add(frequencyLabel);

        timeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeLabel.setText("Time (ms) :");
        musicPanel.add(timeLabel);

        timeSpinner.setModel(new javax.swing.SpinnerNumberModel(500L, 0L, null, 1L));
        musicPanel.add(timeSpinner);

        toneLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        toneLabel.setText("Tone :");
        musicPanel.add(toneLabel);

        toneComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Guitar", "Piano", "Marimba", "Organ", "Flute" }));
        toneComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toneComboBoxActionPerformed(evt);
            }
        });
        musicPanel.add(toneComboBox);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Wav :");
        musicPanel.add(jLabel2);

        importSoundButton.setText("Import");
        importSoundButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importSoundButtonActionPerformed(evt);
            }
        });
        musicPanel.add(importSoundButton);

        add(musicPanel);

        keyEditPanel.setLayout(new java.awt.GridLayout(4, 2));

        deleteButton.setText("Delete Key");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        keyEditPanel.add(deleteButton);

        playButton.setText("Test Key");
        playButton.setToolTipText("");
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });
        keyEditPanel.add(playButton);

        moveLeftButton.setText("Move Left");
        moveLeftButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveLeftButtonActionPerformed(evt);
            }
        });
        keyEditPanel.add(moveLeftButton);

        moveRightButton.setText("Move Right");
        moveRightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveRightButtonActionPerformed(evt);
            }
        });
        keyEditPanel.add(moveRightButton);

        moveUpButton.setText("Move Up");
        moveUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveUpButtonActionPerformed(evt);
            }
        });
        keyEditPanel.add(moveUpButton);

        moveDownButton.setText("Move Down");
        moveDownButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveDownButtonActionPerformed(evt);
            }
        });
        keyEditPanel.add(moveDownButton);

        sendTopButton.setText("Send Top");
        sendTopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendTopButtonActionPerformed(evt);
            }
        });
        keyEditPanel.add(sendTopButton);

        sendBottomButton.setText("Send Bottom");
        sendBottomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendBottomButtonActionPerformed(evt);
            }
        });
        keyEditPanel.add(sendBottomButton);

        add(keyEditPanel);

        createPanel.setLayout(new java.awt.GridLayout(2, 1));

        createButton.setText("Create");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });
        createPanel.add(createButton);

        modifyButton.setText("Modify");
        modifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyButtonActionPerformed(evt);
            }
        });
        createPanel.add(modifyButton);

        add(createPanel);
    }// </editor-fold>//GEN-END:initComponents

    private void noteComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noteComboBoxActionPerformed
        noteSelected = (String) noteComboBox.getSelectedItem();
        frequencyLabel.setText(NoteToFreq.get(getNoteOctave()));
    }//GEN-LAST:event_noteComboBoxActionPerformed

    private void colorComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorComboBoxActionPerformed
        this.colorSelected = (String) colorComboBox.getSelectedItem();


    }//GEN-LAST:event_colorComboBoxActionPerformed

    private void shapeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shapeComboBoxActionPerformed
        shapeSelected = (String) shapeComboBox.getSelectedItem();
    }//GEN-LAST:event_shapeComboBoxActionPerformed

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed

    }//GEN-LAST:event_nameTextFieldActionPerformed

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed

        setIsBeingCreated(true);
        Color color = Color.BLACK;
        switch (colorBorderSelected) {
            case "Blue":
                color = Color.BLUE;
                break;
            case "Yellow":
                color = Color.YELLOW;
                break;
            case "Red":
                color = Color.RED;
                break;
            case "Black":
                color = Color.BLACK;
                break;
            case "Pink":
                color = Color.PINK;
                break;
            case "Orange":
                color = Color.ORANGE;
                break;
        }
        Border borderCreated = _controller.createBorder((int) borderTopSpinner.getValue(), (int) borderRightSpinner.getValue(), (int) borderBottomSpinner.getValue(), (int) borderLeftSpinner.getValue(), color);
        keyBeingCreated = _controller.createKey(shapeSelected, colorSelected, (int) ySpinner.getValue(), (int) xSpinner.getValue(), (String) nameTextField.getText(), point, (long) timeSpinner.getValue(), instrumentSelected, getMidiSelected(), borderCreated, playable.isSelected(), (String) frequencyLabel.getText(), (String) octaveComboBox.getSelectedItem(), (String) noteComboBox.getSelectedItem(), wavCreated, imageCreated);
        wavCreated = null;
        imageCreated = null;

        if (imagePath != null) {
            keyBeingCreated.setImagePath(imagePath);
            imagePath = null;
        }

    }//GEN-LAST:event_createButtonActionPerformed

    private void octaveComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_octaveComboBoxActionPerformed
        octaveSelected = octaveComboBox.getSelectedIndex();
        frequencyLabel.setText(NoteToFreq.get(getNoteOctave()));
    }//GEN-LAST:event_octaveComboBoxActionPerformed

    private void borderColorComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borderColorComboBoxActionPerformed
        this.colorBorderSelected = (String) borderColorComboBox.getSelectedItem();

    }//GEN-LAST:event_borderColorComboBoxActionPerformed

    private void toneComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toneComboBoxActionPerformed
        String instrument = (String) toneComboBox.getSelectedItem();
        switch (instrument) {
            case "Piano":
                instrumentSelected = 0;
                break;
            case "Guitar":
                instrumentSelected = 24;
                break;
            case "Marimba":
                instrumentSelected = 12;
                break;
            case "Organ":
                instrumentSelected = 19;
                break;
            case "Flute":
                instrumentSelected = 73;
                break;
        }
    }//GEN-LAST:event_toneComboBoxActionPerformed

    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed
        if (_controller.getInstrument() != null) {
            Key selectedKey = _controller.getInstrument().getSelectedKey();
            _controller.playKey(selectedKey);
        }
    }//GEN-LAST:event_playButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        _controller.deleteKey();
        getParent().getParent().getParent().repaint();
        _controller.getInstrument().setSelectedKey(null);
        playButton.setEnabled(false);
        deleteButton.setEnabled(false);
        moveDownButton.setEnabled(false);
        moveUpButton.setEnabled(false);
        moveLeftButton.setEnabled(false);
        moveRightButton.setEnabled(false);
        sendBottomButton.setEnabled(false);
        sendTopButton.setEnabled(false);
        modifyButton.setEnabled(false);


    }//GEN-LAST:event_deleteButtonActionPerformed

    private void playableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_playableActionPerformed

    private void moveDownButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveDownButtonActionPerformed
        _controller.moveKey("down");
        getParent().getParent().getParent().repaint();
    }//GEN-LAST:event_moveDownButtonActionPerformed

    private void moveLeftButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveLeftButtonActionPerformed
        _controller.moveKey("left");
        getParent().getParent().getParent().repaint();
    }//GEN-LAST:event_moveLeftButtonActionPerformed

    private void moveRightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveRightButtonActionPerformed
        _controller.moveKey("right");
        getParent().getParent().getParent().repaint();
    }//GEN-LAST:event_moveRightButtonActionPerformed

    private void moveUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveUpButtonActionPerformed
        _controller.moveKey("up");
        getParent().getParent().getParent().repaint();
    }//GEN-LAST:event_moveUpButtonActionPerformed

    private void sendTopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendTopButtonActionPerformed
        _controller.sendTop();
        getParent().getParent().getParent().repaint();
    }//GEN-LAST:event_sendTopButtonActionPerformed

    private void sendBottomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendBottomButtonActionPerformed
        _controller.sendBottom();
        getParent().getParent().getParent().repaint();
    }//GEN-LAST:event_sendBottomButtonActionPerformed

    private void modifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyButtonActionPerformed

        Key selectedKey = _controller.getInstrument().getSelectedKey();
        if (selectedKey == null) {
            return;
        }
        _controller.getInstrumentKeys().remove(selectedKey);
        Color color = Color.BLACK;
        switch ((String) borderColorComboBox.getSelectedItem()) {
            case "Blue":
                color = Color.BLUE;
                break;
            case "Yellow":
                color = Color.YELLOW;
                break;
            case "Red":
                color = Color.RED;
                break;
            case "Black":
                color = Color.BLACK;
                break;
            case "Pink":
                color = Color.PINK;
                break;
            case "Orange":
                color = Color.ORANGE;
                break;
        }
        Border borderCreated = _controller.createBorder((int) borderTopSpinner.getValue(), (int) borderRightSpinner.getValue(), (int) borderBottomSpinner.getValue(), (int) borderLeftSpinner.getValue(), color);
        keyBeingCreated = _controller.createKey((String) shapeComboBox.getSelectedItem(), (String) colorComboBox.getSelectedItem(), (int) ySpinner.getValue(), (int) xSpinner.getValue(), (String) nameTextField.getText(), selectedKey.getPosition(), (long) timeSpinner.getValue(), instrumentSelected, getMidiSelected(), borderCreated, playable.isSelected(), (String) frequencyLabel.getText(), (String) octaveComboBox.getSelectedItem(), (String) noteComboBox.getSelectedItem(), wavCreated, imageCreated);
        _controller.getInstrumentKeys().add(keyBeingCreated);
        getParent().getParent().getParent().repaint();
        wavCreated = null;
        imageCreated = null;
    }//GEN-LAST:event_modifyButtonActionPerformed

    private void importSoundButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importSoundButtonActionPerformed
        wavCreated = GaudrophoneController.importSound();
    }//GEN-LAST:event_importSoundButtonActionPerformed

    private void importImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importImageButtonActionPerformed
        imageCreated = _controller.loadImage();
        imagePath = GaudrophoneController.imagePath;
    }//GEN-LAST:event_importImageButtonActionPerformed

    public javax.swing.JButton getDeleteButton() {
        return deleteButton;
    }

    public String getShapesComboBoxItem() {

        return shapeSelected;
    }

    public String getNameSelected() {
        return nameSelected;
    }

    public String getColorSelected() {
        return colorSelected;
    }

    public boolean getIsBeingCreated() {
        return isBeingCreated;
    }

    public void setIsBeingCreated(boolean isIt) {
        isBeingCreated = isIt;
    }

    public void setIsBeingModified(boolean isIt) {
        isBeingModified = isIt;
    }

    public boolean getIsbeingModified() {
        return isBeingModified;
    }

    public Key getKeyBeingCreated() {
        return keyBeingCreated;
    }

    public javax.swing.JButton getPlayButton() {
        return playButton;
    }

    public javax.swing.JButton getModifyButton() {
        return modifyButton;
    }

    public javax.swing.JButton getMoveUpButton() {
        return moveUpButton;
    }

    public javax.swing.JButton getMoveRightButton() {
        return moveRightButton;
    }

    public javax.swing.JButton getMoveLeftButton() {
        return moveLeftButton;
    }

    public javax.swing.JButton getMoveDownButton() {
        return moveDownButton;
    }

    public javax.swing.JButton getSendTopButton() {
        return sendTopButton;
    }

    public javax.swing.JButton getSendBottomButton() {
        return sendBottomButton;
    }

    public javax.swing.JTextField getNameTextField() {
        return nameTextField;
    }

    public javax.swing.JCheckBox getPlayable() {
        return playable;
    }

    public javax.swing.JComboBox getToneComboBox() {
        return toneComboBox;
    }

    public javax.swing.JSpinner getTimeSpinner() {
        return timeSpinner;
    }

    public String getNoteOctave() {
        return (String) noteComboBox.getSelectedItem() + octaveComboBox.getSelectedItem();
    }

    public int getMidiSelected() {
        return NoteToMidi.get(getNoteOctave());
    }

    public javax.swing.JComboBox getNoteComboBox() {
        return noteComboBox;
    }

    public javax.swing.JLabel getFrequencyLabel() {
        return frequencyLabel;
    }

    public javax.swing.JComboBox getOctaveComboBox() {
        return octaveComboBox;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner borderBottomSpinner;
    private javax.swing.JComboBox<String> borderColorComboBox;
    private javax.swing.JLabel borderColorLabel;
    private javax.swing.JLabel borderLabel1;
    private javax.swing.JLabel borderLabel2;
    private javax.swing.JLabel borderLabel3;
    private javax.swing.JLabel borderLabel4;
    private javax.swing.JSpinner borderLeftSpinner;
    private javax.swing.JPanel borderPanel;
    private javax.swing.JSpinner borderRightSpinner;
    private javax.swing.JSpinner borderTopSpinner;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> colorComboBox;
    private javax.swing.JLabel colorLabel;
    private javax.swing.JButton createButton;
    private javax.swing.JPanel createPanel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel frequencyLabel;
    private javax.swing.JButton importImageButton;
    private javax.swing.JButton importSoundButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel keyEditPanel;
    private javax.swing.JButton modifyButton;
    private javax.swing.JButton moveDownButton;
    private javax.swing.JButton moveLeftButton;
    private javax.swing.JButton moveRightButton;
    private javax.swing.JButton moveUpButton;
    private javax.swing.JPanel musicPanel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JPanel namePanel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JComboBox<String> noteComboBox;
    private javax.swing.JLabel noteLabel;
    private javax.swing.JComboBox<String> octaveComboBox;
    private javax.swing.JLabel octaveLabel;
    private javax.swing.JLabel pitchLabel;
    private javax.swing.JButton playButton;
    private javax.swing.JCheckBox playable;
    private javax.swing.JButton sendBottomButton;
    private javax.swing.JButton sendTopButton;
    private javax.swing.JComboBox<Shapes> shapeComboBox;
    private javax.swing.JLabel shapeLabel;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JSpinner timeSpinner;
    private javax.swing.JComboBox<String> toneComboBox;
    private javax.swing.JLabel toneLabel;
    private javax.swing.JLabel xLabel;
    private javax.swing.JSpinner xSpinner;
    private javax.swing.JLabel yLabel;
    private javax.swing.JSpinner ySpinner;
    // End of variables declaration//GEN-END:variables

    private void updateLabel(String colorName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public javax.swing.JComboBox getShapeComboBox() {
        return shapeComboBox;
    }

    public javax.swing.JComboBox getColorComboBox() {
        return colorComboBox;
    }

    public javax.swing.JSpinner getXSpinner() {
        return xSpinner;
    }

    public javax.swing.JSpinner getYSpinner() {
        return ySpinner;
    }

    public javax.swing.JComboBox getBorderColorComboBox() {
        return borderColorComboBox;
    }

    public javax.swing.JSpinner getBorderTopSpinner() {
        return borderTopSpinner;
    }

    public javax.swing.JSpinner getBorderBottomSpinner() {
        return borderBottomSpinner;
    }

    public javax.swing.JSpinner getBorderRightSpinner() {
        return borderRightSpinner;
    }

    public javax.swing.JSpinner getBorderLeftSpinner() {
        return borderLeftSpinner;
    }
}
