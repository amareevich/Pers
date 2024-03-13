package perkpackege;
//Колдун
public class Magician extends Person {
    int mana;
    public Magician (String name, int age) {
        super(name, age, 20, 100, 50, 20, "book", 20);
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
        return super.name;
    }
}