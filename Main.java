import perkpackege.*;

public class Main {
    public static void  main (String [] args) {
        Peasant peasant = new Peasant("Alexey", 30);
        Sniper sniper = new Sniper("Andrey", 30);
        Outlaw outlaw = new Outlaw("Egor", 30);
        Magician mag = new Magician("Alexsander", 30);
        Crossbowman crossbowman = new Crossbowman("Roman", 30);
        Monk monk = new Monk("Ivan", 30);
        Spearman spearman = new Spearman("Petya", 30);

        System.out.println(peasant);
        System.out.println(sniper);
        System.out.println(spearman);
        System.out.println(outlaw);
        System.out.println(mag);
        System.out.println(crossbowman);
        System.out.println(monk);
    }
}
