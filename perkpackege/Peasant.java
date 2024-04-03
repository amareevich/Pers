package perkpackege;

import java.util.ArrayList;

//крестьянин
public class Peasant extends Person{

    int arrows;

    public Peasant (String name, int age, int x, int y) {
        super(name, 0, 300, 300, 20, x, y, 0, true);
        this.arrows = 500;
        this.maxHealth = 300;
        this.damage = getDamage(damage);
    }

    public void Damage () {

        this.history += this.name + " получил " + this.damage + " урона" + "///";

        if (defence < 0) {
            this.health -= this.damage;
        } else {
            double dmg = this.damage * 0.5;
            this.defence -= dmg;
            this.health -= dmg;
        }
    }

    @Override
    public String toString() {
        return String.format("[Холоп] %s", super.name + "❤\uFE0F:" + this.health + " " + "\uD83D\uDEE1\uFE0F:" + this.defence + " " + "\uD83C\uDFF9:" + this.arrows + " "  + "\uD834\uDD1C:" + position.toString());
    }
    
    @Override
    public String getInfo() {
        return "Холоп";
    }

    @Override
    public void step(ArrayList<Person> enymies, ArrayList<Person> friends) {

        if (this.health <= 0) {
            this.defence = 0;
            this.health = 0;
            this.ingame = false;
            return;
        } else {
            Damage();
            Person armorPerk = null;
            int armorMin = 100;

            for (Person perk : friends) {
                if (perk instanceof Archer || perk instanceof Sniper) {
                    if (perk.getArmor() < armorMin) {
                        armorPerk = perk;
                    }
                }
            }
            if (armorPerk != null) {
                armorPerk.setArmor(1);
                this.arrows--;
            }
        }
    }
}
