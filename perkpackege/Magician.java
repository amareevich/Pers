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

    public void heal (Person person, int val) {
        person.health += power;
        this.mana -= val;
    }

    @Override
    public String toString() {
        return String.format("[Колдун] %s", super.name + " " + position.toString());
    }

    @Override
    public void step(ArrayList<Person> arr, ArrayList<Person> friends) {
        
    }
}
