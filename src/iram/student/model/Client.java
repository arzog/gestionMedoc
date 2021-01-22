package iram.student.model;

public class Client {
    //region variable
    private int id;
    private String nom;
    private String prenom;
    private String pays;
    private String ville;
    private String rue;
    private String num;
    private int cp;
    private boolean actif;
    //endregion
    public Client(int id, String nom, String prenom, String pays, String ville, String rue, String num, int cp, boolean actif) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.pays = pays;
        this.ville = ville;
        this.rue = rue;
        this.num = num;
        this.cp = cp;
        this.actif = actif;
    }

    public Client(String nom, String prenom, String pays, String ville, String rue, String num, int cp, boolean actif) {
        this.nom = nom;
        this.prenom = prenom;
        this.pays = pays;
        this.ville = ville;
        this.rue = rue;
        this.num = num;
        this.cp = cp;
        this.actif = actif;
    }

    //region getter
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getPays() {
        return pays;
    }

    public String getVille() {
        return ville;
    }

    public String getRue() {
        return rue;
    }

    public String getNum() {
        return num;
    }

    public int getCp() {
        return cp;
    }

    public boolean isActif() {
        return actif;
    }
    //endregion

    //region setter
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void setCp(int cp) {
        this.cp = cp;
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
