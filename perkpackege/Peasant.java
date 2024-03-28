package perkpackege;

import java.util.ArrayList;

//крестьянин
public class Peasant extends Person{

    int arrows;
    boolean ingame = true;

    public Peasant (String name, int age, int x, int y) {
        super(name, age, 0, 100, 50, 20, "not", 20, 1, x, y, 0);
        this.arrows = 100;
        this.maxHealth = 100;
    }
    public void inGame (int hp) {
        hp = this.health;
        if (hp <= 0) {
            this.ingame = false;
            System.out.println("Не в игре");
        }
    }

    @Override
    public String toString() {
        return String.format("[Крестьянин] %s", super.name + " " + position.toString());
    }
    @Override
    public String getInfo() {
        return "Крестьянин";
    }

    @Override
    public void step(ArrayList<Person> enymies, ArrayList<Person> friends) {

        Person armorPerk = null;
        int armorMin = 10;

        if (health <= 0) {
            this.ingame = false;
            return;
        }
        for (Person perk : friends) {
            if (perk instanceof Archer || perk instanceof Sniper) {
                if (perk.getArmor() < armorMin) {
                    armorMin = perk.getArmor();
                    armorPerk = perk;
                }
            }
        }

        if (armorPerk != null) {
            armorMin += 1;
            armorPerk.setArmor(1);
            arrows--;
        }
    }
}
