package it.giannotti;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Museum {
    private Map<String, Set<AbstractArtwork>> collection;

    public Museum() {
        collection = new HashMap<>();
    }

    public void addArtwork(AbstractArtwork a) {
        if (!collection.containsKey(a.getArtist())) {
            collection.put(a.getArtist(), new HashSet<>());
        }
        collection.get(a.getArtist()).add(a);
    }

    public void removeArtwork(String title, String artist) {
        collection.get(artist).removeIf(a -> a.getTitle().equals(title));
    }

    public void saveToFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("museum.json");
        try {
            objectMapper.writeValue(file, collection);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("museum.json");
        try {
            collection = objectMapper.readValue(file, new TypeReference<Map<String, Set<AbstractArtwork>>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
