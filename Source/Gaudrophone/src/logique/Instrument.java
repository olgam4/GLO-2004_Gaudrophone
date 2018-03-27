package logique;

import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Instrument implements Serializable {

    private String name;
    private Key selectedKey;
    private final ArrayList<Key> keys;
    private boolean minSize;
    private boolean showNames;
    private boolean showFreq;
    private boolean showNote;
    private boolean minSizeX;
    private boolean minSizeY;
    int resizeMode;

    public Instrument(String name) {
        this.keys = new ArrayList<>();
        this.minSize = false;
        this.minSizeX = false;
        this.minSizeX = false;
        this.name = name;
        this.resizeMode = 1;
    }

    public Instrument() {
        keys = new ArrayList<>();
        this.minSize = false;
        this.minSizeX = false;
        this.minSizeX = false;
        this.resizeMode = 1;
    }

    public boolean isMinSizeX() {
        return minSizeX;
    }

    public void setMinSizeX(boolean minSizeX) {
        this.minSizeX = minSizeX;
    }

    public boolean isMinSizeY() {
        return minSizeY;
    }

    public void setMinSizeY(boolean minSizeY) {
        this.minSizeY = minSizeY;
    }

    public boolean isShowNames() {
        return showNames;
    }

    public void setShowNames(boolean showNames) {
        this.showNames = showNames;
    }

    public boolean isShowFreq() {
        return showFreq;
    }

    public void setShowFreq(boolean showFreq) {
        this.showFreq = showFreq;
    }

    public boolean isShowNote() {
        return showNote;
    }

    public void setShowNote(boolean showNote) {
        this.showNote = showNote;
    }

    public boolean isMinSize() {
        return minSize;
    }

    public void setMinSize(boolean minSize) {
        this.minSize = minSize;
    }

    public void addKey(Key key) {
        keys.add(0, key);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Key getSelectedKey() {
        return selectedKey;
    }

    public void setSelectedKey(Key selectedKey) {
        this.selectedKey = selectedKey;
    }

    public ArrayList<Key> getKeys() {
        return keys;
    }

    public Key checkKeyClick(Point point) {
        double maxX = 0;
        double maxY = 0;
        double minX = 0;
        double minY = 0;
        int i = 0;
        for (Key key : this.keys) {
            maxX = ((double) key.getBaseShape().getWidth() / 2) + key.getBaseShape().getPoint().x;
            maxY = ((double) key.getBaseShape().getHeigth() / 2) + key.getBaseShape().getPoint().y;
            minX = key.getBaseShape().getPoint().x - ((double) key.getBaseShape().getWidth() / 2);
            minY = key.getBaseShape().getPoint().y - ((double) key.getBaseShape().getHeigth() / 2);

            i++;

            if (!"Circle".equals(key.getBaseShape().getName())) {
                if (point.x < maxX && point.x > minX && point.y < maxY && point.y > minY) {

                    return key;

                } else {
                }
            } else {

                double x = Math.pow(point.x - key.getBaseShape().getPoint().x, 2) / Math.pow((0.5 * (double) key.getBaseShape().getWidth()), 2);
                double y = Math.pow(point.y - key.getBaseShape().getPoint().y, 2) / Math.pow((0.5 * (double) key.getBaseShape().getHeigth()), 2);
                if (x + y < 1) {

                    return key;
                } else {
                }
            }

        }
        return null;
    }

    public Key checkKeyClickToPlay(Point point) {
        double maxX = 0;
        double maxY = 0;
        double minX = 0;
        double minY = 0;
        int i = 0;
        for (Key key : this.keys) {
            maxX = ((double) key.getBaseShape().getWidth() / 2) + key.getBaseShape().getPoint().x;
            maxY = ((double) key.getBaseShape().getHeigth() / 2) + key.getBaseShape().getPoint().y;
            minX = key.getBaseShape().getPoint().x - ((double) key.getBaseShape().getWidth() / 2);
            minY = key.getBaseShape().getPoint().y - ((double) key.getBaseShape().getHeigth() / 2);
            if (!"Circle".equals(key.getBaseShape().getName())) {
                if (point.x < maxX && point.x > minX && point.y < maxY && point.y > minY) {
                    if (key.getIsPlayable()) {
                        return key;
                    }
                }
            } else {
                double x = Math.pow(point.x - key.getBaseShape().getPoint().x, 2) / Math.pow((0.5 * (double) key.getBaseShape().getWidth()), 2);
                double y = Math.pow(point.y - key.getBaseShape().getPoint().y, 2) / Math.pow((0.5 * (double) key.getBaseShape().getHeigth()), 2);
                if (x + y < 1) {
                    if (key.getIsPlayable()) {
                        return key;
                    }
                }
            }
        }
        return null;
    }

    public void resize(int panelWidth, int panelHeigth) {
        int maxPixel_x = 0;
        int maxPixel_y = 0;

        for (Key key : this.getKeys()) {
            if (!this.isMinSizeX()) {
                key.setRatioX((double) key.getBaseShape().getPoint().x / (double) panelWidth);

                if (key.getRatioX() > 1) {
                    key.setRatioX(1.0);
                }
                if (key.getBaseShape().getPoint().x + key.getBaseShape().getWidth() / 2 > maxPixel_x) {
                    maxPixel_x = key.getBaseShape().getPoint().x + key.getBaseShape().getWidth() / 2;
                }
                key.setShapeRatioX((double) key.getBaseShape().getWidth() / panelWidth);
            }
            if (!this.isMinSizeY()) {
                key.setRatioY((double) key.getBaseShape().getPoint().y / (double) panelHeigth);

                if (key.getRatioY() > 1) {
                    key.setRatioY(1.0);
                }

                if (key.getBaseShape().getPoint().y + key.getBaseShape().getHeigth() / 2 > maxPixel_y) {
                    maxPixel_y = key.getBaseShape().getPoint().y + key.getBaseShape().getHeigth() / 2;
                }
                key.setShapeRatioY((double) key.getBaseShape().getHeigth() / panelHeigth);

            }
        }

        if (panelWidth < maxPixel_x) {
            this.setMinSizeX(true);
            for (Key key : this.getKeys()) {
                if (key.getRatioX() == 0) {
                    key.setRatioX(0.5);
                }
                if (!key.isShapeRatioXSet()) {
                    key.setShapeRatioX((double) key.getBaseShape().getWidth() / panelWidth);
                }
                key.setShapeRatioXSet(true);
            }
        }
        if (panelHeigth < maxPixel_y) {
            this.setMinSizeY(true);
            for (Key key : this.getKeys()) {
                if (key.getRatioY() == 0) {
                    key.setRatioY(0.5);
                }

                if (!key.isShapeRatioYSet()) {
                    key.setShapeRatioY((double) key.getBaseShape().getHeigth() / panelHeigth);
                }
                key.setShapeRatioYSet(true);
            }
        }

        for (Key key : this.getKeys()) {
            Point point = new Point((int) (((double) panelWidth * key.getRatioX())), (int) ((double) panelHeigth * key.getRatioY()));

            if (key.getBaseShape().getPoint().x >= point.x && key.getBaseShape().getPoint().y >= point.y) {
                key.getBaseShape().setPoint(point);
                key.setPosition(point);
            }
        }

        if (this.isMinSizeX() || this.isMinSizeY()) {
            this.redimension(panelWidth, panelHeigth);
        }
    }

    private void redimension(int panelWidth, int panelHeigth) {
        for (Key key : this.getKeys()) {
            int newWidth = (int) (key.getShapeRatioX() * (double) panelWidth);

            if (this.resizeMode == 1) {
                if (newWidth < key.getBaseShape().getWidth()) {
                    key.getBaseShape().setWidth(newWidth);
                    key.setSizeX(newWidth);
                }

                int newHeigth = (int) (key.getShapeRatioY() * (double) panelHeigth);
                if (newHeigth < key.getBaseShape().getHeigth()) {
                    key.getBaseShape().setHeight(newHeigth);
                    key.setSizeY(newHeigth);
                }
            } else if (this.resizeMode == 2) {
                key.getBaseShape().setWidth(newWidth);
                key.setSizeX(newWidth);

                int newHeigth = (int) (key.getShapeRatioY() * (double) panelHeigth);

                key.getBaseShape().setHeight(newHeigth);
                key.setSizeY(newHeigth);

            }
        }

    }

    public void saveFile() {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Save File");
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home") + System.getProperty(("file.separator"))));
            fileChooser.setApproveButtonText("Save");

            FileNameExtensionFilter filter = new FileNameExtensionFilter(".inst", "inst");
            fileChooser.setFileFilter(filter);

            int value = fileChooser.showOpenDialog(null);
            if (value == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                FileOutputStream fileToSave = new FileOutputStream(selectedFile + ".inst");
                try (ObjectOutputStream instrumentToSave = new ObjectOutputStream(fileToSave)) {
                    instrumentToSave.writeObject(this);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Instrument loadFile() {
        Instrument instrument = new Instrument("");
        try {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(".inst", "inst");
            fileChooser.setFileFilter(filter);

            int value = fileChooser.showOpenDialog(null);

            if (value == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();

                FileInputStream fileToLoad = new FileInputStream(selectedFile);
                ObjectInputStream objectToLoad = new ObjectInputStream(fileToLoad);
                instrument = null;
                instrument = (Instrument) objectToLoad.readObject();
                fileToLoad.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instrument;
    }

    public void sendTop() {
        keys.remove(selectedKey);
        keys.add(0, selectedKey);
    }

    public void sendBottom() {
        keys.remove(selectedKey);
        keys.add(selectedKey);
    }

    void resizeWithProportion(int panelWidth, int panelHeigth) {
        for (Key key : this.getKeys()) {

            if (!key.isShapeRatioXSet()) {
                key.setShapeRatioXSet(true);
                key.setRatioX((double) key.getBaseShape().getPoint().x / (double) panelWidth);
                key.setShapeRatioX((double) key.getBaseShape().getWidth() / panelWidth);

                if (key.getRatioX() > 1) {
                    key.setRatioX(1.0);
                }
            }

            if (!key.isShapeRatioYSet()) {
                key.setShapeRatioYSet(true);
                key.setRatioY((double) key.getBaseShape().getPoint().y / (double) panelHeigth);
                key.setShapeRatioY((double) key.getBaseShape().getHeigth() / panelHeigth);

                if (key.getRatioY() > 1) {
                    key.setRatioY(1.0);
                }
            }

        }

        for (Key key : this.getKeys()) {
            Point point = new Point((int) (((double) panelWidth * key.getRatioX())), (int) ((double) panelHeigth * key.getRatioY()));

            key.getBaseShape().setPoint(point);
            key.setPosition(point);

        }
        this.redimension(panelWidth, panelHeigth);
    }

    public Key findKeyByFreq(String freq) {
        for (Key key : keys) {
            if (freq.equals(key.getFrequency())) {
                return key;
            }
        }

        return null;
    }
}
