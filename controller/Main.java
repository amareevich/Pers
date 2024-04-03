package controller;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import view.*;
import perkpackege.*;

public class Main {

    public static ArrayList<Person> darkTeam = new ArrayList<>();
    public static ArrayList<Person> holyTeam = new ArrayList<>();
    public static ArrayList<Person> all = new ArrayList<>();
    public static void  main (String [] args) {
        createTeam(darkTeam, 10, 0);
        createTeam(holyTeam, 10, 3);
        all.addAll(darkTeam);
        all.addAll(holyTeam);

        Scanner nextEntr = new Scanner(System.in);

        while (true) {
            View.view();
            for (Person p : all) {
                if(darkTeam.contains(p)) {
                    p.step(holyTeam,darkTeam);
                } else {
                    p.step(darkTeam,holyTeam);
                }
            }
            nextEntr.nextLine();
            if (!isLiv(holyTeam)) {
                System.out.println("Победила темная сторона");
                nextEntr.close();
            }
            if (!isLiv(darkTeam)) {
                System.out.println("Победила светлая сторона");
                nextEntr.close();
            }
        }
    }

    private static boolean isLiv (ArrayList<Person> perks) {
        for (Person perk : perks) {
            if (perk.getHealth() > 0) {
                return true;
            }
        }
        return false;
    }

    public static void createTeam (ArrayList<Person> team, int num, int start) {
        Random rdn = new Random();
        int cy = 1;
        while (num-- > 0) {
            int n = start + rdn.nextInt(4);
            switch (n) {
                case 0:
                team.add(new Archer(getName(), 20, 1, cy));
                break;
                case 1:
                team.add(new Magician(getName(), 20, 1, cy));
                break;
                case 2:
                team.add(new Spearman(getName(), 20, 1, cy));
                break;
                case 3:
                team.add(new Peasant(getName(), 20, start * 3 + 1, cy));
                break;
                case 4:
                team.add(new Monk(getName(), 20, 10, cy));
                break;
                case 5:
                team.add(new Sniper(getName(), 20, 10, cy));
                break;
                case 6:
                team.add(new Outlaw(getName(), 20, 10, cy));
                break;
            }
            cy++;
        }
    }

    public static String getName () {
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length)]);
    }
}











//git push -u origin main
//getInfo - логи