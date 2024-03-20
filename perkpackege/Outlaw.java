package perkpackege;

import java.util.ArrayList;

//разбойник
public class Outlaw extends Person{
    public Outlaw (String name, int age, int x, int y) {
        super(name, age, 20, 100, 50, 20, "knife", 20, 1, x, y, 2);
    }


    @Override
    public String toString() {
        return String.format("[Разбойник] %s", super.name + " " + position.toString());
    }

    @Override
    public void step(ArrayList<Person> arr) {
        
    }
}
