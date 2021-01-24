package iram.student.model;

public class User {
    //region variable
    private int id;
    private String username;
    private String pswd;
    private String mail;
    private int lienClient;
    //endregion

    //region constructor
    public User(int id, String username, String pswd, String mail, int lienClient) {
        this.id = id;
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
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", pswd='" + pswd + '\'' +
                ", mail='" + mail + '\'' +
                ", lienClient=" + lienClient +
                '}';
    }
}
