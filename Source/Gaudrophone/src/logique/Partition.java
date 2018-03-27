package logique;

import gui.MainWindow;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import utils.Converter;
import utils.Triplet;

public class Partition {

    public static final int TICK_PER_QUARTER = 32;

    private static final HashMap<String, Integer> SYMBOL_TO_TICK = new HashMap<>();

    static {
        // "." : quart de temps
        // "," : demi temps
        // "_" : un temps (valeur par défaut)
        // "2" : deux temps            
        // "3" : trois temps
        SYMBOL_TO_TICK.put(",", TICK_PER_QUARTER / 4);
        SYMBOL_TO_TICK.put(".", TICK_PER_QUARTER / 2);
        SYMBOL_TO_TICK.put("_", TICK_PER_QUARTER);
        SYMBOL_TO_TICK.put("2", TICK_PER_QUARTER * 2);
        SYMBOL_TO_TICK.put("3", TICK_PER_QUARTER * 3);
        SYMBOL_TO_TICK.put("4", TICK_PER_QUARTER * 4);
        SYMBOL_TO_TICK.put("5", TICK_PER_QUARTER * 5);
        SYMBOL_TO_TICK.put("6", TICK_PER_QUARTER * 6);
        SYMBOL_TO_TICK.put("7", TICK_PER_QUARTER * 7);
        SYMBOL_TO_TICK.put("8", TICK_PER_QUARTER * 8);
    }

    private final List<String> lyrics;
    private final List<List<String>> completePartition;
    private final List<Integer> tickPerNote;

    private List<List<Integer>> completePartitionMidi;
    private int partitionBPM;
    private static Sequencer sequencer;
    private int bpm;

    public Partition(String file) throws IOException {

        completePartition = new ArrayList<>();
        lyrics = new ArrayList<>();
        tickPerNote = new ArrayList<>();

        parseFile(file);
        convertPartitionToMidi();
    }

    private void parseFile(String file) throws IOException {
        Boolean isParsingHeader = true;
        int noteLineIndex = 0;

        Pattern patternNotes = Pattern.compile("[a-gA-GxX][0-9]{0,1}#{0,1}");
        Pattern patternTempo = Pattern.compile("[_,.2-8]");
        Matcher matcher;

        List<String> myList = Files.lines(Paths.get(file)).map(String::trim).collect(Collectors.toList());

        for (String line : myList) {

            if (isParsingHeader) {
                if (!line.startsWith("//")) {
                    try {
                        partitionBPM = Integer.parseUnsignedInt(line);
                    } catch (NumberFormatException e) {
                        partitionBPM = 60;
                    }
                    isParsingHeader = false;
                }
            } else {

                if (line.startsWith("//")) {
                    lyrics.add(line);
                } else if (line.isEmpty()) {
                    noteLineIndex = 0;
                } else {
                    List<String> notes;
                    if (noteLineIndex < completePartition.size()) {
                        notes = completePartition.get(noteLineIndex);
                    } else {
                        notes = new ArrayList<>();
                        completePartition.add(noteLineIndex, notes);
                    }
                    matcher = patternNotes.matcher(line);

                    int count = 0;
                    while (matcher.find()) {
                        count++;
                        notes.add(matcher.group());
                    }

                    if (count == 0) {
                        completePartition.remove(noteLineIndex);
                        matcher = patternTempo.matcher(line);
                        while (matcher.find()) {
                            tickPerNote.add(SYMBOL_TO_TICK.get(matcher.group()));
                        }
                    }

                    noteLineIndex++;
                }
            }
        }

        // assert #notes = #tempo if tempo
        if (tickPerNote.isEmpty()) {
            for (String notes : completePartition.get(0)) {
                tickPerNote.add(TICK_PER_QUARTER);
            }
        }
        for (List<String> noteLine : completePartition) {
            if (tickPerNote.size() != noteLine.size()) {
                throw new IOException("format error.");
            }
        }
    }

