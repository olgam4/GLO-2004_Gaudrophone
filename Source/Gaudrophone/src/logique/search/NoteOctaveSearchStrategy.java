/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logique.search;

import java.util.ArrayList;
import logique.Instrument;
import logique.Key;

/**
 *
 * @author phi
 */
public class NoteOctaveSearchStrategy implements SearchStrategy {

    @Override
    public ArrayList<Key> searchKeys(ArrayList<String> searchTerms, Instrument instrument) {
        ArrayList<Key> list = new ArrayList<Key>();
        searchTerms.forEach((searchTerm) -> {
            instrument.getKeys().forEach((keys) -> {
                String noteOctave = keys.getNoteName() + keys.getOctave();
                if (noteOctave == null ? searchTerm == null : noteOctave.equalsIgnoreCase(searchTerm)) {
                    list.add(keys);
                }
            });
        });
        return list;
    }
}
