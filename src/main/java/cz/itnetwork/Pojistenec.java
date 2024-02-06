package cz.itnetwork;

/**
 * Třída reprezentující pojištěnce
 */
public class Pojistenec {

    // Atribut jména pojištěnce
    private String jmeno;

    // Atribut přijmení pojištěnce
    private String prijmeni;

    // Atribut věku pojištěnce
    private int vek;

    // Atribut telefonního čísla pojistence
    private String telefonniCislo;

    /**
     * Konstrukto třídy
     * @param jmeno Jméno pojištěnce
     * @param prijmeni Přijmení pojištěnce
     * @param vek Věk pojištěnce
     * @param telefonniCislo Telefonní číslo pojištěnce
     */
    public Pojistenec(String jmeno, String prijmeni, int vek, String telefonniCislo) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
        this.telefonniCislo = telefonniCislo;
    }

    // Začátek Getterů a Setterů
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

    public String getTelefonniCislo() {
        return telefonniCislo;
    }

    public void setTelefonniCislo(String telefonniCislo) {
        this.telefonniCislo = telefonniCislo;
    }
    // Konec Getterů a Setterů

    /**
     * Override metody toString.
     * @return V jednom řádku vrací všechny informace o pojistenci
     */
    @Override
    public String toString(){
        return String.format(getJmeno() + " " + getPrijmeni() + " " + getVek() + " " + getTelefonniCislo());
    }
}
