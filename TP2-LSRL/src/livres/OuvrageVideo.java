package livres;

import java.time.LocalDate;

public class OuvrageVideo extends Ouvrage{
    double dureeMinute;
    int tailleMB;

    public OuvrageVideo(String titre, Auteur auteur, Format type, LocalDate date, int nombreExemplaires) {
        super(titre, auteur, type, date, nombreExemplaires);
    }

    public OuvrageVideo(String titre, Auteur auteur, Format type) {
        super(titre, auteur, type);
    }

    public OuvrageVideo(String titre, Auteur auteur) {
        super(titre, auteur);
    }


    public double getDureeMinute() {
        return dureeMinute;
    }

    public void setDureeMinute(double dureeMinute) {
        this.dureeMinute = dureeMinute;
    }

    public int getTailleMB() {
        return tailleMB;
    }

    public void setTailleMB(int tailleMB) {
        this.tailleMB = tailleMB;
    }
}
