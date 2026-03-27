package livres;

import java.util.ArrayList;

import java.util.List;

public class Serie {

    public String nom;

    private List<Ouvrage> listeOuvrage = new ArrayList<>();



    public Serie(String nomSerie) {

        this.nom = nomSerie;

    }

    public String getNom() {

        return nom;

    }

    public List<Ouvrage> getListeOuvrage() {

        return listeOuvrage;

    }

    public void setNom(String nom) {

        this.nom = nom;

    }

    public void setListeOuvrage(List<Ouvrage> listeOuvrage) {

        this.listeOuvrage = listeOuvrage;

    }



    public void ajouterOuvrage(Ouvrage o) {

        listeOuvrage.add(o);

    }



    public void enleverOuvrage(Ouvrage o) {

        listeOuvrage.remove(o);

    }

}
