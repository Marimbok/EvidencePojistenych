package cz.itnetwork;

import java.util.ArrayList;
import java.util.Scanner;

public class PraceSDatabazi {

    Scanner sc = new Scanner(System.in);
    /**
     * Seznam, do kterého se ukládájí pojištěnci
     */
    private ArrayList<Pojistenec> seznamPojistenych = new ArrayList<>();

    /**
     * Základní metoda, která drží program v běhu, dokud ji uživatel neukončí.
     * Využívá cyklus while a switch.
     */
    public void program() {
        String prikaz = "0";
        while (!prikaz.equals("4")) {
            vypisMenu();
            System.out.println("------------------------------------------------------");
            prikaz = sc.nextLine();
            switch (prikaz){
                case "1":
                    pridejZaznam();
                    break;

                case "2":
                    vypisZaznam();
                    break;

                case "3":
                    vyhledejZaznam();
                    break;

                case "4":
                    System.out.println("Děkuji za využití naší evidence");
                    break;

                default:
                    System.out.println("Zadal jsi neznámou akci. Zadej ji prosím znovu");
                    break;
            }
        }
    }

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
        // Získání telefonního čísla od uživatele, kontrola správného formátu čísla
        //  a zachycení vyjímky při získávání dat od uživatele
        int telefoniCislo = -1;
        System.out.println("Zadejte telefonní číslo pojištěnce(ve tvaru 123456789):  ");
        while (telefoniCislo == -1) {
            try {
                telefoniCislo = Integer.parseInt(sc.nextLine());
                while ((telefoniCislo > 999999999)  || (telefoniCislo < 100000000)) {
                    System.out.println("Zadané telefonní číslo nebylo ve formátu 123456789. Zadejte ho prosím znovu.");
                    telefoniCislo = Integer.parseInt(sc.nextLine());
                }
            } catch (Exception e) {
                System.out.println("Zadané telefonní číslo nebylo ve formátu 123456789. Zadejte ho prosím znovu");
            }
        }
        // Uložení nového pojištěnce do seznamu
        seznamPojistenych.add(new Pojistenec(jmeno, prijmeni, vek, telefoniCislo));
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
     * Metoda pro nalezení pojistence v seznamu pojistencu za pomocí jména a příjmení
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
            }
            System.out.println(nalezenyPojistenec);
        }
        if (nalezenyPojistenec == null) {
            System.out.println("Tento pojistenec není v databázi");
        }
    }
}
