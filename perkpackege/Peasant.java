package perkpackege;

import java.util.ArrayList;

//крестьянин
public class Peasant extends Person{
    int arrows;
    boolean ingame = true;

    public Peasant (String name, int age, int x, int y) {
        super(name, age, 20, 100, 50, 20, "not", 20, 1, x, y, 0);
        this.arrows = 100;
    }

    public void giveArrows (int val ) {
        if(!isInGame()) {
            ingame = false;
        }
    }

    public boolean isInGame () {
        return this.arrows == 0 ? true : false;
    }

    @Override
    public String toString() {
        return String.format("[Крестьянин] %s", super.name + " " + position.toString());
    }

    @Override
    public void step(ArrayList<Person> arr) {
        
    }
}
