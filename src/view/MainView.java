package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainView
{
    public MainView() {}

    private String nom;
    private String cognom1;
    private String cognom2;
    private String telefon;
    private String adreça;
    private String edat;
    private String pizza;
    private String massa;
    private String beguda;
    private String extra;
    private List<String> extras = new ArrayList<>();
    private boolean del = false;
    private boolean drink = false;
    private boolean ex = false;

    Scanner read = new Scanner(System.in);

    public void getDadas ()
    {

        //No comprobem les dades ja que presuposem que seran totes correctes
        System.out.println("Welcome to PizziSalle!!");
        System.out.println("DADES DEL CLIENT");
        System.out.print("Nom: ");
        nom = read.nextLine();
        System.out.print("Primer Cognom: ");
        cognom1 = read.nextLine();
        System.out.print("Segon Cognom: ");
        cognom2 = read.nextLine();
        System.out.print("Edat: ");
        edat = read.nextLine();
        System.out.print("Telèfon: ");
        telefon = read.nextLine();
        System.out.print("Adreça de lliurament: ");
        adreça = read.nextLine();
        System.out.println("");
    }

    public void getComanda(String delegacio)
    {
        System.out.println("COMANDA (delegació: "+delegacio+")");

        // Comprovarem si demana una pizza de una altre delegació no pot.
        while(!del)
        {
            System.out.print("Pizza: ");
            pizza = read.nextLine();

            if ((pizza.equals("Barcelona") & !delegacio.equals("Barcelona")) || (pizza.equals("Tarragona") & !delegacio.equals("Tarragona")) ||(pizza.equals("Girona") & !delegacio.equals("Girona")) || (pizza.equals("Lleida") & !delegacio.equals("Lleida")))
            {
                System.out.println("No pots demanar pizzes d'altres delegacions! Estas a " + delegacio);
            } else {
                del = true;
            }
        }

        //No comprobem les demés dades ja que presuposem que seran totes correctes i existents
        System.out.print("Massa: ");
        massa = read.nextLine();

        // Comprovarem si demana una cervesa sent menor no pot.
        while(!drink)
        {
            System.out.print("Beguda: ");
            beguda = read.nextLine();

            if (beguda.equals("Cervesa") & (Integer.parseInt(edat) < 18))
            {
                System.out.println("No pots demanar cerveza si ets menor!");
            } else {
                drink = true;
            }
        }

        // Controlarem els ingredients extra, amb un màxim de 10, si escribim 'no' es que no en volem més.
        int i = 0;
        while(!ex || i == 9)
        {
            System.out.print("Algun ingredient extra?");
            extra = read.nextLine();
            if(extra.equals("no"))
            {
                ex = true;
            } else {
                extras.add(extra);
                i++;
                System.out.print("Que més?");
            }
        }
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

    public String getEdat() {
        return edat;
    }

    public String getPizza() {
        return pizza;
    }

    public String getMassa() {
        return massa;
    }

    public String getBeguda() {
        return beguda;
    }

    public List<String> getExtras() {
        return extras;
    }

    @Override
    public String toString() {
        return "MainView{" +
                "nom='" + nom + '\'' +
                ", cognom1='" + cognom1 + '\'' +
                ", cognom2='" + cognom2 + '\'' +
                ", telefon='" + telefon + '\'' +
                ", adreça='" + adreça + '\'' +
                ", edat='" + edat + '\'' +
                ", pizza='" + pizza + '\'' +
                ", massa='" + massa + '\'' +
                ", beguda='" + beguda + '\'' +
                ", extras=" + extras +
                '}';
    }
}
