package it.giannotti;

import java.util.Map;
import java.util.TreeMap;

public class Dictionary {

    private Map<String, String> dictionary;

    public Dictionary() {
        dictionary = new TreeMap<>();
    }

    public void addWord(String word, String translation) {
        dictionary.put(word,translation);
    }

    public String translateWord(String word) {
        return dictionary.get(word) == null ? "La parola non è stata trovata" : "Traduzione di \"" + word + "\": " + dictionary.get(word);
    }

    @Override
    public String toString() {
        return "Dictionary [dictionary=" + dictionary + "]";
    }

    
}
