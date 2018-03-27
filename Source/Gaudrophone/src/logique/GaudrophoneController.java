package logique;

import gui.LearnPanel;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import logique.shapes.BaseShape;
import logique.shapes.Circle;
import logique.shapes.Rectangle;
import gui.MainWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;
import logique.search.SearchStrategy;
import logique.search.NameSearchStrategy;
import logique.search.NoteSearchStrategy;
import logique.search.FrequencySearchStrategy;
import logique.search.NoteOctaveSearchStrategy;
import logique.search.OctaveSearchStrategy;

public class GaudrophoneController {

    private Instrument instrument;
    private Modes mode;
    private BaseShape _baseShape;
    private Metronome metronome = new Metronome();
    private Point _point;
    private MainWindow mainWindow;
    public static String imagePath;
    private long timer;
    private int bpm = 1;
    private Training training;
    private Playable currentNotePressed;
    private boolean recording;
    private long initialTime;
    private ArrayList<KeyLooping> pressedKey;
    private LiveLooping[] loops = new LiveLooping[10];
    private SearchStrategy searchStrat;
    private ArrayList<Key> foundKeys = new ArrayList<Key>();
    private Partition partition;

    public Partition getPartition() {
        return this.partition;
    }

    public ArrayList<Key> getFoundKeys() {
        return this.foundKeys;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void addKeyLooping(Key key) {
        KeyLooping keyLooping = new KeyLooping(key, System.currentTimeMillis() - this.initialTime, System.currentTimeMillis());
        pressedKey.add(keyLooping);
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public void setKeyPressed(Key key, Boolean bool) {
        key.setKeyPressed(bool);
    }

    public boolean isRecording() {
        return recording;
    }

    public void setRecording(boolean recording) {
        this.recording = recording;
    }

    public void startTraining() {
        this.training = new Training(this.partition.getPartitionNotes(), this.partition);
    }

    public Training getTraining() {
        return training;
    }

    public void setScore() {
        mainWindow.getLearnPanel().setScore(String.valueOf(this.training.getScore()));
    }

    public void sendSignalToLoop(int i) {
        if (this.recording) {
            if (pressedKey.size() > 0) {
                this.recording = false;

                KeyLooping key = new KeyLooping(System.currentTimeMillis() - this.initialTime);
                this.initialTime = 0;
                pressedKey.add(key);

                LiveLooping loop = new LiveLooping(pressedKey, this);
                this.loops[i] = loop;
                loops[i].start();

            } else {
                this.recording = false;
                this.initialTime = 0;
            }

        } else {
            if (loops[i] != null) {
                loops[i].stop();
                loops[i] = null;

            } else {
                this.recording = true;
                this.initialTime = System.currentTimeMillis();
                this.pressedKey = new ArrayList<>();
            }
        }
    }

    public Key checkKeyClick(Point point) {
        Key key = instrument.checkKeyClick(point);
        return key;
    }

    public Key checkKeyClickToPlay(Point point) {
        Key key = instrument.checkKeyClickToPlay(point);
        return key;
    }

    public void setSelectedKey(Key key) {
        instrument.setSelectedKey(key);
    }

    public Key createKey(String shapeSelected, String color, int heigth, int width, String nameSelected, Point point, long persistanceSelected, int instrumentSelected, int noteMIDI, Border borderCreated, boolean isPlayable, String frequency, String octave, String n, WavSound wave, BufferedImage imageCreated) {

        if (null == shapeSelected) {
            if (wave == null) {
                MidiSound note = new MidiSound(noteMIDI, instrumentSelected, persistanceSelected);
                BaseShape shape = new Circle(point, Color.YELLOW, heigth, width);
                Key key = new Key(point, note, nameSelected, shape, borderCreated, isPlayable, frequency, octave, n, wave, imageCreated);
                instrument.setMinSizeX(false);
                instrument.setMinSizeY(false);
                return key;
            } else {
                BaseShape shape = new Circle(point, Color.YELLOW, heigth, width);
                Key key = new Key(point, wave, nameSelected, shape, borderCreated, isPlayable, frequency, octave, n, wave, imageCreated);
                instrument.setMinSizeX(false);
                instrument.setMinSizeY(false);
                return key;
            }
        } else {
            Color colorSelected;
            switch (color) {
                case "Blue":
                    colorSelected = Color.BLUE;
                    break;
                case "Yellow":
                    colorSelected = Color.YELLOW;
                    break;
                case "Red":
                    colorSelected = Color.RED;
                    break;
                case "Black":
                    colorSelected = Color.BLACK;
                    break;
                case "Pink":
                    colorSelected = Color.PINK;
                    break;
                case "Orange":
                    colorSelected = Color.ORANGE;
                    break;
                default:
                    colorSelected = Color.DARK_GRAY;
            }
            switch (shapeSelected) {
                case "Circle": {

                    if (wave == null) {
                        MidiSound note = new MidiSound(noteMIDI, instrumentSelected, persistanceSelected);
                        BaseShape shape = new Circle(point, colorSelected, heigth, width);
                        Key key = new Key(point, note, nameSelected, shape, borderCreated, isPlayable, frequency, octave, n, wave, imageCreated);
                        instrument.setMinSizeX(false);
                        instrument.setMinSizeY(false);
                        return key;
                    } else {
                        BaseShape shape = new Circle(point, colorSelected, heigth, width);
                        Key key = new Key(point, wave, nameSelected, shape, borderCreated, isPlayable, frequency, octave, n, wave, imageCreated);
                        instrument.setMinSizeX(false);
                        instrument.setMinSizeY(false);
                        return key;
                    }
                }
                case "Rectangle": {
                    if (wave == null) {
                        MidiSound note = new MidiSound(noteMIDI, instrumentSelected, persistanceSelected);
                        BaseShape shape = new Rectangle(point, colorSelected, heigth, width);
                        Key key = new Key(point, note, nameSelected, shape, borderCreated, isPlayable, frequency, octave, n, wave, imageCreated);
                        instrument.setMinSizeX(false);
                        instrument.setMinSizeY(false);
                        return key;
                    } else {
                        BaseShape shape = new Rectangle(point, colorSelected, heigth, width);
                        Key key = new Key(point, wave, nameSelected, shape, borderCreated, isPlayable, frequency, octave, n, wave, imageCreated);
                        instrument.setMinSizeX(false);
                        instrument.setMinSizeY(false);
                        return key;
                    }
                }
                default: {
                    BaseShape shape = new Rectangle(point, colorSelected, heigth, width);
                    Key key = new Key(point, wave, nameSelected, shape, borderCreated, isPlayable, frequency, octave, n, wave, imageCreated);
                    instrument.setMinSizeX(false);
                    instrument.setMinSizeY(false);
                    return key;
                }
            }
        }
    }

    public void deleteKey() {
        instrument.getKeys().remove(instrument.getSelectedKey());
    }

    public void resize(int width, int height) {
        final int ADD_SPACE = 1;
        final int KEEP_PROP = 2;

        if (instrument.resizeMode == ADD_SPACE) {
            instrument.resize(width, height);

        } else if (instrument.resizeMode == KEEP_PROP) {
            instrument.resizeWithProportion(width, height);

        }
    }

    public void setResizeMode(int i) {
        instrument.resizeMode = i;
    }

    public void startKey(Key keyPressed) {
        if (keyPressed != null) {
            currentNotePressed = keyPressed.getNote();
            timer = System.currentTimeMillis();
            if (currentNotePressed != null) {
                currentNotePressed.start();
            }
        }
    }

    public void stopKey(Key keyPressed) {
        Long currentPersistance = System.currentTimeMillis() - timer;
        if (currentNotePressed != null) {
            int delay = (int) (currentNotePressed.getPersistance() - currentPersistance);

            Timer timer = new Timer(delay, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    currentNotePressed.stop();
                }
            });
            timer.setRepeats(false);
            timer.start();
        }
    }

