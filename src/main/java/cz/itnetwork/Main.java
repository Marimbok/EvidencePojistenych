package cz.itnetwork;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Vytvoření nového objektu třídy PraceSDatabazi
        DatabazePojistence databazePojistence = new DatabazePojistence();

        /**
         * Základní metoda, která drží program v běhu, dokud ji uživatel neukončí.
         * Využívá cyklus while a switch.
         */
        String prikaz = "0";
        while (!prikaz.equals("4")) {
            databazePojistence.vypisMenu();
            System.out.println("------------------------------------------------------");
            prikaz = sc.nextLine();
            switch (prikaz){
                case "1":
                    databazePojistence.pridejZaznam();
                    break;
                case "2":
                    databazePojistence.vypisZaznam();
                    break;

                case "3":
                    databazePojistence.vyhledejZaznam();
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
}
