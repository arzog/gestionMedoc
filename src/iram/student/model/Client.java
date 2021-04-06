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


    public Client() {
        this.nom = new SimpleStringProperty("last name");
        this.prenom = new SimpleStringProperty("first name");
        this.pays = new SimpleStringProperty("land");
        this.ville = new SimpleStringProperty("city");
        this.rue = new SimpleStringProperty("street");
        this.num = new SimpleStringProperty("house number");
        this.cp = new SimpleIntegerProperty(0);
        this.actif = actif;
    }

    public Client(int id, String nom, String prenom, String pays, String ville, String rue, String num, int cp, boolean actif) {
        this.id = id;
        this.nom = new SimpleStringProperty(nom.substring(0,1).toUpperCase()+nom.substring(1));
        this.prenom = new SimpleStringProperty(prenom.substring(0,1).toUpperCase()+prenom.substring(1));
        this.pays = new SimpleStringProperty(pays.substring(0,1).toUpperCase()+pays.substring(1));
        this.ville = new SimpleStringProperty(ville.substring(0,1).toUpperCase()+ville.substring(1));
        this.rue = new SimpleStringProperty(rue);
        this.num = new SimpleStringProperty(num);
        this.cp = new SimpleIntegerProperty(cp);
        this.actif = actif;
    }

    public Client(String nom, String prenom, String pays, String ville, String rue, String num, int cp, boolean actif) {
        this.nom = new SimpleStringProperty(nom.substring(0,1).toUpperCase()+nom.substring(1));
        this.prenom = new SimpleStringProperty(prenom.substring(0,1).toUpperCase()+prenom.substring(1));
        this.pays = new SimpleStringProperty(pays.substring(0,1).toUpperCase()+pays.substring(1));
        this.ville = new SimpleStringProperty(ville.substring(0,1).toUpperCase()+ville.substring(1));
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
