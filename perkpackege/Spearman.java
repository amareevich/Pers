package perkpackege;
import java.util.ArrayList;
import java.util.Random;

//копейщик
public class Spearman extends Person {

    public Spearman (String name, int age, int x, int y) {
        super(name, 100, 1200, 800, 20, x, y, 2, true);
        this.maxHealth = 1200;
        this.damage = getDamage(damage);
    }

    public void Damage () {

        this.history += this.name + " получил " + this.damage + " урона" + "///";

        Random rdm = new Random();
        double dmg = this.damage * 0.95;

        if (rdm.nextInt(300) == 1) {
            this.defence = 800;
            this.health = this.maxHealth;
            this.power = 300;
            System.out.println (this.name + " " + "получил благословение");
        } else if (this.defence > 0) {
            this.power = this.power;
            this.defence -= dmg;
            this.health -= this.damage - dmg;
        } else {
            this.power = this.power;
            this.health -= this.damage;
        }
    }

    public void attack (Person person) {
        Random rdm = new Random();
        if (rdm.nextInt(20) == 7) {
            person.damage -= this.power * 2;
        };

        person.damage = this.power;
        this.history += this.name + " нанес " + this.damage + " " + person.name + "///";
    }


    @Override
    public String toString() {
        return String.format("[Пикинер] %s", super.name + "❤\uFE0F:" + this.health + " " + "\uD83D\uDEE1\uFE0F:" + this.defence + " " + "\uD834\uDD1C:" + position.toString());
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
            this.defence = 0;
            this.health = 0;
            this.ingame = false;
            return;
        } else {
            Damage();

            Person target = findNearsEnemy(enymies);
            
            if(distanceTo(target) < 2) {
                attack(target);
            } else {
                move(target, friends);
            }
        }
    }

    @Override
    public String getInfo() {
        return "Пикинер";
    }
}