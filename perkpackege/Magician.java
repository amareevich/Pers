package perkpackege;

import java.util.ArrayList;

//Колдун
public class Magician extends Person {
    int mana;
    public Magician (String name, int age, int x, int y) {
        super(name, age, 20, 100, 50, 20, "book", 20, 1, x, y, 1);
        this.mana = 20;
    }

    public void attack (Person person) {
        person.health -= this.power;
    }

    @Override
    public String toString() {
        return String.format("[Волшебник] %s", super.name + " " + position.toString());
    }


    protected void shot (Person target) {
        armor -= 10;
    }

    public Person findNearsEnemy(ArrayList<Person> enemy) {
        Person target = null;
        double distance = Integer.MAX_VALUE;

        for(Person p : enemy) {
            double n = p.distanceTo(this);

            if(n < distance) {
                distance = n;
                target = p;
            }
        }

        return target;
    }

    public void move (Person target, ArrayList<Person> friends) {
        Point delta = position.getDelta(target.position);
        Point newPos = new Point(position.getX(), position.getY());

        int dx = delta.getX();
        int dy = delta.getY();

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
        if (health <= 0) {
            return;
        }

        Person target = this.findNearsEnemy(enymies);

        if(distanceTo(target) < 2) {
            attack(target);
        }
        else {
            move(target, friends);
        }
    }

    @Override
    public String getInfo() {
        return "Волшебник";
    }
}