    private void convertPartitionToMidi() {
        completePartitionMidi = new ArrayList<>();
        for (int row = 0; row < completePartition.size(); row++) {
            List<String> noteLine = completePartition.get(row);
            for (int col = 0; col < noteLine.size(); col++) {
                List<Integer> notes;
                if (row == 0) {
                    notes = new ArrayList<>();
                    completePartitionMidi.add(notes);
                } else {
                    notes = completePartitionMidi.get(col);
                }
                notes.add(Converter.NAME_TO_MIDI.get(noteLine.get(col).toUpperCase()));
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        lyrics.forEach((lyric) -> {
            sb.append(String.format("%1$-52s", lyric));
        });
        sb.append("\n");
        for (List<String> line : completePartition) {
            for (int i = 0; i < line.size(); i++) {
                if (i % 8 == 0) {
                    sb.append("| ");
                }
                sb.append(String.format("%1$-3s", line.get(i)));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void start(int p_bpm, int tone, Boolean isAudible) {

        try {
            if (sequencer == null) {
                sequencer = MidiSystem.getSequencer();
                sequencer.open();
            }
            this.bpm = p_bpm;
            Sequence seq = setSequence(tone, isAudible);
            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(bpm);
            sequencer.start();

        } catch (InvalidMidiDataException | MidiUnavailableException e) {
            e.printStackTrace();
        }
    }

    private Sequence setSequence(int tone, Boolean isAudible) throws InvalidMidiDataException, MidiUnavailableException {

        Sequence seq = new Sequence(Sequence.PPQ, TICK_PER_QUARTER);

        Track track = seq.createTrack();

        ShortMessage first = new ShortMessage();
        first.setMessage(192, 1, tone, 0);
        MidiEvent changeInstrument = new MidiEvent(first, 1);
        track.add(changeInstrument);

        long timestamp = 0l;
        for (int c = 0; c < completePartitionMidi.size(); c++) {
            int tick = tickPerNote.get(c);
            List<Integer> chord = completePartitionMidi.get(c);
            int volume = isAudible ? 100 : 0;

            for (int n = 0; n < chord.size(); n++) {
                ShortMessage a = new ShortMessage();
                a.setMessage(ShortMessage.NOTE_ON, 1, chord.get(n), volume);
                MidiEvent noteOn = new MidiEvent(a, 1 + timestamp);
                track.add(noteOn);
            }
            for (int n = 0; n < chord.size(); n++) {
                ShortMessage b = new ShortMessage();
                b.setMessage(ShortMessage.NOTE_OFF, 1, chord.get(n), volume);
                MidiEvent noteOff = new MidiEvent(b, timestamp + tick);
                track.add(noteOff);
            }
            timestamp += tick;
        }
        return seq;
    }

    /**
     * toggle pause/play
     */
    public void pause() {
        if (sequencer != null) {
            if (sequencer.isRunning()) {
                sequencer.stop();
            } else {

                sequencer.start();

                sequencer.setTempoInBPM(bpm);
            }
        }
    }

    public void stop() {
        if (sequencer != null) {
            sequencer.stop();
            sequencer.close();
        }
    }

    public void setMicrosecondPosition(long position) {
        if (sequencer != null) {
            sequencer.setMicrosecondPosition(position);

            sequencer.setTempoInBPM(bpm);
        }
    }

    public long getMicrosecondPosition() {
        if (sequencer != null && sequencer.isRunning()) {
            return sequencer.getMicrosecondPosition();
        }
        return 0l;
    }

    public long getMicrosecondLength() {
        if (sequencer != null && sequencer.isRunning()) {
            return sequencer.getMicrosecondLength();
        }
        return 0l;
    }

    public int getDefaultBPM() {
        return partitionBPM;
    }

    private List<List<String>> partitionNotes;

    public List<List<String>> getPartitionNotes() {
        if (partitionNotes == null) {

            partitionNotes = new ArrayList<>();

            for (List<Integer> noteGroup : completePartitionMidi) {

                partitionNotes.add(noteGroup.stream().map(e -> {
                    final Triplet note = Converter.MIDI_TO_NOTE.get(e);
                    String name = note.getNoteName() + note.getOctave();
                    if ("C0".equals(name)) {
                        name = "";
                    }
                    return name;
                }).collect(Collectors.toList()));
            }
        }

        return partitionNotes;
    }

    public List<Integer> getPartitionTicks() {
        return tickPerNote;
    }

    public int getNoteIndexFromTick(long tick) {
        long currentTick = 0;
        for (int i = 0; i < tickPerNote.size(); i++) {
            Integer tickIncr = tickPerNote.get(i);
            currentTick += tickIncr;
            if (tick < currentTick) {
                return i;
            }
        }
        return 0;
    }

    public long getCurrentTick() {
        return sequencer.getTickPosition();
    }

    public static void main(String[] args) throws IOException {
        Partition partition = new Partition(MainWindow.class.getResource("SuperMarioBros_Overworld-MainTheme.txt").toString());
        System.out.println(partition.toString());
        partition.start(400, 8, true);
        System.out.println(partition.getPartitionNotes());
    }

}