    public void playPartition(int bpm, int inst, boolean audible) {
        this.partition.start(bpm, inst, audible);
    }

    public void importPartition() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Import song");
        fileChooser.setApproveButtonText("Import");

        FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt", "txt");
        fileChooser.setFileFilter(filter);

        int value = fileChooser.showOpenDialog(mainWindow);
        if (value == JFileChooser.APPROVE_OPTION) {
            try {
                String path = fileChooser.getSelectedFile().getAbsolutePath();
                this.partition = new Partition(path);
                final LearnPanel learnPanel = mainWindow.getLearnPanel();
                learnPanel.songTextArea.setText(partition.toString());

                learnPanel.bpmSpinner.setValue(partition.getDefaultBPM());
                learnPanel.total.setText(String.format("%d", partition.getPartitionNotes().size()));

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(mainWindow,
                        "Error while loading file.",
                        "Format error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    public void compareKey(Key keyClicked) {
        this.training.compareKey(keyClicked);
    }

    public enum Shapes {
        CIRCLE("Circle"), RECTANGLE("Rectangle"), SQUARE("Square");

        private String name;

        Shapes(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }

    }

    public enum Modes {
        PLAY, EDIT, LEARN
    }

    public GaudrophoneController() {
        this.instrument = new Instrument("New Instrument");
        this.recording = false;
        this.initialTime = 0;
        this.pressedKey = new ArrayList();
    }

    public void playKey(Key key) {
        if (key != null && key.getNote() != null && key.getIsPlayable()) {
            key.getNote().playOnce();
        }
    }

    public static WavSound importSound() {
        return WavSound.importFromFile();
    }

    public void addKey(Key key, Point point) {
        key.getBaseShape().setPoint(point);
        instrument.addKey(key);
    }

    public void setBPM(int bpm) {
        this.bpm = bpm;

    }

    public double getBPM() {
        return bpm;
    }

    public void startMetronome() {
        metronome.stop();
        metronome.setBPM(bpm);
        metronome.play();
    }

    public void stopMetronome() {
        metronome.stop();
    }

    public void setGaudrophoneMode(int mode) {
        this.mode = Modes.values()[mode];
    }

    public Modes getGaudrophoneMode() {
        return this.mode;
    }

    public void search(String search) {
        this.foundKeys.clear();
        if (search.trim().isEmpty()) {
            return;
        }
        ArrayList<String> searchTerms = new ArrayList<String>(Arrays.asList(search.trim().replaceAll("\\s+", " ").split(" ")));
        this.searchStrat = new NameSearchStrategy();
        searchStrat.searchKeys(searchTerms, instrument).forEach((Key keys) -> {
            this.foundKeys.add(keys);
        });
        this.searchStrat = new NoteSearchStrategy();
        searchStrat.searchKeys(searchTerms, instrument).forEach((Key keys) -> {
            this.foundKeys.add(keys);
        });
        this.searchStrat = new FrequencySearchStrategy();
        searchStrat.searchKeys(searchTerms, instrument).forEach((Key keys) -> {
            this.foundKeys.add(keys);
        });
        this.searchStrat = new OctaveSearchStrategy();
        searchStrat.searchKeys(searchTerms, instrument).forEach((Key keys) -> {
            this.foundKeys.add(keys);
        });
        this.searchStrat = new NoteOctaveSearchStrategy();
        searchStrat.searchKeys(searchTerms, instrument).forEach((Key keys) -> {
            this.foundKeys.add(keys);
        });
    }

    public void setMainWindow(MainWindow window) {
        this.mainWindow = window;
    }

    public MainWindow getMainWindow() {
        return this.mainWindow;
    }

    public void repaint() {
        this.mainWindow.getDrawingPanel().repaint();
    }

    public ArrayList<Key> getInstrumentKeys() {
        return instrument.getKeys();
    }

    public void setKeyColor(Color color, Key key) {
        key.setBackgroundColor(color);
    }

    public Color geKeytColor(Color color, Key key) {
        return key.getBackgroundColor();
    }

    public BaseShape getBaseShape() {
        return _baseShape;
    }

    public Point getPoint() {
        return _point;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public Border createBorder(int top, int right, int bottom, int left, Color color) {
        return new Border(top, right, bottom, left, color);
    }

    public void loadFile() {
        try {
            instrument = Instrument.loadFile();
            resize(mainWindow.getDrawingPanel().getWidth(), mainWindow.getDrawingPanel().getHeight());
        } catch (Exception ex) {

        }
    }

    public void saveFile() {
        instrument.saveFile();
    }

    public void moveKey(String side) {
        Key selectedKey = instrument.getSelectedKey();
        BaseShape shape = selectedKey.getBaseShape();
        int x = shape.getPoint().x;
        int y = shape.getPoint().y;
        switch (side) {
            case "up":
                Point pointUp = new Point(x, y - 5);
                selectedKey.setPosition(pointUp);
                shape.setPoint(pointUp);
                break;
            case "down":
                Point pointDown = new Point(x, y + 5);
                selectedKey.setPosition(pointDown);
                shape.setPoint(pointDown);
                break;
            case "left":
                Point pointLeft = new Point(x - 5, y);
                selectedKey.setPosition(pointLeft);
                shape.setPoint(pointLeft);
                break;
            case "right":
                Point pointRight = new Point(x + 5, y);
                selectedKey.setPosition(pointRight);
                shape.setPoint(pointRight);
                break;
        }
    }

    public void sendTop() {
        instrument.sendTop();
    }

    public void sendBottom() {
        instrument.sendBottom();
    }

    public static BufferedImage loadImage() {
        BufferedImage image = null;

        try {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG files", "png");
            fileChooser.setFileFilter(filter);

            int value = fileChooser.showOpenDialog(null);

            if (value == JFileChooser.APPROVE_OPTION) {
                final File selectedFile = fileChooser.getSelectedFile();
                imagePath = selectedFile.getAbsolutePath();
                image = ImageIO.read(selectedFile);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }

}
