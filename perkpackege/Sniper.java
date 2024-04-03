package perkpackege;

import java.util.ArrayList;
import java.util.Random;

//снайпер
public class Sniper extends Person{


    public Sniper (String name, int age, int x, int y) {
        super(name, 120, 400, 800, 200, x, y, 3, true);
        this.maxHealth = 400;
        this.damage = getDamage(damage);
    }

    public void Damage () {

        this.history += this.name + " получил " + this.damage + " урона" + "///";
        Random rdm = new Random();
        if (rdm.nextInt(50) == 7) {
            this.damage = 0;
            System.out.println(this.name + " " + "увернулся от атаки");
        } else {
            double dmg = this.damage * 0.9;
            this.defence -= dmg;
            this.health -= this.damage - dmg;
            if (this.defence < 0) {
                this.health -= this.damage;
            }
        }
    }

    public void attack (Person person) {
        if (this.armor == 0) {
            System.out.println("У" + " " + this.name + " " + "кончились патроны");
            return;
        } else {
            Random rdm = new Random();
            int lucky = rdm.nextInt(200);

            if (lucky == 13) {
                double headshot = person.health;
                double nullDefence = person.defence;

                person.health -= headshot;
                person.defence -=nullDefence;

                System.out.println(person.name + " " + "получил выстрел в голову и умер");
            }

            person.damage = this.power;
            this.armor--;
            this.history += this.name + " нанес " + this.damage + " " + person.name + "///";
        }
    }

    @Override
    public String toString() {
        return String.format("[Снайпер] %s", super.name + "❤\uFE0F:" + this.health + " " + "\uD83D\uDEE1\uFE0F:" + this.defence + " " + "\uD83C\uDFAF:" + this.armor + " "  + "\uD834\uDD1C:" + position.toString());
    }

    public Person findNearsEnemy(ArrayList<Person> enemy) {

        Person target = null;
        double distance = Integer.MAX_VALUE;

        for(Person p : enemy) {
            if (p.ingame != false) {
                double n = p.distanceTo(this);

                if(n < distance) {
                    distance = n;
                    target = p;
                }
            }
        }
        return target;
    }

    @Override
    public void step(ArrayList<Person> enymies, ArrayList<Person> friends) {

        if (this.health <= 0) {
            this.health = 0;
            this.defence = 0;
            this.ingame = false;
            return;
        } else {

            Damage();
            Person target = findNearsEnemy(enymies);
            if(distanceTo(target) < 21) {
                attack(target);
            }
            else {
                return;
            }
        }
    }

    @Override
    public String getInfo() {
        return "Снайпер";
    }
}
