package logique;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class WavSound implements Playable, Serializable {

    private String title;
    private final String filename;
    private transient Thread thread;
    private long persistance;

    public WavSound(String filename, String title) {
        this.persistance = 0;
        this.filename = filename;
        this.title = title;
    }

    @Override
    public String getInstrumentName() {
        return "Custom";
    }

    @Override
    public long getPersistance() {
        return persistance;
    }

    @Override
    public void playOnce() {
        start();
    }

    @Override
    public void start() {
        stop();

        File in = new File(filename);

        thread = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(in);
                    clip.open(audioInputStream);
                    clip.start();

                    if (persistance == 0) {
                        persistance = (int) clip.getMicrosecondLength() / 1000;
                    }

                    try {
                        Thread.sleep(persistance);
                    } catch (InterruptedException ex) {
                        clip.stop();
                    }
                    clip.stop();

                } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();

    }

    public void stop() {
        if (thread != null) {
            thread.interrupt();
        }
    }

    public static WavSound importFromFile() {
        WavSound sound = null;

        try {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("WAV files", "wav");
            fileChooser.setFileFilter(filter);

            int value = fileChooser.showOpenDialog(null);

            if (value == JFileChooser.APPROVE_OPTION) {
                final File selectedFile = fileChooser.getSelectedFile();

                String nameAndExtension = selectedFile.getName();
                String name = nameAndExtension.substring(0, nameAndExtension.length() - 4);

                sound = new WavSound(nameAndExtension, name);
                Files.copy(selectedFile.toPath(), new File(nameAndExtension).toPath());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return sound;
    }

    public String getName() {
        return title;
    }

    public void setName(String name) {
        this.title = name;
    }

    @Override
    public String toString() {
        return title;
    }

    @Override
    public void setPersistance(long persistance) {
        this.persistance = persistance;
    }

}
