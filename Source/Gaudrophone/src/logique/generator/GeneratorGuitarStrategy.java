package logique.generator;

import java.awt.Color;
import java.awt.Point;

import logique.MidiSound;
import logique.Instrument;
import logique.Key;
import logique.Border;
import logique.shapes.Rectangle;
import utils.Converter;
import utils.Triplet;

public class GeneratorGuitarStrategy implements GeneratorInstrumentStrategy {

    @Override
    public Instrument generateInstrument() {
        int[][] midiNumber = new int[][]{
            {64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76},
            {59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71},
            {55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67},
            {50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62},
            {45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57},
            {40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52}
        };
        Instrument guitar = new Instrument("guitar");
        for (int j = 0; j < 13; j++) {
            for (int k = 0; k < 6; k++) {
                Border border = new Border(2, 2, 2, 2, Color.BLACK);
                Point point = new Point(j * 70 + 36, k * 50 + 26);
                int currentMidiNumber = midiNumber[k][j];
                MidiSound note = new MidiSound(currentMidiNumber, 24, 500);
                Triplet triplet = Converter.MIDI_TO_NOTE.get(currentMidiNumber);
                if (j == 0) {
                    Rectangle shape = new Rectangle(point, Color.LIGHT_GRAY, 50, 70);
                    Key key = new Key(point, note, "", shape, border, true, triplet.getFrequency(), triplet.getOctave(), triplet.getNoteName(), null, null);
                    guitar.addKey(key);
                } else {
                    Rectangle shape = new Rectangle(point, new Color(210, 105, 30), 50, 70);
                    Key key = new Key(point, note, "", shape, border, true, triplet.getFrequency(), triplet.getOctave(), triplet.getNoteName(), null, null);
                    guitar.addKey(key);
                }
            }
        }
        for (int m = 0; m < 6; m++) {
            Border border = new Border(0, 0, 0, 0, Color.BLACK);
            Point point = new Point((13 * 70 / 2), m * 50 + 26);
            Key key = new Key(point, new MidiSound(10, 10, 10), "", new Rectangle(point, Color.GRAY, m + 2, 70 * 13), border, false, "", "", "", null, null);
            guitar.addKey(key);
        }
        return guitar;
    }

}
