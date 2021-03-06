package iram.student.model;

import iram.student.enums.TypeMedic;
import iram.student.enums.UniteMedic;

public class Medicament {
    //region variable
    private int id;
    private String nom;
    private int concentration;
    private double prix;
    private int quantite_boite;
    private UniteMedic unite; // <-- change to ENUM
    private TypeMedic type; // <-- change to ENUM
    private String urlDoc;
    //endregion

    public Medicament(int id, String nom, int concentration, double prix, int quantite_boite, UniteMedic unite, TypeMedic type, String urlDoc) {
        this.id = id;
        this.nom = nom;
        this.concentration = concentration;
        this.prix = prix;
        this.quantite_boite = quantite_boite;
        this.unite = unite;
        this.type = type;
        this.urlDoc = urlDoc;
    }

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
    public UniteMedic getUnite() {
        return unite;
    }
    public TypeMedic getType() {
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
    public void setUnite(UniteMedic unite) {
        this.unite = unite;
    }
    public void setType(TypeMedic type) {
        this.type = type;
    }
    public void setUrlDoc(String urlDoc) {
        this.urlDoc = urlDoc;
    }
    //endregion
}
