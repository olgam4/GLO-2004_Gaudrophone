package logique;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class LiveLooping {

    private int keyboardKey;
    private ArrayList<KeyLooping> keys;
    private Timer timer;
    private long initialTime;
    private long nextKeyTime = 0;
    private long prevTime = 0;
    private long currentOffset = 0;
    private GaudrophoneController controller;

    public LiveLooping(int keyboardKey, GaudrophoneController c) {
        this.keyboardKey = keyboardKey;
        this.controller = c;
    }

    public LiveLooping(ArrayList<KeyLooping> keys, GaudrophoneController c) {
        this.keys = keys;
        this.controller = c;
    }

    public ArrayList<KeyLooping> getKeys() {
        return keys;
    }

    public void stop() {
        timer.cancel();
        this.keys = null;
    }

    public final void start() {
        this.initialTime = System.currentTimeMillis();
        TimerTask task = new TimerTask() {
            public void run() {
                for (int i = 0; i < keys.size(); i++) {
                    KeyLooping keylooping = keys.get(i);
                    nextKeyTime = keylooping.getOffset();

                    if (i > 0) {
                        prevTime = keys.get(i - 1).getOffset();
                    }
                    long currentTime = System.currentTimeMillis();
                    while (System.currentTimeMillis() < currentTime + nextKeyTime - prevTime) {
Thread.yield();

                    }

                    if (i != keys.size() - 1) {
                        keylooping.getKey().setKeyPressed(true);
                        keylooping.getKey().getNote().playOnce();
                        keylooping.getKey().setKeyPressed(false);
                    }
                }
            }
        };

        timer = new Timer();
        timer.scheduleAtFixedRate(task, 0, keys.get(keys.size() - 1).getOffset() + 100);
    }

}
