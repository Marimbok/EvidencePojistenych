package cz.itnetwork;

import java.util.ArrayList;
import java.util.Scanner;

public class PraceSDatabazi {

    Scanner sc = new Scanner(System.in);
    private ArrayList<Pojistenec> seznamPojistenych = new ArrayList<>();
    private Pojistenec pojistenec;

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


    public void pridejZaznam() {
        System.out.println("------------------------------------------------------");
        System.out.println("Zadejte jméno pojištěnce: ");
        String jmeno = sc.nextLine();
        while (jmeno.isEmpty()){
            System.out.println("Zadané jméno je prázdné. Zadejte ho prosím znovu.");
            jmeno = sc.nextLine();
        }

        System.out.println("Zadejte přijmení pojištěnce: ");
        String prijmeni = sc.nextLine();
        while (prijmeni.isEmpty()){
            System.out.println("Zadané příjmení je prázdné. Zadejte ho prosím znovu.");
            prijmeni = sc.nextLine();
        }

        System.out.println("Zadejte věk pojištěnce: ");
        int vek = -1;
        while(vek == -1) {
            try {
                vek = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Musíte zadat číslo. Zkuste ho prosím zadat znovu");
            }
        }
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
        seznamPojistenych.add(new Pojistenec(jmeno, prijmeni, vek, telefoniCislo));
        System.out.println("Pojištěnec byl uložen");
    }

    public void vypisZaznam(){
        System.out.println("------------------------------------------------------");
        int index = 1;
        for(Pojistenec pojistenec : seznamPojistenych) {
            System.out.printf("%d. %s \n", index, pojistenec);
            index++;
        }
    }
    public void vyhledejZaznam() {
        System.out.println("------------------------------------------------------");

        System.out.println("Zadejte jméno pojištěnce: ");
        String jmeno = sc.nextLine();
        while (jmeno.isEmpty()){
            System.out.println("Zadané jméno je prázdné. Zadejte ho prosím znovu.");
            jmeno = sc.nextLine();
        }

        System.out.println("Zadejte přijmení pojištěnce: ");
        String prijmeni = sc.nextLine();
        while (prijmeni.isEmpty()){
            System.out.println("Zadané příjmení je prázdné. Zadejte ho prosím znovu.");
            prijmeni = sc.nextLine();
        }

        Pojistenec nalezenyPojistenec = null;
        for (Pojistenec pojistenec : seznamPojistenych) {
            if ((pojistenec.getJmeno().equals(jmeno)) && (pojistenec.getPrijmeni().equals(prijmeni))) {
                nalezenyPojistenec = pojistenec;
            }
        }
        if (nalezenyPojistenec == null) {
            System.out.println("Tento pojistenec není v databázi");
        } else {
            System.out.println(nalezenyPojistenec);
        }
    }
}
