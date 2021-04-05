package iram.student.model;

public class Medicament {
    //region variable
    private int id;
    private String nom;
    private double prix;
    private int quantite_boite;
    private String urlDoc;
    //endregion

    //region constructeurs
    public Medicament(int id, String nom, double prix, int quantite_boite, String urlDoc) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.quantite_boite = quantite_boite;
        this.urlDoc = urlDoc;
    }

    public Medicament(String nom, double prix, int quantite_boite, String urlDoc) {
        this.nom = nom;
        this.prix = prix;
        this.quantite_boite = quantite_boite;
        this.urlDoc = urlDoc;
    }
    //endregion

    //region getter
    public int getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }
    public double getPrix() {
        return prix;
    }
    public int getQuantite_boite() {
        return quantite_boite;
    }
    public String getUrlDoc() {
        return urlDoc;
    }
    //endregion

    //region setter
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }
    public void setQuantite_boite(int quantite_boite) {
        this.quantite_boite = quantite_boite;
    }
    public void setUrlDoc(String urlDoc) {
        this.urlDoc = urlDoc;
    }
    //endregion

    @Override
    public String toString() {
        return "Medicament{" +
                "//id=" + id +
                "|| nom='" + nom + '\'' +
                "|| prix=" + prix +
                "|| quantite_boite=" + quantite_boite +
                "|| urlDoc='" + urlDoc + '\'' +
                '}';
    }
}
