package cz.itnetwork;

import java.util.ArrayList;
import java.util.Scanner;

public class DatabazePojistence {

    Scanner sc = new Scanner(System.in);

    /**
     * Seznam, do kterého se ukládájí pojištěnci
     */
    private ArrayList<Pojistenec> seznamPojistenych = new ArrayList<>();


    /**
     * Pro vypsání uživatelsky přívětivého menu a možností, které uživatel může provést
     */
    public void vypisMenu() {
        System.out.println("------------------------------------------------------");
        System.out.println("Evidence pojištěných");
        System.out.println("------------------------------------------------------");
        System.out.println("Vyber si akci:");
        System.out.println("1 - Přidat nového pojištěnce");
        System.out.println("2 - Vypsat všechny pojištěnce");
        System.out.println("3 - Vyhledat pojištěnce");
        System.out.println("4 - Konec");
    }

    /**
     * Metoda pro přidání nového záznamu do seznamu.
     */
    public void pridejZaznam() {
        System.out.println("------------------------------------------------------");
        // Získání jména od uživatele a kontrola, zda nezadal prázdný jméno
        System.out.println("Zadejte jméno pojištěnce: ");
        String jmeno = sc.nextLine();
        while (jmeno.isEmpty()){
            System.out.println("Zadané jméno je prázdné. Zadejte ho prosím znovu.");
            jmeno = sc.nextLine();
        }
        //  Získání přijmení od uživatele a kontrola, zda nezadal prázdné příjmení
        System.out.println("Zadejte přijmení pojištěnce: ");
        String prijmeni = sc.nextLine();
        while (prijmeni.isEmpty()){
            System.out.println("Zadané příjmení je prázdné. Zadejte ho prosím znovu.");
            prijmeni = sc.nextLine();
        }

        // Získání věku od uživatele a zachycení vyjímky při získávání dat od uživatele
        System.out.println("Zadejte věk pojištěnce: ");
        int vek = -1;
        while(vek == -1) {
            try {
                vek = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Musíte zadat číslo. Zkuste ho prosím zadat znovu");
            }
        }
        // Získání telefonního čísla od uživatele a kontrola správného formátu.
        System.out.println("Zadejte telefonní číslo ve tvaru 123456789: ");
        String telefonniCislo = sc.nextLine();
        while (!zkontrolujTelefonniCislo(telefonniCislo)) {
            telefonniCislo = sc.nextLine();
        }
        // Uložení nového pojištěnce do seznamu
        seznamPojistenych.add(new Pojistenec(jmeno, prijmeni, vek, telefonniCislo));
        System.out.println("Pojištěnec byl uložen");
    }

    /**
     * Metoda pro vypsání všech uložených záznamů v seznamu seznamPojistenych
     */
    public void vypisZaznam(){
        System.out.println("------------------------------------------------------");
        int index = 1;
        for(Pojistenec pojistenec : seznamPojistenych) {
            System.out.printf("%d. %s \n", index, pojistenec);
            index++;
        }
    }

    /**
     * Metoda pro nalezení pojištence v seznamu pojištěnců za pomocí jména a příjmení
     */
    public void vyhledejZaznam() {
        System.out.println("------------------------------------------------------");

        // Získání jména od uživatele, kterého si přeje naleznout
        System.out.println("Zadejte jméno pojištěnce: ");
        String jmeno = sc.nextLine();
        while (jmeno.isEmpty()){
            System.out.println("Zadané jméno je prázdné. Zadejte ho prosím znovu.");
            jmeno = sc.nextLine();
        }

        // Získání příjmení od uživatele, kterého si přeje naleznout
        System.out.println("Zadejte přijmení pojištěnce: ");
        String prijmeni = sc.nextLine();
        while (prijmeni.isEmpty()){
            System.out.println("Zadané příjmení je prázdné. Zadejte ho prosím znovu.");
            prijmeni = sc.nextLine();
        }

        /*
            Foreach cyklus pro projití pojištěnců a hledání pojištěnce, který se shoduje dle zadaného jména i příjmení.
            Následné vypsání a v případě nenalezení pojištěnce informuje pojištěnce.
            Vypíše všechny pojištěnce splňující zadané jméno a příjmení
        */
        Pojistenec nalezenyPojistenec = null;
        for (Pojistenec pojistenec : seznamPojistenych) {
            if ((pojistenec.getJmeno().equals(jmeno)) && (pojistenec.getPrijmeni().equals(prijmeni))) {
                nalezenyPojistenec = pojistenec;
                System.out.println(nalezenyPojistenec);
            }

        }
        if (nalezenyPojistenec == null) {
            System.out.println("Tento pojištěnec není v databázi");
        }
    }

    /**
     * Metoda pro kontrolu správného formátu telefonního čísla. Číslo musí být ve formátu 123456789.
     * @param telefonniCislo Telefonní číslo zadané uživatelem
     * @return  Vrátí true pokud je telefonní číslo ve správném formátu. Jinak vráti false
     */
    public boolean zkontrolujTelefonniCislo (String telefonniCislo) {
        telefonniCislo = telefonniCislo.trim();
        try {
            if (telefonniCislo.length() == 9) {
                for (char znak : telefonniCislo.toCharArray()) {
                    int hodnotaAscii = (int) znak;
                    if ((hodnotaAscii < 47) || (hodnotaAscii > 58)) {
                        throw new IllegalArgumentException("Špatný formát telefonního čísla");
                    }
                }
            } else {
                throw new IllegalArgumentException("Špatný formát telefonního čísla");
            }
            return true;
        } catch (Exception e) {
            System.out.println("Špatný formát telefonního čísla. Zadejte ho prosím bez mezer ve formátu 123456789");
            return false;
        }
    }
}
