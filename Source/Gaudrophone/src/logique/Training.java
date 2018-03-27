package logique;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;

public class Training {

    private List<String> possibleNotes;
    private final int[] scores;
    private final Partition partition;

    public Training(List<List<String>> partitionNotes, Partition partition) {
        this.partition = partition;
        this.possibleNotes = new ArrayList<>();
        this.scores = new int[partitionNotes.size()];
        for (int i = 0; i < scores.length; i++) {
            scores[i] = 0;
        }

        new Timer(1, (ActionEvent ae) -> {
            int index = partition.getNoteIndexFromTick(partition.getCurrentTick());
            possibleNotes = partitionNotes.get(index);
        }).start();
    }

    public int getScore() {
        int sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }
        return sum;
    }

    void compareKey(Key keyClicked) {
        if (possibleNotes.contains(keyClicked.getNoteName() + keyClicked.getOctave())) {
            int index = partition.getNoteIndexFromTick(partition.getCurrentTick());
            scores[index] = 1;
        }
    }   
    
}
