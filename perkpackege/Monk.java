package perkpackege;

import java.util.ArrayList;
import java.util.stream.Collectors;

//монах
public class Monk extends Person {
    
    int mana;
    boolean ingame = true;

    public Monk (String name, int age, int x, int y) {
        super(name, age, 20, 200, 50, 20, "book", 20,1, x, y, 1);
        this.mana = 200;
        this.maxHealth = 200;
    }

    public void inGame (int hp) {
        hp = this.health;
        if (hp <= 0) {
            this.ingame = false;
            System.out.println("Не в игре");
        }
    }

    private int getDied (ArrayList<Person> perk) {
        return (int)perk.stream().filter(n -> n.health == 0).count();
    }

    private void res (ArrayList<Person> perk) {
        if (mana < 50) {
            return;
        }
        Person perks = perk.stream().filter(n -> n.health == 0).sorted((n1, n2) ->  n2.iniciative - n1.iniciative).collect(Collectors.toList()).getFirst();
        perks.healed(Integer.MAX_VALUE);
        mana -= 50;
    }


    @Override
    public String toString() {
        return String.format("[Монах] %s", super.name + " " + position.toString());
    }

    @Override
    public void step(ArrayList<Person> enymies, ArrayList<Person> friends) {
        mana += 5;
        System.out.println(mana);
        Person armorPerk = null;
        int hpMin = Integer.MAX_VALUE;

        if (health <= 0) {
            this.ingame = false;
            return;
        }
        if (mana <= 0) {
            mana += 5;
            return;
        }

        if (getDied(friends) > 3) {
            res(friends);
        }

        for (Person perk : friends) {
            int hp = perk.getHealth();
            if (hp > 0 && hp < perk.maxHealth) {
                hp = hp * 100 / maxHealth;
                if(hp < hpMin) {
                    hpMin = hp;
                    armorPerk = perk;
                }
            }
        }

        if (armorPerk != null) {
            int m = 10;
            mana -= 10;
            if (mana < 0) {
                mana += m;
                mana = 0;
            }
            armorPerk.healed(m * 3);
        }
    }

    @Override
    public String getInfo() {
        return "Монах";
    }


}
