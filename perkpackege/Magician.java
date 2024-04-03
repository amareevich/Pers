package perkpackege;
import java.util.ArrayList;
import java.util.stream.Collectors;

//Волшебник
public class Magician extends Person {

    int mana;

    public Magician (String name, int age, int x, int y) {
        super(name, 20, 400, 200, 20,  x, y, 1, true);
        this.mana = 200;
        this.maxHealth = 200;
        this.damage = getDamage(damage);
    }

    public void Damage () {

        this.history += this.name + " получил " + this.damage + " урона" + "///";

        if (this.defence < 0) {
            this.health -= this.damage;
        } else {
            double dmg = this.damage * 0.7;
            this.defence -= dmg;
            this.health -= this.damage - dmg;
        }
    }

    private void res (ArrayList<Person> perk) {
        if (mana < 50) {
            return;
        }

        Person perks = perk.stream().filter(n -> n.health == 0).sorted((n1, n2) ->  n2.iniciative - n1.iniciative).collect(Collectors.toList()).getFirst();
        perks.healed(Integer.MAX_VALUE);
        mana -= 50;
    }

    private int getDied (ArrayList<Person> perk) {
        return (int)perk.stream().filter(n -> n.health == 0).count();
    }

    @Override
    public String toString() {
        return String.format("[Волшебник] %s", super.name + " " + "❤\uFE0F:" + this.health + " " + "\uD83D\uDEE1\uFE0F:" + this.defence + " " + "\uD83C\uDF00:" + this.mana + " "  + "\uD834\uDD1C:" + position.toString());
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

            mana += 5;
            Person armorPerk = null;
            double hpMin = Integer.MAX_VALUE;

            if (this.mana <= 0) {
                this.mana += 5;
                return;
            }

            if (getDied(friends) > 4) {
                res(friends);
            }

            for (Person perk : friends) {
                if (perk.ingame != false) {

                    double hp = perk.getHealth();

                    if (hp > 0 && hp < perk.maxHealth) {
                        hp = hp * 100 / maxHealth;
                        if(hp < hpMin) {
                            hpMin = hp;
                            armorPerk = perk;
                        }
                    }
                }
            }

            if (armorPerk != null) {
                int m = 10;
                this.mana -= 10;
                if (mana < 0) {
                   this.mana += m;
                   mana = 0;
                }
                armorPerk.healed(m * 3);
                this.history += this.name + " полечил " + armorPerk.name + "///";
            }
        }
    }

    @Override
    public String getInfo() {
        return "Волшебник";
    }
}
