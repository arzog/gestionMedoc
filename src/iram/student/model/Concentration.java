package iram.student.model;

public class Concentration {
    //region variables
    private int id;
    private int concentration;
    private String unite; //ex: ml, mg, dl, ...
    private boolean perime;
    //endregion

    //region constructeur
    public Concentration(int id, int concentration, String unite, boolean perime) {
        this.id = id;
        this.concentration = concentration;
        this.unite = unite;
        this.perime = perime;
    }
    public Concentration(int concentration, String unite, boolean perime) {
        this.concentration = concentration;
        this.unite = unite;
        this.perime = perime;
    }
    //endregion

    //region getter
    public int getId() {
        return id;
    }
    public int getConcentration() {
        return concentration;
    }
    public String getUnite() {
        return unite;
    }
    public boolean isPerime() {
        return perime;
    }
    //endregion

    //region setter
    public void setConcentration(int concentration) {
        this.concentration = concentration;
    }
    public void setUnite(String unite) {
        this.unite = unite;
    }
    public void setPerime(boolean perime) {
        this.perime = perime;
    }
    //endregion

    @Override
    public String toString() {
        return "Concentration{" +
                "id=" + id +
                ", concentration=" + concentration +
                ", unite='" + unite + '\'' +
                ", perime=" + perime +
                '}';
    }
}
