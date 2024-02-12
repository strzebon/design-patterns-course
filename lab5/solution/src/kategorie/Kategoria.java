package kategorie;

import magazyn.Towar;

import java.util.ArrayList;

public class Kategoria {
    private final ArrayList<Towar> towary = new ArrayList<>();
    private final ArrayList<Kategoria> podkategorie = new ArrayList<>();
    private final Kategoria nadkategoria;
    private final String nazwa;

    public Kategoria(Kategoria nadkategoria, String nazwa) {
        this.nadkategoria = nadkategoria;
        this.nazwa = nazwa;
    }

    public Kategoria(String nazwa) {
        this.nadkategoria = null;
        this.nazwa = nazwa;
    }

    public ArrayList<Towar> getTowary() {
        return towary;
    }

    public ArrayList<Kategoria> getPodkategorie() {
        return podkategorie;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void addTowar(Towar towar){
        towary.add(towar);
        if(nadkategoria != null){
            nadkategoria.addTowar(towar);
        }
    }

    public void addPodkategoria(Kategoria podkategoria){
        podkategorie.add(podkategoria);
    }
}
