package perkpackege;

import java.util.ArrayList;

//крестьянин
public class Peasant extends Person{
    int arrows;
    boolean ingame = true;

    public Peasant (String name, int age, int x, int y) {
        super(name, age, 0, 100, 50, 20, "not", 20, 1, x, y, 0);
        this.arrows = 100;
    }
    public void giveArrows (int val ) {
        if(!isInGame()) {
            ingame = false;
        }
    }
    public void shot (Person target) {
        target.health -= this.power;
    }

    public boolean isInGame () {
        return this.arrows == 0 ? true : false;
    }
    @Override
    public String toString() {
        return String.format("[Крестьянин] %s", super.name + " " + position.toString());
    }
    @Override
    public String getInfo() {
        return "Крестьянин";
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
            return;
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
            shot(target);
        }
        else {
            move(target, friends);
        }
    }
}
