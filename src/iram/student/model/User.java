package iram.student.model;

import iram.student.enums.RoleUser;

public class User {
    //region variable
    private int id;
    private RoleUser role;
    private String username;
    private String pswd;
    private String mail;
    private int lienClient;
    //endregion

    //region constructor
    public User(String username, String pswd) {
        this.username = username;
        this.pswd = pswd;
    }
    public User(int id, RoleUser role, String username, String pswd, String mail, int lienClient) {
        this.id = id;
        this.role = role;
        this.username = username;
        this.pswd = pswd;
        this.mail = mail;
        this.lienClient = lienClient;
    }
    public User(RoleUser role, String username, String pswd, String mail, int lienClient) {
        this.role = role;
        this.username = username;
        this.pswd = pswd;
        this.mail = mail;
        this.lienClient = lienClient;
    }
    public User(String username, String pswd, String mail, int lienClient) {
        this.username = username;
        this.pswd = pswd;
        this.mail = mail;
        this.lienClient = lienClient;
    }
    public User() {

    }
    //endregion

    //region getter
    public int getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public String getPswd() {
        return pswd;
    }
    public String getMail() {
        return mail;
    }
    public int getLienClient() {
        return lienClient;
    }
    //endregion

    //region setter
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPswd(String pswd) {
        this.pswd = pswd;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public void setLienClient(int lienClient) {
        this.lienClient = lienClient;
    }
    //endregion

    @Override
    public String toString() {
        return "User => " +
                "id=" + id +
                "|| role=" + role +
                "|| username='" + username + '\'' +
                "|| pswd='" + pswd + '\'' +
                "|| mail='" + mail + '\'' +
                "|| lienClient=" + lienClient +
                '}';
    }
}
