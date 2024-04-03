package perkpackege;

import java.util.ArrayList;
import java.util.Random;

//разбойник
public class Outlaw extends Person{

    public Outlaw (String name, int age, int x, int y) {
        super(name, 120, 800, 600, 20, x, y, 2, true);
        this.maxHealth = 800;
        this.damage = getDamage(damage);
    }

    public void attack (Person person) {

        Random rdm = new Random();
        
        if (rdm.nextInt(25) == 7) {
            person.damage -= this.power * 3;
        };

        person.damage = this.power;
        this.history += this.name + " нанес " + this.damage + " " + person.name + "///";
    }

    public void Damage () {

        this.history += this.name + " получил " + this.damage + " урона" + "///";

        Random rdm = new Random();
        double dmg = this.damage * 0.9;
        if (this.defence < 0) {
            this.health -= this.damage;
        } else {
            if (this.health < 30 || rdm.nextInt(10) == 3) {
                this.power = 500;
                System.out.println(this.name + " " + "Увернулся во тьме от атаки");
            } else {
                this.power = this.power;
                this.defence -= dmg;
                this.health -= this.damage - dmg;
            }
        }

    }

    @Override
    public String toString() {
        return String.format("[Разбойник] %s", super.name + "❤\uFE0F:" + this.health + " " + "\uD83D\uDEE1\uFE0F:" + this.defence + " " +  "\uD834\uDD1C:" + position.toString());
    }

    public Person findNearsEnemy(ArrayList<Person> enemy) {
        Person target = null;
        double distance = 500;

        for(Person p : enemy) {
            if (p.ingame != false) {
                double n = distanceTo(this);

                if(n < distance) {
                    distance = n;
                    target = p;
                }
            }
        }
        return target;
    }

    public void move (Person target, ArrayList<Person> friends) {
        Point delta = position.getDelta(target.position);
        Point newPos = new Point(position.getX(), position.getY());

        double dx = delta.getX();
        double dy = delta.getY();

        if (dx != 0) {
            dx = Math.abs(dx) / dx;
        }; 
        if (dy != 0) {
            dy = Math.abs(dy) / dy;
        };
        if (dx != 0 && dy != 0) {
            dy = 0;
        }
        newPos.add(dx,dy);

        for (Person f : friends) {
            f.position.check(newPos); 
        }
        position = newPos;
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

            if(distanceTo(target) < 2) {
                attack(target);
            }
            else {
                move(target, friends);
            }
        }
    }

    @Override
    public String getInfo() {
        return "Разбойник";
    }

}
