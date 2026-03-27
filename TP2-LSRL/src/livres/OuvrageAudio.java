package livres;

import java.time.LocalDate;

public class OuvrageAudio extends Ouvrage{
    private int dureeMinute;

    public OuvrageAudio(String titre, Auteur auteur, Ouvrage.Format type, LocalDate date, int nombreExemplaires) {
        super(titre, auteur, type, date, nombreExemplaires);
    }

    public OuvrageAudio(String titre, Auteur auteur, Ouvrage.Format type) {
        super(titre, auteur, type);
    }

    public OuvrageAudio(String titre, Auteur auteur) {
        super(titre, auteur);
    }

    public enum Format {
        NUMERIQUE, ANALOGIQUE
    }


    public int getDureeMinute() {
        return dureeMinute;
    }

    public void setDureeMinute(int dureeMinute) {
        this.dureeMinute = dureeMinute;
    }


}