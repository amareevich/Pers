import java.util.ArrayList;
import java.util.Random;
import perkpackege.*;

public class Main {

    static ArrayList<Person> red = new ArrayList<>();
    static ArrayList<Person> blue = new ArrayList<>();

    public static void  main (String [] args) {
        createTeam(red, 10, 0);
        createTeam(blue, 10, 3);
 
        Crossbowman cr = new Crossbowman("Алексей", 32, 1, 2);
        Person target = cr.findNearsEnemy(red);
        System.out.println("Ближайший противник" + target);
    }

    public static void createTeam (ArrayList<Person> team, int num, int start) {
        Random rdn = new Random();
        while (--num >= 0) {
            int n = start + rdn.nextInt(4);
            switch (n) {
                case 0:
                team.add(new Crossbowman(getName(), 20, 0, num));
                break;
                case 1:
                team.add(new Magician(getName(), 20, 0, num));
                break;
                case 2:
                team.add(new Spearman(getName(), 20, start * 3, num));
                break;
                case 3:
                team.add(new Peasant(getName(), 20, 0, num));
                break;
                case 4:
                team.add(new Monk(getName(), 20, 9, num));
                break;
                case 5:
                team.add(new Sniper(getName(), 20, 9, num));
                break;
                case 6:
                team.add(new Outlaw(getName(), 20, 9, num));
                break;
            }
        }

    }

    public static String getName () {
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length)]);
    }
}
