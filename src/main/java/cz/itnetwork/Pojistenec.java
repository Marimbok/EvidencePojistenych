package cz.itnetwork;

public class Pojistenec {
    private String jmeno;
    private String prijmeni;
    private int vek;
    private int telefoniCislo;

    public Pojistenec(String jmeno, String prijmeni, int vek, int telefoniCislo) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
        this.telefoniCislo = telefoniCislo;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public int getVek() {
        return vek;
    }

    public void setVek(int vek) {
        this.vek = vek;
    }

    public int getTelefoniCislo() {
        return telefoniCislo;
    }

    public void setTelefoniCislo(int telefoniCislo) {
        this.telefoniCislo = telefoniCislo;
    }

    @Override
    public String toString(){
        return String.format(getJmeno() + " " + getPrijmeni() + " " + getVek() + " " + getTelefoniCislo());
    }
}
