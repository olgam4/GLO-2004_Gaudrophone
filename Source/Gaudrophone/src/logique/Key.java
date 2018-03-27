package logique;

import java.awt.Point;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import javax.imageio.ImageIO;
import logique.shapes.BaseShape;

public class Key implements Serializable {

    private Border border;
    private float sizeX;
    private float sizeY;
    private Point position;
    private Playable note;
    private BaseShape baseShape;
    private String name;
    private boolean isPlayable;
    private boolean keyPressed;
    private double ratioX;
    private double ratioY;
    private double shapeRatioX;
    private double shapeRatioY;
    private boolean shapeRatioXSet;
    private boolean shapeRatioYSet;
    private String frequency;
    private String noteName;
    private String octave;
    private WavSound WavSound;
    private transient BufferedImage image;
    private String imagePath;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Key(Point point, Playable note, String name, BaseShape baseShape, Border border, boolean isPlayable, String frequency, String octave, String noteName, WavSound wave, BufferedImage imageCreated) {
        this.position = point;
        this.note = note;
        this.name = name;
        this.baseShape = baseShape;
        this.border = border;
        this.isPlayable = isPlayable;
        this.keyPressed = false;
        this.frequency = frequency;
        this.octave = octave;
        this.noteName = noteName;
        this.shapeRatioXSet = false;
        this.shapeRatioYSet = false;
        this.WavSound = wave;
        this.image = imageCreated;
    }

    public WavSound getWavSound() {
        return WavSound;
    }

    public void setWavSound(WavSound WavSound) {
        this.WavSound = WavSound;
    }

    public BufferedImage getImage() {
        if (image == null && imagePath != null) {
            try {
                this.image = ImageIO.read(new File(imagePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getNoteName() {
        return noteName;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }

    public String getOctave() {
        return octave;
    }

    public void setOctave(String octave) {
        this.octave = octave;
    }

    public double getRatioX() {
        return ratioX;
    }

    public void setRatioX(double ratioX) {
        this.ratioX = ratioX;
    }

    public double getRatioY() {
        return ratioY;
    }

    public void setRatioY(double ratioY) {
        this.ratioY = ratioY;
    }

    public double getShapeRatioX() {
        return shapeRatioX;
    }

    public void setShapeRatioX(double shapeRatioX) {
        this.shapeRatioX = shapeRatioX;
    }

    public double getShapeRatioY() {
        return shapeRatioY;
    }

    public void setShapeRatioY(double shapeRatioY) {
        this.shapeRatioY = shapeRatioY;
    }

    public boolean isShapeRatioXSet() {
        return shapeRatioXSet;
    }

    public void setShapeRatioXSet(boolean shapeRatioXSet) {
        this.shapeRatioXSet = shapeRatioXSet;
    }

    public boolean isShapeRatioYSet() {
        return shapeRatioYSet;
    }

    public void setShapeRatioYSet(boolean shapeRatioYSet) {
        this.shapeRatioYSet = shapeRatioYSet;
    }

    public boolean isKeyPressed() {
        return keyPressed;
    }

    public void setKeyPressed(boolean keyPressed) {
        this.keyPressed = keyPressed;
    }

    public boolean getIsPlayable() {
        return isPlayable;
    }

    public void setIsPlayable(boolean isPlayable) {
        this.isPlayable = isPlayable;
    }

    public Border getBorder() {
        return border;
    }

    public void setBorder(Border border) {
        this.border = border;
    }

    public float getSizeX() {
        return sizeX;
    }

    public void setSizeX(float sizeX) {
        this.sizeX = sizeX;
    }

    public float getSizeY() {
        return sizeY;
    }

    public void setSizeY(float sizeY) {
        this.sizeY = sizeY;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Playable getNote() {
        return note;
    }

    public void setNote(Playable note) {
        this.note = note;
    }

    public Color getBackgroundColor() {
        return this.baseShape.getBackgroundColor();
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.baseShape.setBackgroundColor(backgroundColor);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BaseShape getBaseShape() {
        return baseShape;
    }

    public void setBaseShape(BaseShape baseShape) {
        this.baseShape = baseShape;
    }
}
