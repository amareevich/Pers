package perkpackege;

import java.util.ArrayList;

//арбалетчик
public class Crossbowman extends Person {
    int arrow;
    public Crossbowman (String name, int age, int x, int y) {
        super(name, age, 20, 100, 50, 20, "arrow", 20, 1 , x, y);
        this.arrow = 40;
    }

    public void attack (Person person) {
        person.health -= this.power;
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


    @Override
    public String toString() {
        return String.format("[Арбалетчик] %s", super.name + " " + position.toString());
    }
}
