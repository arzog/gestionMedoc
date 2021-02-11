package iram.student.model;

public class Medicament {
    //region variable
    private int id;
    private String nom;
    private int concentration;
    private double prix;
    private int quantite_boite;
    private String unite; // <-- change to ENUM
    private String type; // <-- change to ENUM
    private String urlDoc;
    //endregion

    //region constructeurs
    public Medicament(int id, String nom, int concentration, double prix, int quantite_boite, String unite, String type, String urlDoc) {
        this.id = id;
        this.nom = nom;
        this.concentration = concentration;
        this.prix = prix;
        this.quantite_boite = quantite_boite;
        this.unite = unite;
        this.type = type;
        this.urlDoc = urlDoc;
    }

    public Medicament(String nom, int concentration, double prix, int quantite_boite, String unite, String type, String urlDoc) {
        this.nom = nom;
        this.concentration = concentration;
        this.prix = prix;
        this.quantite_boite = quantite_boite;
        this.unite = unite;
        this.type = type;
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
    public int getConcentration() {
        return concentration;
    }
    public double getPrix() {
        return prix;
    }
    public int getQuantite_boite() {
        return quantite_boite;
    }
    public String getUnite() {
        return unite;
    }
    public String getType() {
        return type;
    }
    public String getUrlDoc() {
        return urlDoc;
    }
    //endregion

    //region setter
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setConcentration(int concentration) {
        this.concentration = concentration;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }
    public void setQuantite_boite(int quantite_boite) {
        this.quantite_boite = quantite_boite;
    }
    public void setUnite(String unite) {
        this.unite = unite;
    }
    public void setType(String type) {
        this.type = type;
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
                "|| concentration=" + concentration +
                "|| prix=" + prix +
                "|| quantite_boite=" + quantite_boite +
                "|| unite=" + unite +
                "|| type=" + type +
                "|| urlDoc='" + urlDoc + '\'' +
                '}';
    }
}
