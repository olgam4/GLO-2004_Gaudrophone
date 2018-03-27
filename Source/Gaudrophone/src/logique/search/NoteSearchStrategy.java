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
public class NoteSearchStrategy implements SearchStrategy {

    @Override
    public ArrayList<Key> searchKeys(ArrayList<String> searchTerms, Instrument instrument) {
        ArrayList<Key> list = new ArrayList<Key>();
        searchTerms.stream().map((searchTerm) -> {
            instrument.getKeys().stream().filter((key) -> (key.getNoteName().contains(searchTerm))).forEachOrdered((key) -> {
                list.add(key);
            });
            return searchTerm;
        }).forEachOrdered((searchTerm) -> {
            instrument.getKeys().stream().filter((keylower) -> (keylower.getNoteName().toLowerCase().contains(searchTerm))).forEachOrdered((keylower) -> {
                list.add(keylower);
            });
        });
        return list;
    }
}
