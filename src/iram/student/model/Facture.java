package iram.student.model;

import java.sql.Date;

public class Facture {
    //region variable
    private int id;
    private double total;
    private boolean paye;
    private Date creation;
    //endregion

    public Facture(int id, double total, boolean paye, Date creation) {
        this.id = id;
        this.total = total;
        this.paye = paye;
        this.creation = creation;
    }

    //region getter
    public int getId() {
        return id;
    }
    public double getTotal() {
        return total;
    }
    public boolean isPaye() {
        return paye;
    }
    public Date getCreation() {
        return creation;
    }
    //endregion

    //region setter
    public void setTotal(double total) {
        this.total = total;
    }
    public void setPaye(boolean paye) {
        this.paye = paye;
    }
    public void setCreation(Date creation) {
        this.creation = creation;
    }
    //endregion
}
