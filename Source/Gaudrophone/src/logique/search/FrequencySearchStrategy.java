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
public class FrequencySearchStrategy implements SearchStrategy {

    @Override
    public ArrayList<Key> searchKeys(ArrayList<String> searchTerms, Instrument instrument) {
        ArrayList<Key> list = new ArrayList<Key>();
        searchTerms.forEach((searchTerm) -> {
            instrument.getKeys().stream().filter((key) -> (key.getFrequency().contains(searchTerm))).forEachOrdered((key) -> {
                list.add(key);
            });
        });
        return list;
    }
}
