package perkpackege;

import java.util.ArrayList;

//снайпер
public class Sniper extends Person{
    int arrow;
    public Sniper (String name, int age, int x, int y) {
        super(name, age, 20, 100, 50, 20, "arrow", 20, 1, x, y, 3);
        this.arrow = 20;
    }

    public void attack (Person person) {
        person.health -= this.power;
    }

    public void headshot (Person person) {
        person.armor -= person.armor;
    }

    @Override
    public String toString() {
        return String.format("[Снайпер] %s", super.name + " " + position.toString());
    }
    @Override
    public void step(ArrayList<Person> arr) {
        
    }
}
