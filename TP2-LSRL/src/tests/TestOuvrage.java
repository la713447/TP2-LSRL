package tests;

import java.time.LocalDate;
import java.util.List;

import livres.Ouvrage;
import livres.OuvragePapier;
import livres.Auteur;
import livres.Pays;
import livres.Serie;
import livres.*;

public class TestOuvrage {

    public static void main(String[] args) {
        TestOuvrage test = new TestOuvrage();
        test.testOuvrages();
        test.testTrouver();
        test.testSerie();
        test.testPays();
    }

    public void testOuvrages() {

        Auteur albertine = new Auteur("Albertine", "Tremblay", new Pays("Canada"));
        Auteur john = new Auteur("John", "Smith", new Pays("Etats-Unis"));

        System.out.println("-----Test des constructeurs d'ouvrage et des diverses validations-----------");

        Ouvrage livreA = new OuvragePapier("Titre assez long", john, Ouvrage.Format.PAPIER);
        System.out.println(livreA);

        Ouvrage livreB = new OuvragePapier("Ti", john, Ouvrage.Format.PAPIER);
        System.out.println(livreB);

        Ouvrage livreC = new OuvragePapier(null, john, Ouvrage.Format.PAPIER);
        System.out.println(livreC);

        Ouvrage livreA1 = new OuvragePapier("Titre assez long", null, Ouvrage.Format.PAPIER);
        System.out.println(livreA1);

        Ouvrage livre1 = new OuvragePapier("Tout va bien", albertine, Ouvrage.Format.PAPIER);
        System.out.println(livre1);

        livre1.setDate(null);
        System.out.println(livre1);

        livre1.setDate(LocalDate.now().minusYears(5));
        System.out.println(livre1);

        Ouvrage livre2 = new OuvragePapier(
                "Tout va bien",
                albertine,
                Ouvrage.Format.PAPIER,
                LocalDate.now(),
                -10
        );
        System.out.println(livre2);

        livre2 = new OuvragePapier(
                "Tout va bien",
                albertine,
                Ouvrage.Format.PAPIER,
                LocalDate.now(),
                20
        );
        System.out.println(livre2);

        System.out.println("\n-----Tests des méthodes acheter et vendre-----------");

        Ouvrage livre3 = new OuvragePapier(
                "Musique du hasard",
                new Auteur("Paul", "Auster", new Pays("Etats-Unis")),
                Ouvrage.Format.PAPIER,
                LocalDate.now(),
                5
        );

        System.out.println(livre3);

        livre3.acheter(5);
        System.out.println(livre3);

        System.out.println("On peut vendre 8 livres? " + livre3.vendre(8));
        System.out.println(livre3);

        System.out.println("On peut vendre 10 livres? " + livre3.vendre(10));
        System.out.println(livre3);

        Ouvrage livre4 = new OuvragePapier(
                "Test",
                new Auteur("A", "B", new Pays("Etats-Unis")),
                Ouvrage.Format.PAPIER,
                LocalDate.now(),
                5
        );

        System.out.println("\n-----Tests de la méthode equals()-----------");

        Ouvrage livre5 = new OuvragePapier(
                "Test",
                new Auteur("A", "B", new Pays("Etats-Unis")),
                Ouvrage.Format.PAPIER,
                null,
                5
        );

        Ouvrage livre6 = new OuvragePapier(
                "Test",
                new Auteur("A", "B", new Pays("Etats-Unis")),
                Ouvrage.Format.PAPIER,
                LocalDate.now(),
                10
        );

        Ouvrage livre7 = new OuvragePapier(
                "Test",
                new Auteur("Z", "B", new Pays("Etats-Unis")),
                Ouvrage.Format.PAPIER,
                LocalDate.now(),
                5
        );

        System.out.println("Test equals livre4 vs livre5: " + livre4.equals(livre5));
        System.out.println("Test equals livre4 vs livre6: " + livre4.equals(livre6));
        System.out.println("Test equals livre4 vs livre7: " + !livre4.equals(livre7));
        System.out.println("Test equals livre4 vs john: " + !livre4.equals(john));
        System.out.println("Test equals livre4 vs null: " + !livre4.equals(null));
        System.out.println("Test equals livre4 vs String: " + !livre4.equals("Test"));
    }

    private void testTrouver() {

        Librairie bibliotheque = new Librairie();
        Auteur john = bibliotheque.getAuteurs().get(1);

        System.out.println("\n-----Test de votre méthode trouverOuvrage-----------");

        List<Ouvrage> resultat = bibliotheque.trouverOuvrages(
                new Auteur("Albertine", "Tremblay", new Pays("Canada"))
        );
        System.out.println("Livres de albertine: " + resultat);

        resultat = bibliotheque.trouverOuvrages(john);
        System.out.println("Livres de john: " + resultat);

        resultat = bibliotheque.trouverOuvrages(
                new Auteur("Jacques", "Beaulieu", new Pays("France"))
        );
        System.out.println("Livres de Jacques: " + resultat);
    }

    private void testPays() {

        System.out.println("\n-----Test de la classe Pays-----------");

        Pays canada = new Pays("Canada", "CAN");

        Auteur albertine = new Auteur("Albertine", "Tremblay", canada);
        System.out.println(albertine.getPrenom() + " vient de "
                + albertine.getPaysOrigine().getNom()
                + " (" + albertine.getPaysOrigine().getCode() + ")");

        try {
            Pays invalide = new Pays("France", "fra");
            System.out.println("ERREUR: code invalide accepté ");
        } catch (IllegalArgumentException e) {
            System.out.println("Code invalide refusé ✔️");
        }
    }

    private void testSerie() {

        System.out.println("\n-----Test de la classe Serie-----------");

        Pays canada = new Pays("Canada", "CAN");
        Auteur albertine = new Auteur("Albertine", "Tremblay", canada);

        Ouvrage livre1 = new OuvragePapier("Titre 1", albertine, Ouvrage.Format.PAPIER);
        Ouvrage livre2 = new OuvragePapier("Titre 2", albertine, Ouvrage.Format.PAPIER);

        Serie serie = new Serie("Ma série");

        serie.ajouterOuvrage(livre1);
        serie.ajouterOuvrage(livre2);

        System.out.println("Après ajout : " + serie.getListeOuvrage());

        serie.enleverOuvrage(livre1);

        System.out.println("Après suppression : " + serie.getListeOuvrage());
    }
}