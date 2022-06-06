package Jeu.Modeles;

import Jeu.Interfaces.Inventaire;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class InventaireSimple implements Inventaire, Serializable {
    private Map<String, Integer> inventaire;

    public InventaireSimple() {
        inventaire = new HashMap<>();
    }

    public void clear() {
        inventaire.clear();
    }

    public void ajouter(String item) {
        if (item == null || item.equals(""))
            return;

        if (!inventaire.containsKey(item))
            inventaire.put(item, 1);
        else
            inventaire.replace(item, inventaire.get(item)+1);
    }

    public void supprimer(String item) {
        if (!inventaire.containsKey(item))
            return;

        if (inventaire.get(item).equals(1))
            inventaire.remove(item);
        else
            inventaire.replace(item, inventaire.get(item)-1);
    }

    public Map<String, Integer> getMap() {
        return inventaire;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        for (Map.Entry<String,Integer> e : inventaire.entrySet()){
            i++;
            if (e.getValue()>0){
                builder.append(e.getValue())
                        .append("x ")
                        .append(e.getKey())
                        .append(i==inventaire.size() ? "." : ",");
            }
        }
        return builder.toString();
    }
}
