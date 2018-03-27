package logique;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.*;

public class MidiSound implements Playable, Serializable {

    private int midiNumber;
    private int instrumentNumber;
    private long persistence;
    private transient Thread thread;
    private int channelNumber;
    private final int VELOCITY = 100;

    public MidiSound(int midiNumber, int instrumentNumber, long persistence) {
        this.midiNumber = midiNumber;
        this.instrumentNumber = instrumentNumber;
        this.persistence = persistence;
        this.channelNumber = 0;
    }

    private long frequenceToNoteNumber(double freq) {
        double logResult = Math.log(freq / 440) / Math.log(2);
        long noteNumber = (long) (69 + 12 * logResult);

        return noteNumber;
    }

    @Override
    public void start() {
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    Synthesizer synthesizer = MidiSystem.getSynthesizer();
                    synthesizer.open();

                    MidiChannel[] channels = synthesizer.getChannels();

                    channels[channelNumber].programChange(instrumentNumber);
                    channels[channelNumber].noteOn(midiNumber, VELOCITY);

                    try {
                        Thread.sleep(Long.MAX_VALUE);
                    } catch (InterruptedException e) {
                        channels[channelNumber].noteOff(midiNumber);
                    }
                } catch (MidiUnavailableException ex) {
                    ex.printStackTrace();
                }

                channelNumber++;
                if (channelNumber == 9) {
                    channelNumber++;
                }

                if (channelNumber == 15) {
                    channelNumber = 0;
                }
                stop();
            }
        });

        thread.start();
    }

    @Override
    public void stop() {
        if (thread != null) {
            thread.interrupt();
        }
    }

    @Override
    public void playOnce() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Synthesizer synthesizer = MidiSystem.getSynthesizer();
                    synthesizer.open();

                    //javax.sound.midi.Instrument[] instruments = synthesizer.getDefaultSoundbank().getInstruments();
                    MidiChannel[] channels = synthesizer.getChannels();

                    //synthesizer.loadInstrument(instruments[instrumentNumber]);
                    channels[channelNumber].programChange(instrumentNumber);
                    channels[channelNumber].noteOn(midiNumber, VELOCITY);

                    long currentTime = System.currentTimeMillis();
                    while (System.currentTimeMillis() < persistence + currentTime) {
Thread.yield();
                    }

                    channels[channelNumber].noteOff(midiNumber);
                    channelNumber++;
                    if (channelNumber == 9) {
                        channelNumber++;
                    }

                    if (channelNumber == 15) {
                        channelNumber = 0;
                    }

                } catch (MidiUnavailableException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        
    }

    @Override
    public long getPersistance() {
        return persistence;
    }

    public void setPersistance(long persistance) {
        this.persistence = persistance;
    }

    @Override
    public String getInstrumentName() {
        switch (instrumentNumber) {
            case 0:
                return "Piano";
            case 24:
                return "Guitar";
            case 12:
                return "Marimba";
            case 19:
                return "Organ";
            case 74:
                return "Flute";
            default:
                return "NO INSTRUMENT";
        }
    }

}
