package utils;

public class Triplet {

    private final String noteName;
    private final String octave;
    private final String frequency;

    public Triplet(String noteName, String octave, String frequency) {
        this.noteName = noteName;
        this.octave = octave;
        this.frequency = frequency;
    }

    public String getNoteName() {
        return noteName;
    }

    public String getOctave() {
        return octave;
    }

    public String getFrequency() {
        return frequency;
    }
}
