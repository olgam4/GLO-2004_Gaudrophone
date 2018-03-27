package logique;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import java.util.Timer;
import java.util.TimerTask;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.Synthesizer;

public class Metronome {

    private double bpm;
    private Timer timer;
    public static int VELOCITY = 100;
    private static final int CHANNEL_NUMBER = 9;
    private static final int PERSISTENCE = 500;
    private static final int INSTRUMENT_NUMBER = 0;
    private static final int MIDI_NUMBER = 45;
    private Synthesizer synthesizer;
    private MidiChannel[] channels;

    public Metronome() {
        try {
            this.synthesizer = MidiSystem.getSynthesizer();
            this.synthesizer.open();
            this.channels = synthesizer.getChannels();
            channels[CHANNEL_NUMBER].programChange(INSTRUMENT_NUMBER);

        } catch (MidiUnavailableException ex) {
            ex.printStackTrace();
        }

    }

    public void setBPM(double bpm) {
        this.bpm = bpm;
    }

    public void play() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                channels[CHANNEL_NUMBER].noteOn(MIDI_NUMBER, VELOCITY);
                try {
                    Thread.sleep(PERSISTENCE);
                } catch (InterruptedException e) {
                }
                channels[CHANNEL_NUMBER].noteOff(MIDI_NUMBER);
            }
        };

        timer = new Timer();
        timer.scheduleAtFixedRate(task, 0, (long) (60000 / bpm));

    }

    public void stop() {
        if (timer != null) {
            timer.cancel();
        }
    }
}
