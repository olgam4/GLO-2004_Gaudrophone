package logique.search;

import logique.Key;
import java.util.ArrayList;
import logique.Instrument;

/**
 *
 * @author phi
 */

public interface SearchStrategy {
    ArrayList<Key> searchKeys(ArrayList<String> searchTerms, Instrument instrument);   
}
