package logique.generator;

import java.awt.Color;
import java.awt.Point;
import logique.Border;
import logique.Instrument;
import logique.Key;
import logique.MidiSound;
import logique.shapes.Rectangle;
import utils.Converter;
import utils.Triplet;

public class GeneratorPianoStrategy implements GeneratorInstrumentStrategy {

    @Override
    public Instrument generateInstrument() {
        int[] whiteMidiNumber = {21, 23, 24, 26, 28, 29, 31, 33, 35, 36, 38, 40, 41,
            43, 45, 47, 48, 50, 52, 53, 55, 57, 59, 60, 62, 64, 65, 67, 69, 71,
            72, 74, 76, 77, 79, 81, 83, 84, 86, 88, 89, 91, 93, 95, 96, 98, 100,
            101, 103, 105, 107, 108};
        int[] blackMidiNumber = {22, 25, 27, 30, 32, 34, 37, 39, 42, 44, 46, 49,
            51, 54, 56, 58, 61, 63, 66, 68, 70, 73, 75, 78, 80, 82, 85, 87, 90,
            92, 94, 97, 99, 102, 104, 106};

        int currentMidiNumber = 0;
        Instrument piano = new Instrument("piano");

        Border border = new Border(2, 2, 2, 2, Color.BLACK);

        for (int i = 0; i < whiteMidiNumber.length; i++) {
            currentMidiNumber = whiteMidiNumber[i];
            MidiSound note = new MidiSound(currentMidiNumber, 1, 500l);
            Triplet triplet = Converter.MIDI_TO_NOTE.get(currentMidiNumber);

            Point point = new Point(i * 20 + 10, 100);
            Rectangle shape = new Rectangle(point, Color.WHITE, 100, 20);
            Key key = new Key(point, note, "", shape, border, true, triplet.getFrequency(), triplet.getOctave(), triplet.getNoteName(), null, null);
            piano.addKey(key);
        }

        //Add first key
        currentMidiNumber = blackMidiNumber[0];
        MidiSound note = new MidiSound(currentMidiNumber, 1, 500);
        Triplet triplet = Converter.MIDI_TO_NOTE.get(currentMidiNumber);
        Point point = new Point(20, 80);
        Rectangle shape = new Rectangle(point, Color.BLACK, 60, 11);
        Key key = new Key(point, note, "", shape, border, true, triplet.getFrequency(), triplet.getOctave(), triplet.getNoteName(), null, null);
        piano.addKey(key);

        //Add other key
        for (int j = 1; j < 8; j++) {
            for (int k = 0; k < 5; k++) {
                if (k == 0 || k == 1) {
                    currentMidiNumber = blackMidiNumber[(j - 1) * 5 + k + 1];
                    note = new MidiSound(currentMidiNumber, 1, 500);
                    triplet = Converter.MIDI_TO_NOTE.get(currentMidiNumber);
                    point = new Point((j - 1) * 140 + 60 + k * 20, 80);
                    shape = new Rectangle(point, Color.BLACK, 60, 11);
                    key = new Key(point, note, "", shape, border, true, triplet.getFrequency(), triplet.getOctave(), triplet.getNoteName(), null, null);
                    piano.addKey(key);

                } else {
                    currentMidiNumber = blackMidiNumber[(j - 1) * 5 + k + 1];
                    note = new MidiSound(currentMidiNumber, 1, 500);
                    triplet = Converter.MIDI_TO_NOTE.get(currentMidiNumber);
                    point = new Point((j - 1) * 140 + 120 + (k - 2) * 20, 80);
                    shape = new Rectangle(point, Color.BLACK, 60, 11);
                    key = new Key(point, note, "", shape, border, true, triplet.getFrequency(), triplet.getOctave(), triplet.getNoteName(), null, null);
                    piano.addKey(key);
                }

            }

        }
        point = new Point(522, 50);
        note = new MidiSound(0, 0, 0);
        triplet = Converter.MIDI_TO_NOTE.get(0);
        shape = new Rectangle(point, Color.black, 15, 1045);
        key = new Key(point, note, "", shape, border, false, triplet.getFrequency(), triplet.getOctave(), triplet.getNoteName(), null, null);
        piano.addKey(key);

        return piano;
    }

}
