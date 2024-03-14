package perkpackege;
//монах
public class Monk extends Person {
    int mana;
    public Monk (String name, int age, int x, int y) {
        super(name, age, 20, 100, 50, 20, "book", 20,1, x, y);
        this.mana = 40;
    }

    public void attack (Person person) {
        person.health -= this.power;
    }

    public void heal (Person person, int val) {
        person.health += power;
        this.mana -= val;
    }

    public void regeneration (Person person) {
        person.endurance += 20;
        this.mana -= 20;
    }

    @Override
    public String toString() {
        return String.format("[Монах] %s", super.name + " " + position.toString());
    }
}
