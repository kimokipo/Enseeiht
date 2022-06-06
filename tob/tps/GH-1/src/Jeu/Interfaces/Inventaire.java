package Jeu.Interfaces;

import java.util.Map;

public interface Inventaire {

    void clear();

    void ajouter(String item);

    void supprimer(String item);

    Map<String, Integer> getMap();
}
