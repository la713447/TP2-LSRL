package livres;

import java.time.LocalDate;

public class OuvragePapier extends Ouvrage {
    private int nbPage;

    public OuvragePapier(String titre, Auteur auteur, Ouvrage.Format type, LocalDate date, int nombreExemplaires) {
        super(titre, auteur, type, date, nombreExemplaires);
    }

    public OuvragePapier(String titre, Auteur auteur, Ouvrage.Format type) {
        super(titre, auteur, type);
    }

    public OuvragePapier(String titre, Auteur auteur) {
        super(titre, auteur);
    }

    public int getNbPage() {
        return nbPage;
    }

    public void setNbPage(int nbPage) {
        this.nbPage = nbPage;
    }
}