package model;

public class User {
    private int id = 0;
    private String nom = "";
    private String cognom1 = "";
    private String cognom2 = "";
    private String edat = "";
    private String telefon = "";
    private String adreça = "";
    private String city = "";

    public User(int id, String nom, String cognom1, String cognom2, String edat, String telefon, String adreça, String city) {
        this.id = id;
        this.nom = nom;
        this.cognom1 = cognom1;
        this.cognom2 = cognom2;
        this.edat = edat;
        this.telefon = telefon;
        this.adreça = adreça;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public String getCognom1() {
        return cognom1;
    }

    public String getCognom2() {
        return cognom2;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getAdreça() {
        return adreça;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", cognom1='" + cognom1 + '\'' +
                ", cognom2='" + cognom2 + '\'' +
                ", edat='" + edat + '\'' +
                ", telefon='" + telefon + '\'' +
                ", adreça='" + adreça + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
