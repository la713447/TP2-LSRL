package livres;

public class Pays {
    private String nom;
    private String code;

    public Pays(String nom) {
        this.nom = nom;
    }

    public Pays(String nom, String code) {
        this.nom = nom;
        setCode(code);
    }

    public String getNom() {
        return nom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        if (!code.matches("^[A-Z]{3}$")) {
            throw new IllegalArgumentException("Code invalide (3 lettres majuscules)");
        }
        this.code = code;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}