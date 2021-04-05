package iram.student.model;

import com.mysql.cj.conf.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Client {
    //region variable
    private int id;
    private StringProperty nom;
    private StringProperty prenom;
    private StringProperty pays;
    private StringProperty ville;
    private StringProperty rue;
    private StringProperty num;
    private SimpleIntegerProperty cp;
    private boolean actif;
    //endregion

    //region constructor
    public Client(int id, String nom, String prenom, String pays, String ville, String rue, String num, int cp, boolean actif) {
        this.id = id;
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.pays = new SimpleStringProperty(pays);
        this.ville = new SimpleStringProperty(ville);
        this.rue = new SimpleStringProperty(rue);
        this.num = new SimpleStringProperty(num);
        this.cp = new SimpleIntegerProperty(cp);
        this.actif = actif;
    }

    public Client(String nom, String prenom, String pays, String ville, String rue, String num, int cp, boolean actif) {
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.pays = new SimpleStringProperty(pays);
        this.ville = new SimpleStringProperty(ville);
        this.rue = new SimpleStringProperty(rue);
        this.num = new SimpleStringProperty(num);
        this.cp = new SimpleIntegerProperty(cp);
        this.actif = actif;
    }
    //endregion

    //region getter String
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom.get();
    }

    public String getPrenom() {
        return prenom.get();
    }

    public String getPays() {
        return pays.get();
    }

    public String getVille() {
        return ville.get();
    }

    public String getRue() {
        return rue.get();
    }

    public String getNum() {
        return num.get();
    }

    public int getCp() {
        return cp.get();
    }

    public boolean isActif() {
        return actif;
    }
    //endregion

    //region getter StringProperty
    public StringProperty nomProperty() {
        return nom;
    }
    public StringProperty prenomProperty() {
        return prenom;
    }
    public StringProperty paysProperty() {
        return pays;
    }
    public StringProperty villeProperty() {
        return ville;
    }
    public StringProperty rueProperty() {
        return rue;
    }
    public StringProperty numProperty() {
        return num;
    }
    public SimpleIntegerProperty cpProperty() {
        return cp;
    }
    //endregion

    //region setter
    public void setNom(String nom) {
        this.nom.set(nom);
    }
    public void setPrenom(String prenom) {
        this.prenom.set(prenom);
    }
    public void setPays(String pays) {
        this.pays.set(pays);
    }
    public void setVille(String ville) {
        this.ville.set(ville);
    }
    public void setRue(String rue) {
        this.rue.set(rue);
    }
    public void setNum(String num) {
        this.num.set(num);
    }
    public void setCp(int cp) {
        this.cp.set(cp);
    }
    public void setActif(boolean actif) {
        this.actif = actif;
    }
    //endregion

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", pays='" + pays + '\'' +
                ", ville='" + ville + '\'' +
                ", rue='" + rue + '\'' +
                ", num='" + num + '\'' +
                ", cp=" + cp +
                ", actif=" + actif +
                '}';
    }
}
