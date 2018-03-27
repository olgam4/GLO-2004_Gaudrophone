package utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Collections;
import java.util.List;

import logique.GaudrophoneController;
import logique.Key;
import logique.shapes.BaseShape;

public class Drawer {

    private final GaudrophoneController controller;
    private Dimension initialDimension;

    public Drawer(GaudrophoneController controller, Dimension initialDimension) {
        this.controller = controller;
        this.initialDimension = initialDimension;
    }

    public void drawKeys(Graphics g) {
        List<Key> keys = controller.getInstrument().getKeys();
        if (keys.isEmpty()) {
            return;
        }
        Collections.reverse(keys);
        for (Key key : keys) {
            BaseShape shape = key.getBaseShape();
            if ("Circle".equals(shape.getName()) && key.getImage() == null) {
                g.setColor(key.getBorder().getColor());
                g.fillOval(key.getPosition().x - (int) ((float) key.getBaseShape().getWidth() / 2), key.getPosition().y - (int) ((float) key.getBaseShape().getHeigth() / 2), key.getBaseShape().getWidth(), key.getBaseShape().getHeigth());
                g.setColor(key.getBackgroundColor());
                g.fillOval(key.getPosition().x - (int) ((float) key.getBaseShape().getWidth() / 2) + key.getBorder().getLeft(), key.getPosition().y - (int) ((float) key.getBaseShape().getHeigth() / 2) + key.getBorder().getTop(), key.getBaseShape().getWidth() - key.getBorder().getRight() - key.getBorder().getLeft(), key.getBaseShape().getHeigth() - key.getBorder().getBottom() - key.getBorder().getTop());
            } else if ("Rectangle".equals(shape.getName()) && key.getImage() == null) {
                g.setColor(key.getBorder().getColor());
                g.fillRect(key.getPosition().x - (int) ((float) key.getBaseShape().getWidth() / 2), key.getPosition().y - (int) ((float) key.getBaseShape().getHeigth() / 2), key.getBaseShape().getWidth(), key.getBaseShape().getHeigth());
                g.setColor(key.getBackgroundColor());
                g.fillRect(key.getPosition().x - (int) ((float) key.getBaseShape().getWidth() / 2) + key.getBorder().getLeft(), key.getPosition().y - (int) ((float) key.getBaseShape().getHeigth() / 2) + key.getBorder().getTop(), key.getBaseShape().getWidth() - key.getBorder().getRight() - key.getBorder().getLeft(), key.getBaseShape().getHeigth() - key.getBorder().getBottom() - key.getBorder().getTop());
            } else if (key.getImage() != null) {
                g.drawImage(key.getImage(), key.getPosition().x - (int) ((float) key.getBaseShape().getWidth() / 2) + key.getBorder().getLeft(), key.getPosition().y - (int) ((float) key.getBaseShape().getHeigth() / 2) + key.getBorder().getTop(), key.getBaseShape().getWidth() - key.getBorder().getRight() - key.getBorder().getLeft(), key.getBaseShape().getHeigth() - key.getBorder().getBottom() - key.getBorder().getTop(), null);
            }
        }
        Collections.reverse(keys);
    }

    public void drawHighlight(Graphics g) {
        if (controller.getGaudrophoneMode() == GaudrophoneController.Modes.EDIT) {
            Key selectedKey = controller.getInstrument().getSelectedKey();
            if (selectedKey != null) {
                g.setColor(Color.WHITE);
                g.drawRect(selectedKey.getPosition().x - (int) ((float) selectedKey.getBaseShape().getWidth() / 2) - 2, selectedKey.getPosition().y - (int) ((float) selectedKey.getBaseShape().getHeigth() / 2) - 2, selectedKey.getBaseShape().getWidth() + 3, selectedKey.getBaseShape().getHeigth() + 3);
            }
        }
    }

    public void drawNames(Graphics g) {
        for (Key key : controller.getInstrumentKeys()) {
            g.setColor(Color.BLACK);
            g.drawString(key.getName(), key.getPosition().x - 5, key.getPosition().y - 15);
        }
    }

    public void drawFreq(Graphics g) {
        for (Key key : controller.getInstrumentKeys()) {
            g.setColor(Color.BLACK);
            g.drawString(key.getFrequency(), key.getPosition().x - 5, key.getPosition().y);
        }
    }

    public void drawNote(Graphics g) {
        for (Key key : controller.getInstrumentKeys()) {
            g.setColor(Color.BLACK);
            g.drawString(key.getNoteName() + key.getOctave(), key.getPosition().x - 5, key.getPosition().y + 15);
        }
    }

    public void drawPlayedNote(Graphics g) {

        List<Key> keys = controller.getInstrument().getKeys();
        for (Key key : keys) {
            if (key.isKeyPressed()) {
                g.setColor(Color.WHITE);
                g.drawRect(key.getPosition().x - (int) ((float) key.getBaseShape().getWidth() / 2) - 2, key.getPosition().y - (int) ((float) key.getBaseShape().getHeigth() / 2) - 2, key.getBaseShape().getWidth() + 3, key.getBaseShape().getHeigth() + 3);

            }
        }
    }

    public void drawFoundKeys(Graphics g) {
        List<Key> keys = controller.getFoundKeys();
        if (keys != null) {
            for (Key key : keys) {
                for (int i = 0; i < 3; i++) {
                    g.setColor(Color.GREEN);
                    g.fillOval(key.getPosition().x - 5, -5 + key.getPosition().y, 10, 10);
                    g.drawRect(key.getPosition().x - (int) ((float) key.getBaseShape().getWidth() / 2) - 2, key.getPosition().y - (int) ((float) key.getBaseShape().getHeigth() / 2) - 2, key.getBaseShape().getWidth() + 3, key.getBaseShape().getHeigth() + 3);
                }
            }
        }
    }

    public void draw(Graphics g) {
        drawKeys(g);
        drawPlayedNote(g);
        if (controller.getInstrument().isShowNames()) {
            drawNames(g);
        }
        if (controller.getInstrument().isShowFreq()) {
            drawFreq(g);
        }
        if (controller.getInstrument().isShowNote()) {
            drawNote(g);
        }
        drawFoundKeys(g);
        drawHighlight(g);
    }

}
